package com.guk.config;

import com.guk.service.AttackService;
import com.guk.service.PayloadAssessmentManager;
import com.guk.service.PayloadService;
import com.guk.service.impl.AttackServiceImpl;
import com.guk.service.impl.PayloadServiceImpl;
import com.guk.service.interceptor.HeaderRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:service.properties")
public class ServiceContext {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    @Value("${url.sleepy.puppy}")
    private String sleepyPuppyUrl;

    @Value("${token.sleepy.puppy}")
    private String sleepyPuppyToken;

    @Value("${url.defender}")
    private String defenderUrl;

    @Bean
    public RestTemplate restTemplate() {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add(new HeaderRequestInterceptor("Accept", MediaType.APPLICATION_JSON_VALUE));
        interceptors.add(new HeaderRequestInterceptor("Token", sleepyPuppyToken));
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

    @Bean
    public PayloadAssessmentManager payloadAssessmentManager() {
        return new PayloadAssessmentManager(restTemplate(), sleepyPuppyUrl);
    }

    @Bean
    public PayloadService payloadService() {
        return new PayloadServiceImpl(payloadAssessmentManager());
    }

    @Bean
    public AttackService attackService(){
        return new AttackServiceImpl(payloadService(),defenderUrl);
    }

}
