package com.lmp.unmsm.dummy.service;

import com.lmp.unmsm.dummy.entity.StudentCourse;
import com.lmp.unmsm.dummy.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {

    @Autowired
    private StudentCourseRepository repository;

    public List<StudentCourse> findByStatusAndStudentEmail(String status, String email) {
        return repository.findByStatusAndStudentEmail(status, email);
    }
}
