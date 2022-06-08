package com.gestion.spring.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.spring.login.models.Laboratoire;
import com.gestion.spring.login.models.User;
import com.gestion.spring.login.repository.LaboratoireRepository;

@Service
public class LaboratoireService {
	@Autowired
	LaboratoireRepository laboratoireRepository;
	
	public List<Integer> findUsersByLabos(int laboratoireId){
	return laboratoireRepository.findMembresByLabos(laboratoireId);
	}
	
	public List<Laboratoire> findAll(){
	return laboratoireRepository.findAll();
}
}