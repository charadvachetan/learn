package com.chetan.lab6sentence.service;

import com.chetan.lab6sentence.dao.AdjectiveClient;
import com.chetan.lab6sentence.dao.ArticleClient;
import com.chetan.lab6sentence.dao.NounClient;
import com.chetan.lab6sentence.dao.SubjectClient;
import com.chetan.lab6sentence.dao.VerbClient;
import com.chetan.lab6sentence.dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Build a sentence by assembling randomly generated subjects, verbs,
 * articles, adjectives, and nouns.  The individual parts of speech will
 * be obtained by calling the various DAOs.
 */
@Service
public class SentenceServiceImpl implements SentenceService
{

    @Autowired
    private SubjectClient subjectClient;

    @Autowired
    private VerbClient verbClient;

    @Autowired
    private ArticleClient articleClient;

    @Autowired
    private AdjectiveClient adjectiveClient;

    @Autowired
    private NounClient nounClient;


    /**
     * Assemble a sentence by gathering random words of each part of speech:
     */
    public String buildSentence()
    {
        String sentence = "There was a problem assembling the sentence!";
        sentence =
                String.format("%s %s %s %s %s.",
                        subjectClient.getWord(),
                        verbClient.getWord(),
                        articleClient.getWord(),
                        adjectiveClient.getWord(),
                        nounClient.getWord());
        return sentence;
    }

}
