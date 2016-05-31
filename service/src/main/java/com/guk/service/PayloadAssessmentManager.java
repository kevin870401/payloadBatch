package com.guk.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guk.domain.Assessment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class PayloadAssessmentManager {

    private RestTemplate restTemplate;
    private String sleepyPuppyUrl;
    private ObjectMapper mapper = new ObjectMapper();

    public PayloadAssessmentManager(RestTemplate restTemplate,String sleepyPuppyUrl){
     this.restTemplate=restTemplate;
        this.sleepyPuppyUrl=sleepyPuppyUrl;

    }

    public List getAssessments() {

        ResponseEntity<Assessment[]> responseEntity = restTemplate.getForEntity(sleepyPuppyUrl+"/api/assessments", Assessment[].class);
        Assessment[] assessments =responseEntity.getBody();
        return Arrays.asList(assessments);
    }

    public String getPuppyScripts() {
        String response = restTemplate.getForObject(sleepyPuppyUrl+"/api/puppyscript", String.class);
        return response;
    }
    public List getPayloads(long assessmentId) {


        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity(sleepyPuppyUrl+"/api/assessment_payloads/"+assessmentId, String[].class);
        String[] payloads =responseEntity.getBody();
        return Arrays.asList(payloads);
    }

}
