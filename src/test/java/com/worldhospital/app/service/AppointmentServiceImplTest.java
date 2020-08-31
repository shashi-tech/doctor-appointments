package com.worldhospital.app.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.worldhospital.app.entity.Appointment;
import com.worldhospital.app.entity.Doctor;
import com.worldhospital.app.entity.User;
import com.worldhospital.app.model.AppointmentDto;
import com.worldhospital.app.model.DoctorDto;
import com.worldhospital.app.model.UserDto;
import com.worldhospital.app.persistence.AppointmentRepository;

@RunWith(SpringRunner.class)
public class AppointmentServiceImplTest {
	
	@TestConfiguration
	static class AppointmentServiceImplTestContextConfiguration {
		@Bean
        public AppointmentService appointmentService() {
            return new AppointmentServiceImpl();
        }
	}
	
	@Autowired
    private AppointmentService appointmentService;

    @MockBean
    private AppointmentRepository appointmentRepository;
    
    @Before
    public void setUp() {
    	Doctor doctor = new Doctor("Thomas Walker", 32, "MBBS, Post Graduate Diploma in Endocrinology, PG Diploma In Emergency Trauma Care", "General Physician", 19);
    	User user1 = new User("Harry", "harry@test.com", "123456789");
    	User user2 = new User("Ron", "ron@test.com", "123456789");
    	User user3 = new User("Sam", "sam@test.com", "123456789");
    	
    	Appointment appointmentFirst = new Appointment(LocalDate.of(2020, 2, 3), Time.valueOf("11:00:00"),  Time.valueOf("12:00:00"), new BigDecimal(90), doctor, user1);
    	Appointment appointmentSecond = new Appointment(LocalDate.of(2020, 2, 15), Time.valueOf("11:00:00"),  Time.valueOf("12:00:00"), new BigDecimal(90), doctor, user2);
    	Appointment appointmentThird = new Appointment(LocalDate.of(2020, 2, 23), Time.valueOf("11:00:00"),  Time.valueOf("12:00:00"), new BigDecimal(90), doctor, user3);
    	
    	List<Appointment> allAppointments = Arrays.asList(appointmentFirst, appointmentSecond, appointmentThird);

        Mockito.when(appointmentRepository.findById(appointmentFirst.getId())).thenReturn(Optional.of(appointmentFirst));
        Mockito.when(appointmentRepository.findAll()).thenReturn(allAppointments);
        Mockito.when(appointmentRepository.findById(-99L)).thenReturn(Optional.empty());
    }
    
    @Test
    public void whenInValidId_thenAppointmentShouldNotBeFound() {
    	DoctorDto doctorDto = new DoctorDto("Thomas Walker", 32, "MBBS, Post Graduate Diploma in Endocrinology, PG Diploma In Emergency Trauma Care", "General Physician", 19);
    	UserDto user1 = new UserDto("Harry", "harry@test.com", "123456789");
    	UserDto user2 = new UserDto("Ron", "ron@test.com", "123456789");
    	UserDto user3 = new UserDto("Sam", "sam@test.com", "123456789");
    	
    	appointmentService.createAppointment(new AppointmentDto(LocalDate.of(2020, 2, 3), Time.valueOf("11:00:00"),  Time.valueOf("12:00:00"), new BigDecimal(90), doctorDto, user1));
    	appointmentService.createAppointment(new AppointmentDto(LocalDate.of(2020, 2, 15), Time.valueOf("11:00:00"),  Time.valueOf("12:00:00"), new BigDecimal(90), doctorDto, user2));
    	appointmentService.createAppointment(new AppointmentDto(LocalDate.of(2020, 2, 23), Time.valueOf("11:00:00"),  Time.valueOf("12:00:00"), new BigDecimal(90), doctorDto, user3));
    	
    	List<AppointmentDto> appointments = appointmentService.findAppointmentByDoctor("-99");
        verifyFindByIdIsCalledOnce();
        assertThat(appointments).isEmpty();
    }
    
    private void verifyFindByIdIsCalledOnce() {
        Mockito.verify(appointmentRepository, VerificationModeFactory.times(1)).findById(Mockito.anyLong());
        Mockito.reset(appointmentRepository);
    }

}
