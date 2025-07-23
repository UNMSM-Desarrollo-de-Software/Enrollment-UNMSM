package com.lmp.unmsm.enrollment.service;

import com.lmp.unmsm.auth.entity.User;
import com.lmp.unmsm.auth.repository.UserRepository;
import com.lmp.unmsm.enrollment.entity.Enrollment;
import com.lmp.unmsm.enrollment.repository.EnrollmentRepository;
import com.lmp.unmsm.payment.entity.Payment;
import com.lmp.unmsm.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentService paymentService;

    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    public List<Enrollment> findByPeriodAndStudentEmail(String period, String email) {
        return enrollmentRepository.findByPeriodAndStudentEmail(period, email);
    }

    public Optional<Enrollment> findById(int id) {
        return enrollmentRepository.findById(id);
    }

    public Enrollment register(Enrollment enrollment) {
        User user = userRepository.findByEmail(enrollment.getStudent().getEmail());
        enrollment.setStudent(user);
        enrollment.setStatus("1");

        Payment payment = new Payment();
        payment.setAmount(600);
        payment = paymentService.register(payment);

        enrollment.setPayment(payment);
        return enrollmentRepository.save(enrollment);
    }

    public Enrollment update(Enrollment updateEnrollment) {
        Enrollment enrollment = enrollmentRepository.findById(updateEnrollment.getId()).get();
        enrollment.setStatus(updateEnrollment.getStatus());
        enrollment.setPayment(updateEnrollment.getPayment());
        return enrollmentRepository.save(enrollment);
    }
}
