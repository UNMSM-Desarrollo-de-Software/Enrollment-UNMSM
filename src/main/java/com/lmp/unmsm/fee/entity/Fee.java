package com.lmp.unmsm.fee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lmp.unmsm.payment.entity.Payment;
import jakarta.persistence.*;

@Entity
@Table(name = "fee")
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fee_plan_id")
    private FeePlan feePlan;

    @Column(name = "fee_number")
    private int feeNumber;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FeePlan getFeePlan() {
        return feePlan;
    }

    public void setFeePlan(FeePlan feePlan) {
        this.feePlan = feePlan;
    }

    public int getFeeNumber() {
        return feeNumber;
    }

    public void setFeeNumber(int feeNumber) {
        this.feeNumber = feeNumber;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Fee{" +
                "id=" + id +
                ", feePlan=" + feePlan +
                ", status='" + feeNumber + '\'' +
                ", payment=" + payment +
                '}';
    }
}
