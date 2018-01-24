package com.chetan.lab6sentence.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.chetan.lab6sentence.dao.WordDao.ARTICLE;
import static com.chetan.lab6sentence.dao.WordDao.SUBJECT;

@FeignClient(name = SUBJECT)
public interface SubjectClient
{
    @RequestMapping(method = RequestMethod.GET, value = "/")
    String getWord();
}
