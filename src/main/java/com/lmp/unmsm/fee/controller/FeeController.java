package com.lmp.unmsm.fee.controller;

import com.lmp.unmsm.fee.entity.Fee;
import com.lmp.unmsm.fee.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fees")
public class FeeController {

    @Autowired
    private FeeService feeService;

    @GetMapping
    public List<Fee> findByFeePlanId(@RequestParam("feePlanId") int feePlanId) {
        return feeService.findByFeePlanId(feePlanId);
    }

    @PostMapping
    public Fee register(@RequestBody Fee fee) {
        return feeService.register(fee);
    }
}