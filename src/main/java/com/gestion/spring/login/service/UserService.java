package com.gestion.spring.login.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.spring.login.models.Laboratoire;
import com.gestion.spring.login.models.User;
import com.gestion.spring.login.repository.LaboratoireRepository;
import com.gestion.spring.login.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LaboratoireRepository laboratoireRepository;
	
	public User findById(long id) {
		return userRepository.findById(id);
	}
	
	public List<User> findUsersWithoutLabos() {
		List<User> allUsers = userRepository.findAll();
		List<User> allUsersWithLabo = new ArrayList<User>();
		List<User> usersWithoutLabos = new ArrayList<User>();
		List<Laboratoire> allLabos =  laboratoireRepository.findAll();
		for (Laboratoire l : allLabos) {
			allUsersWithLabo.addAll(l.getMembres());
		}
		for(int i= 0; i<allUsers.size(); i++) {
			if(!allUsersWithLabo.contains(allUsers.get(i))) {
				usersWithoutLabos.add(allUsers.get(i));
			}
		}
		return usersWithoutLabos;
	}
}