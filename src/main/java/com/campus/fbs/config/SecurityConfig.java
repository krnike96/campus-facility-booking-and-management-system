package com.campus.fbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 1. Password Encoder Bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCrypt is the standard, secure way to hash passwords
        return new BCryptPasswordEncoder();
    }

    // 2. Security Filter Chain Configuration
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Configure authorization rules
                .authorizeHttpRequests(auth -> auth
                        // Allow public access to static resources (CSS, JS)
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()
                        // Define protected URLs: only ADMIN can access facility and user management
                        .requestMatchers("/admin/**", "/facilities/add", "/users/**").hasAuthority("ADMIN")
                        // All other requests (like the home page) require authentication
                        .anyRequest().authenticated()
                )
                // Configure the login process
                .formLogin(form -> form
                        .loginPage("/login") // Specify our custom login page URL
                        .defaultSuccessUrl("/dashboard", true) // Redirect after successful login
                        .permitAll() // Allow everyone to see the login page
                )
                // Configure the logout process
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout") // Redirect after successful logout
                        .permitAll()
                );

        return http.build();
    }
}