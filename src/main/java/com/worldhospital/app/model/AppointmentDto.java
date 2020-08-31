package com.worldhospital.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

public class AppointmentDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7562077906878021022L;

	private long id;

	private Timestamp createdAt;

	private LocalDate appointmentDate;

	private Time appointmentStartTime;

	private Time appointmentEndTime;

	private AppointmentStatus status;

	private BigDecimal price;

	private DoctorDto doctor;

	private UserDto user;
	
	public AppointmentDto() {}

	public AppointmentDto(LocalDate appointmentDate, Time appointmentStartTime, Time appointmentEndTime,
			BigDecimal price, DoctorDto doctor, UserDto user) {
		this.appointmentDate = appointmentDate;
		this.appointmentStartTime = appointmentStartTime;
		this.appointmentEndTime = appointmentEndTime;
		this.price = price;
		this.doctor = doctor;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Time getAppointmentStartTime() {
		return appointmentStartTime;
	}

	public void setAppointmentStartTime(Time appointmentStartTime) {
		this.appointmentStartTime = appointmentStartTime;
	}

	public Time getAppointmentEndTime() {
		return appointmentEndTime;
	}

	public void setAppointmentEndTime(Time appointmentEndTime) {
		this.appointmentEndTime = appointmentEndTime;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public DoctorDto getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDto doctor) {
		this.doctor = doctor;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

}
