package com.worldhospital.app.persistence;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worldhospital.app.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	List<Appointment> findByDoctorId(long doctorId);
	Optional<Appointment> findByAppointmentDateAndAppointmentStartTime(LocalDate appointmentDate, Time appointmentStartTime);
}
