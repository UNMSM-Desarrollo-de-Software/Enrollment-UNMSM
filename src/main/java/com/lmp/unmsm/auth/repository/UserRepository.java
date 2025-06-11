package com.lmp.unmsm.auth.repository;

import com.lmp.unmsm.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String username);
}
