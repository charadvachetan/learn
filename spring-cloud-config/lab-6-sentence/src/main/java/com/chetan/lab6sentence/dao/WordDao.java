package com.chetan.lab6sentence.dao;

import com.chetan.lab6sentence.domain.Word;


public interface WordDao {

	static final String SUBJECT = "SUBJECT";
	static final String VERB = "VERB";
	static final String ARTICLE = "ARTICLE";
	static final String ADJECTIVE = "ADJECTIVE";
	static final String NOUN = "NOUN";
	
	Word getWord();
	
}
