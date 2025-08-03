package com.lmp.unmsm.fee.repository;

import com.lmp.unmsm.fee.entity.FeePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeePlanRepository extends JpaRepository<FeePlan, Integer> {

    List<FeePlan> findByEnrollmentId(int enrollmentId);
}
