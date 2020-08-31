package com.worldhospital.app.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldhospital.app.entity.Doctor;
import com.worldhospital.app.model.DoctorDto;
import com.worldhospital.app.persistence.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public DoctorDto findDoctorById(String doctorId) {
		Optional<Doctor> doctorContainer = doctorRepository.findById(Long.parseLong(doctorId));
		if (doctorContainer.isPresent()) {
			ModelMapper modelMapper = new ModelMapper();
			DoctorDto doctorDto = modelMapper.map(doctorContainer.get(), DoctorDto.class);
			return doctorDto;
		}
		return null;
	}

}
