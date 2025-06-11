package com.lmp.unmsm.auth.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "account_verification")
public class AccountVerification {
    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
