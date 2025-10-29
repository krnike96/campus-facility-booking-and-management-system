package com.campus.fbs.repository;

import com.campus.fbs.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Facility entity, providing basic CRUD operations.
 */
public interface FacilityRepository extends JpaRepository<Facility, Long> {
    // Basic JpaRepository methods (save, findAll, findById) are inherited.
}
