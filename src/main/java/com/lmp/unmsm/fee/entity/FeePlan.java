package com.lmp.unmsm.fee.entity;

import com.lmp.unmsm.enrollment.entity.Enrollment;
import jakarta.persistence.*;

@Entity
@Table(name = "fee_plan")
public class FeePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;

    @Column(name = "fee_quantity")
    private int feeQuantity;

    @Column(name = "fee_amount")
    private double feeAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public int getFeeQuantity() {
        return feeQuantity;
    }

    public void setFeeQuantity(int feeQuantity) {
        this.feeQuantity = feeQuantity;
    }

    public double getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(double feeAmount) {
        this.feeAmount = feeAmount;
    }

    @Override
    public String toString() {
        return "FeePlan{" +
                "id=" + id +
                ", enrollment=" + enrollment +
                ", feeQuantity=" + feeQuantity +
                ", feeAmount=" + feeAmount +
                '}';
    }
}
