package com.lmp.unmsm.enrollment.controller;

import com.lmp.unmsm.enrollment.entity.Enrollment;
import com.lmp.unmsm.enrollment.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public Enrollment register(@RequestBody Enrollment enrollment) {
        return enrollmentService.register(enrollment);
    }

    @PutMapping("/{id}")
    public Enrollment update(@PathVariable int id, @RequestBody Enrollment enrollment) {
        enrollment.setId(id);
        return enrollmentService.update(enrollment);
    }

    @GetMapping
    public List<Enrollment> findByPeriodAndStudentEmail(@RequestParam("period") String period, @RequestParam("email") String email) {
        return enrollmentService.findByPeriodAndStudentEmail(period, email);
    }

}