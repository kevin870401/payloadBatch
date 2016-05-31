package com.guk.controller;


import com.guk.service.AttackService;
import com.guk.service.PayloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Autowired
    private PayloadService payloadService;

    @Autowired
    private AttackService attackService;

    @Bean
    public PayloadController payloadController(){
        return new PayloadController(payloadService,attackService);
    }
}