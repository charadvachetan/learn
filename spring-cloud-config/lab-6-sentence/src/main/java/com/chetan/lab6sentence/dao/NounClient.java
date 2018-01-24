package com.chetan.lab6sentence.dao;

import com.chetan.lab6sentence.domain.Word;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.chetan.lab6sentence.dao.WordDao.NOUN;

@FeignClient(name = NOUN)
public interface NounClient
{
    @RequestMapping(method = RequestMethod.GET, value = "/")
    String getWord();
}
