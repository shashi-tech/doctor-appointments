package com.worldhospital.app.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.worldhospital.app.model.DoctorDto;
import com.worldhospital.app.service.DoctorService;
import com.worldhospital.app.ui.model.DoctorRest;

public class DoctorControllerTest {

	@InjectMocks
	DoctorController doctorController;

	@Mock
	DoctorService doctorService;

	DoctorDto doctorDto;

	String doctorId = "1";

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		doctorDto = new DoctorDto(1, "Thomas Walker", 32,
				"MBBS, Post Graduate Diploma in Endocrinology, PG Diploma In Emergency Trauma Care",
				"General Physician", 19);
	}

	@Test
	void testFindDoctorById() {
		when(doctorService.findDoctorById( anyString() ) ).thenReturn(doctorDto);

		DoctorRest doctorRest = doctorController.findDoctorById(doctorId);

		assertNotNull(doctorRest);
	}
}
