package com.worldhospital.app.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.worldhospital.app.model.UserDto;
import com.worldhospital.app.service.UserService;
import com.worldhospital.app.ui.model.UserRest;

public class UserControllerTest {

	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	UserDto userDto;
	
	String userId = "1";
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		userDto = new UserDto(1, "Harry", "harry@test.com", "123456789");
	}
	
	@Test
	void testFindUserById() {
		when(userService.getUserById( anyString() ) ).thenReturn(userDto);
		
		UserRest userRest = userController.findUserById(userId);
		
		assertNotNull(userRest);
	}
}
