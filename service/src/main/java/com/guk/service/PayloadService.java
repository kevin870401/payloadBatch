package com.guk.service;

import com.guk.domain.Assessment;

import java.util.List;

public interface PayloadService {
    List<Assessment> getAssessment();
    List<String> getPayload(long assessmentId);
}
