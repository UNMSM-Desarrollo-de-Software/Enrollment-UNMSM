package com.lmp.unmsm.auth.repository;

import com.lmp.unmsm.auth.entity.ResetPasswordToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResetPasswordTokenRepository extends JpaRepository<ResetPasswordToken, String> {
}
