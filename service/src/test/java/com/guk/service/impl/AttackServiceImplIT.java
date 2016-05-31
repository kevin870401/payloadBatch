package com.guk.service.impl;

import com.guk.config.ServiceContext;
import com.guk.service.AttackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
@ContextConfiguration(classes = {ServiceContext.class})
public class AttackServiceImplIT extends AbstractTestNGSpringContextTests {

    @Autowired
    AttackService attackService;

    @Test
    public void sendPayload() throws Exception {
        attackService.sendPayload(1);
    }
}