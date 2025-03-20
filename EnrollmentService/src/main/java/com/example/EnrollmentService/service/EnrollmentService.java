package com.example.EnrollmentService.service;

import com.example.EnrollmentService.dto.EnrollmentDto;

public interface EnrollmentService {
    EnrollmentDto enrollment(Long studentId,Long courseId);
    String updateProgress (Long studentId, Long courseId, int progress);
    Integer getProgress(Long studentId,Long courseId);

}
