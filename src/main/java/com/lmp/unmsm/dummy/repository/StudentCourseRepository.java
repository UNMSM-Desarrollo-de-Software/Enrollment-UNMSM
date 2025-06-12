package com.lmp.unmsm.dummy.repository;

import com.lmp.unmsm.dummy.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {

    List<StudentCourse> findByStatusAndStudentEmail(String status, String email);
}
