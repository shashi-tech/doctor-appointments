package com.worldhospital.app.service;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.worldhospital.app.entity.Appointment;
import com.worldhospital.app.entity.Doctor;
import com.worldhospital.app.entity.User;
import com.worldhospital.app.persistence.AppointmentRepository;
import com.worldhospital.app.persistence.DoctorRepository;
import com.worldhospital.app.persistence.UserRepository;

@Component
public class LoadDataCommandLineRunner implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDataCommandLineRunner.class);
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public void run(String... args) throws Exception {
		Doctor doctor = new Doctor("Thomas Walker", 32, "MBBS, Post Graduate Diploma in Endocrinology, PG Diploma In Emergency Trauma Care", "General Physician", 19);
		doctorRepository.save(doctor);
		log.info("inserted doctor data in table");
		
		User user = new User("Harry", "harry@test.com", "123456789");
		userRepository.save(user);
		log.info("inserted user data in table");
		
		Appointment appointment = new Appointment(LocalDate.of(2019, 2, 3), Time.valueOf("11:00:00"),  Time.valueOf("12:00:00"), new BigDecimal(90), doctor, user);
		appointmentRepository.save(appointment);
		log.info("inserted appointment data in table");
		
		Optional<Appointment> fixedAppointment = appointmentRepository.findByAppointmentDateAndAppointmentStartTime(LocalDate.of(2019, 2, 3), Time.valueOf("11:00:00"));
		log.info("Appointment by date and time " + (fixedAppointment.isPresent() ? "This time slot has already been taken" : "Slot is available"));
	}

}
