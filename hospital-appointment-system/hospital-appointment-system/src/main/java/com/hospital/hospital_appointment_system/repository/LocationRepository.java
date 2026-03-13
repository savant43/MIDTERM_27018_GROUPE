package com.hospital.hospital_appointment_system.repository;

import com.hospital.hospital_appointment_system.model.Location;
import com.hospital.hospital_appointment_system.model.LocationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByType(LocationType type);
    List<Location> findByParentLocationId(Long parentId);
}
