package com.gestion.spring.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.spring.login.models.User;
import com.gestion.spring.login.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public User findById(long id) {
	return userRepository.findById(id);
	}
}