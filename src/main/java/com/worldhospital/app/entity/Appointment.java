package com.worldhospital.app.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.worldhospital.app.model.AppointmentStatus;

@Entity
@Table(name = "appointment")
public class Appointment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1138394833442529903L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "created_at")
	private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

	@Column(name = "appointment_date")
	private LocalDate appointmentDate;

	@Column(name = "appointment_start_time")
	private Time appointmentStartTime;

	@Column(name = "appointment_end_time")
	private Time appointmentEndTime;

	@Column(name = "status")
	private AppointmentStatus status = AppointmentStatus.Booked;

	@Column(name = "price")
	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Appointment() {}
	
	public Appointment(LocalDate appointmentDate, Time appointmentStartTime,
			Time appointmentEndTime, BigDecimal price, Doctor doctor, User user) {
		this.appointmentDate = appointmentDate;
		this.appointmentStartTime = appointmentStartTime;
		this.appointmentEndTime = appointmentEndTime;
		this.price = price;
		this.doctor = doctor;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
