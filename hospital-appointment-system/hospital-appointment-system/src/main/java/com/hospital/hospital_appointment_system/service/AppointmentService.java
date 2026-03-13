package com.hospital.hospital_appointment_system.service;

import com.hospital.hospital_appointment_system.model.Appointment;
import com.hospital.hospital_appointment_system.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        Appointment existing = getAppointmentById(id);
        existing.setPatient(updatedAppointment.getPatient());
        existing.setDoctor(updatedAppointment.getDoctor());
        existing.setAppointmentDateTime(updatedAppointment.getAppointmentDateTime());
        existing.setReason(updatedAppointment.getReason());
        existing.setStatus(updatedAppointment.getStatus());
        return appointmentRepository.save(existing);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
