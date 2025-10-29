package com.campus.fbs.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Represents a user in the system (Student, Staff, or Admin).
 * Uses Lombok's @Data annotation to automatically generate boilerplate code.
 */
@Entity
@Table(name = "users")
@Data // Generates getters, setters, toString, etc.
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username; // Unique identifier for login (e.g., student ID, staff email)

    @Column(nullable = false)
    private String password; // Hashed password

    @Column(nullable = false)
    private String name; // User's full name

    // Role-based access: STUDENT, STAFF, ADMIN
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    // Enum for defining user roles
    public enum UserRole {
        STUDENT,
        STAFF,
        ADMIN
    }
}
