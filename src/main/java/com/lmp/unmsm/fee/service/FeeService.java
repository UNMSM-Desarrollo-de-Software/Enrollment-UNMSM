package com.lmp.unmsm.fee.service;

import com.lmp.unmsm.fee.entity.Fee;
import com.lmp.unmsm.fee.repository.FeeRepository;
import com.lmp.unmsm.payment.entity.Payment;
import com.lmp.unmsm.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeService {

    @Autowired
    private FeeRepository feeRepository;

    @Autowired
    private PaymentService paymentService;

    public List<Fee> findByFeePlanId(int feePlanId) {
        return feeRepository.findByFeePlanId(feePlanId);
    }

    public Fee register(Fee fee) {
        Payment payment = new Payment();
        payment.setAmount(fee.getFeePlan().getFeeAmount());
        payment = paymentService.register(payment);
        fee.setPayment(payment);
        return feeRepository.save(fee);
    }
}