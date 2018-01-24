package com.chetan.lab6sentence.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.client.RestTemplate;

import com.chetan.lab6sentence.domain.Word;


public abstract class WordDaoImpl implements WordDao
{

    @Autowired
    LoadBalancerClient loadBalancer;

    public abstract String getPartOfSpeech();

    public Word getWord()
    {
        ServiceInstance instance = loadBalancer.choose(getPartOfSpeech());
        String word = (new RestTemplate()).getForObject(instance.getUri(), String.class);
        return new Word(word);
    }

}
