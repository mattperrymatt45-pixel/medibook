package com.medibook.controller;

import com.medibook.model.Appointment;
import com.medibook.model.Doctor;
import com.medibook.model.Patient;
import com.medibook.service.AppointmentService;
import com.medibook.service.DoctorService;
import com.medibook.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public String listAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("newAppointment", new Appointment());
        return "appointments/list";
    }

    @PostMapping("/add")
    public String addAppointment(@RequestParam Long patientId,
                                  @RequestParam Long doctorId,
                                  @RequestParam String apptDate,
                                  @RequestParam String apptTime,
                                  RedirectAttributes redirectAttributes) {
        Appointment appointment = new Appointment();
        Patient patient = patientService.getPatientById(patientId);
        Doctor doctor = doctorService.getDoctorById(doctorId);

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setApptDate(java.time.LocalDate.parse(apptDate));
        appointment.setApptTime(apptTime);

        String result = appointmentService.saveAppointment(appointment);
        if ("CONFLICT".equals(result)) {
            redirectAttributes.addFlashAttribute("error",
                    "This doctor already has an appointment at that date and time!");
        }
        return "redirect:/appointments";
    }

    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments";
    }
}
