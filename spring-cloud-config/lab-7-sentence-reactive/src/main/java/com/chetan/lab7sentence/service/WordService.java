package com.chetan.lab7sentence.service;

import com.chetan.lab7sentence.domain.Word;
import rx.Observable;

public interface WordService {

	Observable<Word> getSubject();
	Word getVerb();
	Word getArticle();
	Word getAdjective();
	Word getNoun();
	
}
