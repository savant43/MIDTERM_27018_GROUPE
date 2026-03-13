package com.hospital.hospital_appointment_system.service;

import com.hospital.hospital_appointment_system.model.Location;
import com.hospital.hospital_appointment_system.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + id));
    }

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location updateLocation(Long id, Location updatedLocation) {
        Location existing = getLocationById(id);
        existing.setName(updatedLocation.getName());
        existing.setType(updatedLocation.getType());
        existing.setParentLocation(updatedLocation.getParentLocation());
        return locationRepository.save(existing);
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
