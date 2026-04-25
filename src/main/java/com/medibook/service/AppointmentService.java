package com.medibook.service;

import com.medibook.model.Appointment;
import com.medibook.model.Doctor;
import com.medibook.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public boolean isSlotAvailable(Doctor doctor, LocalDate date, String time) {
        List<Appointment> conflicts = appointmentRepository
                .findByDoctorAndApptDateAndApptTime(doctor, date, time);
        return conflicts.isEmpty();
    }

    public String saveAppointment(Appointment appointment) {
        if (!isSlotAvailable(appointment.getDoctor(), appointment.getApptDate(), appointment.getApptTime())) {
            return "CONFLICT";
        }
        appointmentRepository.save(appointment);
        return "OK";
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
