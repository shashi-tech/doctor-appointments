package com.worldhospital.app.ui.model;

import java.math.BigDecimal;

public class AppointmentRest {
	private String id;

	private String createdAt;

	private String appointmentDate;

	private String appointmentStartTime;

	private String appointmentEndTime;

	private String status;

	private BigDecimal price;

	private DoctorRest doctor;

	private UserRest user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentStartTime() {
		return appointmentStartTime;
	}

	public void setAppointmentStartTime(String appointmentStartTime) {
		this.appointmentStartTime = appointmentStartTime;
	}

	public String getAppointmentEndTime() {
		return appointmentEndTime;
	}

	public void setAppointmentEndTime(String appointmentEndTime) {
		this.appointmentEndTime = appointmentEndTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public DoctorRest getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorRest doctor) {
		this.doctor = doctor;
	}

	public UserRest getUser() {
		return user;
	}

	public void setUser(UserRest user) {
		this.user = user;
	}
	
	
}
