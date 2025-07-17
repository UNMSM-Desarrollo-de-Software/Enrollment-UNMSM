package com.lmp.unmsm.enrollment.repository;

import com.lmp.unmsm.enrollment.entity.EnrollmentSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentSectionRepository extends JpaRepository<EnrollmentSection, Integer> {

    List<EnrollmentSection> findByEnrollmentId(int enrollmentId);
}
