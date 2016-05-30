package com.guk.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class PayloadAssessmentManager {

    private RestTemplate restTemplate;
    private String sleepyPuppyUrl;
    private ObjectMapper mapper = new ObjectMapper();

    public PayloadAssessmentManager(RestTemplate restTemplate,String sleepyPuppyUrl){
     this.restTemplate=restTemplate;
        this.sleepyPuppyUrl=sleepyPuppyUrl;

    }

    public String getAssessments() {


        String response = restTemplate.getForObject(sleepyPuppyUrl+"/api/assessments", String.class);


        //String result = response.getRandomUserResults().get(0).getRandomUserResultLogin().getUsername();

        return response;
    }


}
