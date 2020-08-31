package com.worldhospital.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldhospital.app.model.DoctorDto;
import com.worldhospital.app.service.DoctorService;
import com.worldhospital.app.ui.model.DoctorRest;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping(path = "/{doctorId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DoctorRest findDoctorById(@PathVariable String doctorId) {
		ModelMapper modelMapper = new ModelMapper();
		DoctorDto doctorDto = doctorService.findDoctorById(doctorId);
		DoctorRest doctorRest = modelMapper.map(doctorDto, DoctorRest.class);
		return doctorRest;
	}

}
