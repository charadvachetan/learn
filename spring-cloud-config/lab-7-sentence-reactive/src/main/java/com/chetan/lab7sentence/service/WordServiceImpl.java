package com.chetan.lab7sentence.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chetan.lab7sentence.dao.AdjectiveClient;
import com.chetan.lab7sentence.dao.ArticleClient;
import com.chetan.lab7sentence.dao.NounClient;
import com.chetan.lab7sentence.dao.SubjectClient;
import com.chetan.lab7sentence.dao.VerbClient;
import com.chetan.lab7sentence.domain.Word;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.Executor;

@Service
public class WordServiceImpl implements WordService
{
    @Autowired
    private VerbClient verbClient;

    @Autowired
    private SubjectClient subjectClient;

    @Autowired
    private ArticleClient articleClient;

    @Autowired
    private AdjectiveClient adjectiveClient;

    @Autowired
    private NounClient nounClient;

    @Autowired
    private Executor executor;

    @Override
    @HystrixCommand(fallbackMethod = "getSubjectFallback")
    public Observable<Word> getSubject()
    {
        return Observable.fromCallable(
                () -> new Word(subjectClient.getWord(), Word.Role.subject)
        ).subscribeOn(Schedulers.from(executor));
    }

    public Word getSubjectFallback()
    {
        return new Word("Someone");
    }

    @Override
    public Word getVerb()
    {
        return new Word(verbClient.getWord());
    }

    @Override
    public Word getArticle()
    {
        return new Word(articleClient.getWord());
    }

    @Override
    @HystrixCommand(fallbackMethod = "getAdjectiveFallback")
    public Word getAdjective()
    {
        return new Word(adjectiveClient.getWord());
    }

    public Word getAdjectiveFallback()
    {
        return new Word("");
    }

    @Override
    @HystrixCommand(fallbackMethod = "getNounFallback")
    public Word getNoun()
    {
        return new Word(nounClient.getWord());
    }

    public Word getNounFallback()
    {
        return new Word("something");
    }
}
