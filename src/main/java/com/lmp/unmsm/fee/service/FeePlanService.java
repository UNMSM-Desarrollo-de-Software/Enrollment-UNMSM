package com.lmp.unmsm.fee.service;

import com.lmp.unmsm.fee.entity.Fee;
import com.lmp.unmsm.fee.entity.FeePlan;
import com.lmp.unmsm.fee.repository.FeePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeePlanService {

    @Autowired
    private FeePlanRepository feePlanRepository;

    @Autowired
    private FeeService feeService;

    public List<FeePlan> findByEnrollmentId(int enrollmentId) {
        return feePlanRepository.findByEnrollmentId(enrollmentId);
    }

    public Optional<FeePlan> findById(int id) {
        return feePlanRepository.findById(id);
    }

    public FeePlan register(FeePlan feePlan) {
        feePlan = feePlanRepository.save(feePlan);

        for (int i = 1; i <= feePlan.getFeeQuantity(); i++) {
            Fee fee = new Fee();
            fee.setFeePlan(feePlan);
            fee.setFeeNumber(i);
            feeService.register(fee);
        }

        return feePlan;
    }
}
