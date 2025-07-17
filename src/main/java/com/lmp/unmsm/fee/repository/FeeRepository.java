package com.lmp.unmsm.fee.repository;

import com.lmp.unmsm.fee.entity.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeRepository extends JpaRepository<Fee, Integer> {

    List<Fee> findByFeePlanId(int feePlanId);
}
