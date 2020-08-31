package com.worldhospital.app.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldhospital.app.entity.Appointment;
import com.worldhospital.app.entity.User;
import com.worldhospital.app.model.AppointmentDto;
import com.worldhospital.app.model.AppointmentStatus;
import com.worldhospital.app.model.DoctorDto;
import com.worldhospital.app.model.UserDto;
import com.worldhospital.app.persistence.AppointmentRepository;
import com.worldhospital.app.persistence.UserRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
		Optional<Appointment> availableAppointment = appointmentRepository.findByAppointmentDateAndAppointmentStartTime(appointmentDto.getAppointmentDate(), appointmentDto.getAppointmentStartTime());
        if (availableAppointment.isPresent())
        	throw new RuntimeException("Cannot book appointment on this slot as this slot has already been taken!");
		ModelMapper modelMapper = new ModelMapper();
		UserDto userDto = appointmentDto.getUser();
		User user = modelMapper.map(userDto, User.class);
		
		User createdUser = userRepository.save(user);
		
		Appointment appointment = modelMapper.map(appointmentDto, Appointment.class);
		appointment.setUser(createdUser);
		appointment.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		appointment.setStatus(AppointmentStatus.Booked);
		Appointment appointmentDetails = appointmentRepository.save(appointment);
		
		AppointmentDto returnValue = modelMapper.map(appointmentDetails, AppointmentDto.class);
		return returnValue;
	}

	@Override
	public List<AppointmentDto> findAppointmentByDoctor(String doctorId) {
		List<Appointment> appointments = appointmentRepository.findByDoctorId(Long.parseLong(doctorId));
		
		List<AppointmentDto> returnValue = new ArrayList<>();
		appointments.forEach(appointment -> {
			AppointmentDto appointmentDto = new AppointmentDto();
			BeanUtils.copyProperties(appointment, appointmentDto);
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(appointment.getUser(), userDto);
			DoctorDto doctorDto = new DoctorDto();
			BeanUtils.copyProperties(appointment.getDoctor(), doctorDto);
			
			appointmentDto.setUser(userDto);
			appointmentDto.setDoctor(doctorDto);
			returnValue.add(appointmentDto);
		});
		return returnValue;
	}

	@Override
	public AppointmentDto findAppointmentById(String id) {
		Optional<Appointment> appointmentDetails = appointmentRepository.findById(Long.parseLong(id));
		if (appointmentDetails.isPresent()) {
			ModelMapper modelMapper = new ModelMapper();
			AppointmentDto appointmentDto = modelMapper.map(appointmentDetails.get(), AppointmentDto.class);
			return appointmentDto;
		}
		return null;
	}

}
