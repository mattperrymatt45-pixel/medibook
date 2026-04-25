package com.medibook.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    @NotNull(message = "Patient is required")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    @NotNull(message = "Doctor is required")
    private Doctor doctor;

    @Column(name = "appt_date", nullable = false)
    @NotNull(message = "Date is required")
    private LocalDate apptDate;

    @Column(name = "appt_time", nullable = false)
    @NotBlank(message = "Time is required")
    private String apptTime;

    public Appointment() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public LocalDate getApptDate() { return apptDate; }
    public void setApptDate(LocalDate apptDate) { this.apptDate = apptDate; }

    public String getApptTime() { return apptTime; }
    public void setApptTime(String apptTime) { this.apptTime = apptTime; }
}
