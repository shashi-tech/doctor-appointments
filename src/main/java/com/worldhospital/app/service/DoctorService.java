package com.worldhospital.app.service;

import com.worldhospital.app.model.DoctorDto;

public interface DoctorService {
	DoctorDto findDoctorById(String doctorId);
}
