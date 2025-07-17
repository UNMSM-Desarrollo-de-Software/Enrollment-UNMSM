package com.lmp.unmsm.enrollment.repository;

import com.lmp.unmsm.enrollment.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

    List<Enrollment> findByStudentEmail(String email);
    List<Enrollment> findByPeriodAndStudentEmail(String email, String period);
}
