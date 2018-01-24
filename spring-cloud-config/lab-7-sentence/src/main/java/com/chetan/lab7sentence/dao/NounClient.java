package com.chetan.lab7sentence.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.chetan.lab7sentence.domain.Word;

@FeignClient("NOUN")
public interface NounClient {

	@GetMapping("/")
	String getWord();
	
}
