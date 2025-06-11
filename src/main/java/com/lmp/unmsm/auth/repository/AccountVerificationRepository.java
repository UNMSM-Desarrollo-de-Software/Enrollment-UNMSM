package com.lmp.unmsm.auth.repository;

import com.lmp.unmsm.auth.entity.AccountVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountVerificationRepository extends JpaRepository<AccountVerification, String> {
}
