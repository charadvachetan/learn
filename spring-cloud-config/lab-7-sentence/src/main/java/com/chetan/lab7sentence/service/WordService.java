package com.chetan.lab7sentence.service;

import com.chetan.lab7sentence.domain.Word;

public interface WordService {

	Word getSubject();
	Word getVerb();
	Word getArticle();
	Word getAdjective();
	Word getNoun();
	
}
