package com.campus.fbs.repository;

import com.campus.fbs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repository for User entity, providing basic CRUD operations.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query method required for Spring Security login process
    Optional<User> findByUsername(String username);
}
