package com.worldhospital.app.ui.model;

import java.math.BigDecimal;

public class AppointmentRequestModel {
	private String appointmentDate;

	private String appointmentStartTime;

	private String appointmentEndTime;

	private String status;

	private String price;

	private DoctorRequestModel doctor;

	private UserRequestModel user;

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public DoctorRequestModel getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorRequestModel doctor) {
		this.doctor = doctor;
	}

	public UserRequestModel getUser() {
		return user;
	}

	public void setUser(UserRequestModel user) {
		this.user = user;
	}
}
