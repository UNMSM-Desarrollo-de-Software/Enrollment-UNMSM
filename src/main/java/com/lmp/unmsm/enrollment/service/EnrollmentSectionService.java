package com.lmp.unmsm.enrollment.service;

import com.lmp.unmsm.enrollment.entity.EnrollmentSection;
import com.lmp.unmsm.enrollment.repository.EnrollmentSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentSectionService {

    @Autowired
    private EnrollmentSectionRepository enrollmentSectionRepository;

    public List<EnrollmentSection> findByEnrollmentId(int enrollmentId) {
        return enrollmentSectionRepository.findByEnrollmentId(enrollmentId);
    }

    public EnrollmentSection register(EnrollmentSection enrollmentSection) {
        return enrollmentSectionRepository.save(enrollmentSection);
    }
}
