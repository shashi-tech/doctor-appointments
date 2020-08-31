package com.worldhospital.app.service;

import com.worldhospital.app.model.UserDto;

public interface UserService {
	UserDto createUser(UserDto userDto);
	UserDto getUserById(String userId);
}
