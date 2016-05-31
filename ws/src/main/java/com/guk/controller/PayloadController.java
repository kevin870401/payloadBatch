package com.guk.controller;

import com.guk.service.AttackService;
import com.guk.service.PayloadService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping(value = "/")
public class PayloadController {

    private PayloadService payloadService;
    private AttackService attackService;
    public PayloadController(PayloadService payloadService, AttackService attackService) {
        this.payloadService=payloadService;
        this.attackService=attackService;
    }

    @RequestMapping(value = {"assessment"},method = RequestMethod.GET)
    @ResponseBody
    public List getAllAssessments() {
        return payloadService.getAssessment();
    }

    @RequestMapping(value="/payloadByAssessmentId/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List getPayloads(
            @PathVariable("id") int id) {
        return payloadService.getPayload(id);
    }

    @RequestMapping(value="/sendPayloadsByAssessmentId/{id}", method = RequestMethod.GET)
    public void sendPayloads(
            @PathVariable("id") int id) {
        attackService.sendPayload(id);
    }
}
