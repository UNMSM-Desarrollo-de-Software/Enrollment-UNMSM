package com.lmp.unmsm.fee.controller;

import com.lmp.unmsm.fee.entity.FeePlan;
import com.lmp.unmsm.fee.service.FeePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fee-plans")
public class FeePlanController {

    @Autowired
    private FeePlanService feePlanService;

    @GetMapping
    public List<FeePlan> findByEnrollmentId(@RequestParam("enrollmentId") int enrollmentId) {
        return feePlanService.findByEnrollmentId(enrollmentId);
    }

    @GetMapping("/{id}")
    public Optional<FeePlan> findById(@PathVariable int id) {
        return feePlanService.findById(id);
    }

    @PostMapping
    public FeePlan register(@RequestBody FeePlan feePlan) {
        return feePlanService.register(feePlan);
    }
}
