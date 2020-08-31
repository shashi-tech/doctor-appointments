package com.worldhospital.app.model;

import java.io.Serializable;
import java.util.List;

public class DoctorDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1554439753397898398L;

	private long id;

	private String name;

	private Integer age;

	private String qualification;

	private String specialization;

	private Integer experience;
	
	private List<AppointmentDto> appointments;
	
	public DoctorDto() {}

	public DoctorDto(long id, String name, Integer age, String qualification, String specialization,
			Integer experience) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.qualification = qualification;
		this.specialization = specialization;
		this.experience = experience;
	}
	
	public DoctorDto(String name, Integer age, String qualification, String specialization, Integer experience) {
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

	public List<AppointmentDto> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<AppointmentDto> appointments) {
		this.appointments = appointments;
	}
	
}
