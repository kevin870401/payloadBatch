package com.guk.service.impl;

import com.guk.domain.Assessment;
import com.guk.service.PayloadAssessmentManager;
import com.guk.service.PayloadService;

import java.util.List;

public class PayloadServiceImpl implements PayloadService {

    private PayloadAssessmentManager payloadAssessmentManager;
    public PayloadServiceImpl(PayloadAssessmentManager payloadAssessmentManager) {
        this.payloadAssessmentManager=payloadAssessmentManager;
    }

    @Override
    public List<Assessment> getAssessment() {
        return payloadAssessmentManager.getAssessments();
    }

    @Override
    public List<String> getPayload(long assessmentId) {
        return payloadAssessmentManager.getPayloads(assessmentId);
    }
}
