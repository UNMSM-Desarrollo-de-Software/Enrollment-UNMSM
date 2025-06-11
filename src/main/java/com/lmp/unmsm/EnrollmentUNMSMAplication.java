package com.lmp.unmsm;

import com.lmp.unmsm.auth.config.BearerTokenAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EnrollmentUNMSMAplication {

    @Autowired
    BearerTokenAuthenticationProvider bearerTokenAuthenticationProvider;

    public static void main(String[] args) {
        SpringApplication.run(EnrollmentUNMSMAplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return new ProviderManager(bearerTokenAuthenticationProvider);
    }
}
