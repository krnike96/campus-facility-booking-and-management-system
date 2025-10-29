package com.campus.fbs.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Represents a bookable facility on campus (Classroom, Hall, Lab, Auditorium).
 */
@Entity
@Table(name = "facilities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // e.g., "Seminar Hall A", "Lab 101"

    @Column(nullable = false)
    private String location; // e.g., "Building 3, 2nd Floor"

    private int capacity;

    // Type of facility: CLASSROOM, LAB, AUDITORIUM, SEMINAR_HALL
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FacilityType type;

    private String description;

    // Enum for defining facility types
    public enum FacilityType {
        CLASSROOM,
        LAB,
        AUDITORIUM,
        SEMINAR_HALL
    }
}
