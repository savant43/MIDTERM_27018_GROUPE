package com.hospital.hospital_appointment_system.repository;

import com.hospital.hospital_appointment_system.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByLocationId(Long locationId);
}
