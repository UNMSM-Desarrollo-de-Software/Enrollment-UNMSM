package com.lmp.unmsm.payment.service;

import com.lmp.unmsm.payment.entity.Payment;
import com.lmp.unmsm.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> findById(int id) {
        return paymentRepository.findById(id);
    }

    public Payment register(Payment payment) {
        payment.setStatus("REGISTERED");
        return paymentRepository.save(payment);
    }

    public Payment update(int id) {
        Payment payment = paymentRepository.findById(id).get();
        payment.setStatus("PAID");
        return paymentRepository.save(payment);
    }
}