package com.guk.service.impl;

import com.guk.service.AttackService;
import com.guk.service.PayloadService;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class AttackServiceImpl implements AttackService {
    private PayloadService payloadService;
    private String defenderUrl;
    private RestTemplate restTemplate= new RestTemplate();

    public AttackServiceImpl(PayloadService payloadService,String defenderUrl){
        this.payloadService=payloadService;
        this.defenderUrl=defenderUrl;
        HttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
        HttpMessageConverter stringHttpMessageConverternew = new StringHttpMessageConverter();
        restTemplate.setMessageConverters(Arrays.asList(new HttpMessageConverter[]{formHttpMessageConverter, stringHttpMessageConverternew}));
    }

    @Override
    public void sendPayload(long assessmentId) {

        List<String> payloads= payloadService.getPayload(assessmentId);
        for(String payload:payloads){
            MultiValueMap<String, String> map = new LinkedMultiValueMap();
            map.add("name", payload);
            String result = restTemplate.postForObject(defenderUrl, map, String.class);
            System.out.println(result);

        }
    }
}
