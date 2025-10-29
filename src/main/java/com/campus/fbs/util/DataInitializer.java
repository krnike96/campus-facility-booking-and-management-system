package com.campus.fbs.util;

import com.campus.fbs.model.User;
import com.campus.fbs.model.User.UserRole;
import com.campus.fbs.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Creates an initial Admin user when the application starts for the first time.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Check if an admin user already exists to prevent duplicate creation on restarts
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            // IMPORTANT: The password must be encoded!
            admin.setPassword(passwordEncoder.encode("adminpass")); // Simple password for now
            admin.setName("System Administrator");
            admin.setRole(UserRole.ADMIN);

            userRepository.save(admin);
            System.out.println(">>> Initial Admin User Created: username='admin', password='adminpass' <<<");
        }
    }
}