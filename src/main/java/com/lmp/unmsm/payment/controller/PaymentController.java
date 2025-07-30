package com.lmp.unmsm.payment.controller;

import com.lmp.unmsm.payment.entity.Payment;
import com.lmp.unmsm.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> findAll() {
        return paymentService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Payment> findById(@PathVariable int id) {
        return paymentService.findById(id);
    }

    @PostMapping
    public Payment register(@RequestBody Payment payment) {
        return paymentService.register(payment);
    }

    @PutMapping("/{id}")
    public Payment update(@PathVariable int id) {
        return paymentService.update(id);
    }
}