package com.guk.service;

import com.guk.config.ServiceContext;
import com.guk.domain.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

@ContextConfiguration(classes = {ServiceContext.class})
public class PayloadAssessmentManagerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    PayloadAssessmentManager payloadAssessmentManager;

    @Test
    public void testGetAssessments() {
        List<Assessment> result = payloadAssessmentManager.getAssessments();
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void payloadAssessmentManager_assessment1_7() {
        List result = payloadAssessmentManager.getPayloads(1);
        assertThat(result.size()).isEqualTo(7);
    }

    @Test
    public void getPuppyScripts() {
        String result = payloadAssessmentManager.getPuppyScripts();
        assertThat(result).isEqualTo("");
    }
}