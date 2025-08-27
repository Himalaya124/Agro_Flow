// src/main/java/com/agroflow/agroflow/config/SecurityConfig.java
package com.AgroFlow.AgroFlow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration          // <-- tells Spring to process this class
public class SecurityConfig {

    @Bean               // <-- registers the return value in the context
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();   // strength-10 hash
    }
}
