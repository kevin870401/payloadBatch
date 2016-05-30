package com.guk.service;

import com.guk.config.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;
@ContextConfiguration(classes = {ServiceContext.class})
public class PayloadAssessmentManagerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    PayloadAssessmentManager payloadAssessmentManager;

    @Test
    public void testGetAssessments(){
        String result= payloadAssessmentManager.getAssessments();
assertThat(result).isEqualTo("");
    }
}