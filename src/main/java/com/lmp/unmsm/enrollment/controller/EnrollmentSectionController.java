package com.lmp.unmsm.enrollment.controller;

import com.lmp.unmsm.enrollment.entity.EnrollmentSection;
import com.lmp.unmsm.enrollment.service.EnrollmentSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment-sections")
public class EnrollmentSectionController {

    @Autowired
    private EnrollmentSectionService enrollmentSectionService;

    @PostMapping
    public EnrollmentSection register(@RequestBody EnrollmentSection enrollmentSection) {
        return enrollmentSectionService.register(enrollmentSection);
    }

    @GetMapping
    public List<EnrollmentSection> findByEnrollmentId(@RequestParam("enrollmentId") int enrollmentId) {
        return enrollmentSectionService.findByEnrollmentId(enrollmentId);
    }
}