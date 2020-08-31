package com.worldhospital.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 285323606876571115L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false, length=50)
	private String name;
	
	@Column(nullable=false)
	private Integer age;
	
	@Column(nullable=false)
	private String qualification;
	
	@Column(nullable=false)
	private String specialization;
	
	@Column(nullable=false)
	private Integer experience;
	
	@OneToMany(mappedBy="doctor", cascade = CascadeType.ALL)
	private List<Appointment> appointments;
	
	public Doctor() {}

	public Doctor(String name, Integer age, String qualification, String specialization, Integer experience) {
		this.name = name;
		this.age = age;
		this.qualification = qualification;
		this.specialization = specialization;
		this.experience = experience;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

}
