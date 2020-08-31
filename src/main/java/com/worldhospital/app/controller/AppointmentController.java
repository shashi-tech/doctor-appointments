package com.worldhospital.app.controller;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldhospital.app.model.AppointmentDto;
import com.worldhospital.app.model.DoctorDto;
import com.worldhospital.app.model.UserDto;
import com.worldhospital.app.service.AppointmentService;
import com.worldhospital.app.service.Utils;
import com.worldhospital.app.ui.model.AppointmentRequestModel;
import com.worldhospital.app.ui.model.AppointmentRest;
import com.worldhospital.app.ui.model.DoctorRest;
import com.worldhospital.app.ui.model.UserRest;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping
	public String findAllAppointments() {
		return "It's working!";
	}

	@GetMapping(path = "/doctor/{doctorId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AppointmentRest> findAppointmentByDoctorId(@PathVariable String doctorId) {

		List<AppointmentDto> appointmentDtos = appointmentService.findAppointmentByDoctor(doctorId);
		List<AppointmentRest> returnValue = appointmentDtos.stream().map(appointmentDto -> {
			AppointmentRest appointmentRest = prepareAppointmentRestObj(appointmentDto);
			return appointmentRest;
		}).collect(Collectors.toList());
		return returnValue;
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentRest findAppointmentById(@PathVariable String id) {

		AppointmentDto appointmentDto = appointmentService.findAppointmentById(id);
		AppointmentRest returnValue = prepareAppointmentRestObj(appointmentDto);
		return returnValue;
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AppointmentRest> createAppointment(@RequestBody AppointmentRequestModel appointmentDetails) {
		AppointmentRest appointmentRest = null;
		try {
			if (Utils.isValidAppointmentTimeSlot(appointmentDetails.getAppointmentStartTime(),
					appointmentDetails.getAppointmentDate())) {
				ModelMapper modelMapper = new ModelMapper();

				DoctorDto doctorDto = modelMapper.map(appointmentDetails.getDoctor(), DoctorDto.class);
				UserDto userDto = modelMapper.map(appointmentDetails.getUser(), UserDto.class);
				AppointmentDto appointmentDto = new AppointmentDto(
						LocalDate.parse(appointmentDetails.getAppointmentDate()),
						Time.valueOf(appointmentDetails.getAppointmentStartTime()),
						Time.valueOf(appointmentDetails.getAppointmentEndTime()),
						new BigDecimal(appointmentDetails.getPrice()), doctorDto, userDto);
				AppointmentDto createdAppointment = appointmentService.createAppointment(appointmentDto);

				appointmentRest = prepareAppointmentRestObj(createdAppointment);
			} else {
				throw new RuntimeException("Invalid appointment slots!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(appointmentRest, HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(appointmentRest);
	}

	private AppointmentRest prepareAppointmentRestObj(AppointmentDto createdAppointment) {
		AppointmentRest appointmentRest = new AppointmentRest();
		appointmentRest.setAppointmentDate(String.valueOf(createdAppointment.getAppointmentDate()));
		appointmentRest.setAppointmentStartTime(String.valueOf(createdAppointment.getAppointmentStartTime()));
		appointmentRest.setAppointmentEndTime(String.valueOf(createdAppointment.getAppointmentEndTime()));
		appointmentRest.setCreatedAt(String.valueOf(createdAppointment.getCreatedAt()));
		appointmentRest.setId(String.valueOf(createdAppointment.getId()));
		appointmentRest.setStatus(createdAppointment.getStatus().toString());
		UserRest userRest = new UserRest();
		BeanUtils.copyProperties(createdAppointment.getUser(), userRest);
		DoctorRest doctorRest = new DoctorRest();
		BeanUtils.copyProperties(createdAppointment.getDoctor(), doctorRest);
		appointmentRest.setUser(userRest);
		appointmentRest.setDoctor(doctorRest);
		appointmentRest.setPrice(createdAppointment.getPrice());
		return appointmentRest;
	}
}
