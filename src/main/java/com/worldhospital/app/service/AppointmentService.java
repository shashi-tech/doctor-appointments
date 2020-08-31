package com.worldhospital.app.service;

import java.util.List;

import com.worldhospital.app.model.AppointmentDto;

public interface AppointmentService {
	
	AppointmentDto createAppointment(AppointmentDto appointmentDto);
	
	List<AppointmentDto> findAppointmentByDoctor(String doctorId);

	AppointmentDto findAppointmentById(String id);

}
