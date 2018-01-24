package com.chetan.lab6sentence.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.chetan.lab6sentence.dao.WordDao.ADJECTIVE;
import static com.chetan.lab6sentence.dao.WordDao.ARTICLE;

@FeignClient(name = ARTICLE)
public interface ArticleClient
{
    @RequestMapping(method = RequestMethod.GET, value = "/")
    String getWord();
}
