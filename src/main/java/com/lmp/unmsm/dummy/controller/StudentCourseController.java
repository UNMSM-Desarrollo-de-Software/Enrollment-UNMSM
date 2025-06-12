package com.lmp.unmsm.dummy.controller;

import com.lmp.unmsm.dummy.entity.StudentCourse;
import com.lmp.unmsm.dummy.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enrollment-courses")
public class StudentCourseController {

    @Autowired
    private StudentCourseService service;

    @GetMapping
    public List<StudentCourse> findByStatusAndStudentEmail
            (@RequestParam("status") String status, @RequestParam("email") String email) {
        return service.findByStatusAndStudentEmail(status, email);
    }

}
