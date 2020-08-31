package com.worldhospital.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldhospital.app.entity.User;
import com.worldhospital.app.model.UserDto;
import com.worldhospital.app.persistence.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(String userId) {
		Optional<User> userContainer = userRepository.findById(Long.parseLong(userId));
		if (userContainer.isPresent()) {
			User user = userContainer.get();
			UserDto userDto = new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPhone());
			return userDto;
		}
		return null;
	}

}
