# MediBook – Hospital Appointment Management System

A full-stack web application built with **Spring Boot**, **Thymeleaf**, and **MySQL** for managing hospital patients, doctors, and appointment scheduling.

---

## 🏥 Features

- **Patient Management** – Add, view, and delete patients
- **Doctor Management** – Add, view, and delete doctors with specialization and room info
- **Appointment Booking** – Book appointments with real-time slot conflict detection
- **SweetAlert2 Popups** – Confirmation dialogs before any delete action
- **Responsive UI** – Bootstrap 5 based clean interface

---

## 🛠 Tech Stack

| Layer      | Technology                          |
|------------|-------------------------------------|
| Backend    | Java 17, Spring Boot 3.2            |
| Frontend   | Thymeleaf, HTML, CSS, Bootstrap 5   |
| Database   | MySQL                               |
| ORM        | Spring Data JPA (Hibernate)         |

---

## ⚙️ Setup & Run Locally

### Prerequisites
- Java 17+
- Maven 3.8+
- MySQL 8+

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/YOUR_USERNAME/medibook.git
   cd medibook
   ```

2. **Create the MySQL database**
   ```sql
   CREATE DATABASE medibook_db;
   ```

3. **Configure credentials** in `src/main/resources/application.properties`
   ```properties
   spring.datasource.username=root
   spring.datasource.password=your_password_here
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

5. **Open in browser**
   ```
   http://localhost:8080
   ```

---

## 📁 Project Structure

```
medibook/
├── src/main/java/com/medibook/
│   ├── MedibookApplication.java
│   ├── controller/
│   │   ├── HomeController.java
│   │   ├── PatientController.java
│   │   ├── DoctorController.java
│   │   └── AppointmentController.java
│   ├── model/
│   │   ├── Patient.java
│   │   ├── Doctor.java
│   │   └── Appointment.java
│   ├── repository/
│   │   ├── PatientRepository.java
│   │   ├── DoctorRepository.java
│   │   └── AppointmentRepository.java
│   └── service/
│       ├── PatientService.java
│       ├── DoctorService.java
│       └── AppointmentService.java
├── src/main/resources/
│   ├── templates/
│   │   ├── patients/list.html
│   │   ├── doctors/list.html
│   │   └── appointments/list.html
│   ├── static/
│   │   ├── css/style.css
│   │   └── js/app.js
│   └── application.properties
└── pom.xml
```

---

## 👥 Project By

- Aadit Shah – 60017230097
- Rihen Moradia – 60017230091
- Risha Desai – 60017230103

**Guide:** Prof. Akshaya Prabhu  
**Department:** AI & ML, DJSCE | Academic Year 2025–26
