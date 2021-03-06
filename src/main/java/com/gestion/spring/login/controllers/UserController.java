package com.gestion.spring.login.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.spring.login.models.User;
import com.gestion.spring.login.repository.UserRepository;
import com.gestion.spring.login.service.UserService;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(value = "/id/{id}")
	User findById(@PathVariable long id) {
		return userService.findById(id);
	}
	
	@GetMapping(value = "/users-without-labos/")
	List<User> findUsersWithoutLabos(){
		return userService.findUsersWithoutLabos();
	}
	
	@GetMapping(value = "/")
	List<User> findAll(){
		return userRepository.findAll();
	}
}