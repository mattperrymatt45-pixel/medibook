package com.medibook.repository;

import com.medibook.model.Appointment;
import com.medibook.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorAndApptDateAndApptTime(Doctor doctor, LocalDate date, String time);
}
