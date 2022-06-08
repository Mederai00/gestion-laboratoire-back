package com.gestion.spring.login.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.spring.login.models.Laboratoire;
import com.gestion.spring.login.service.LaboratoireService;


@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/api/laboratoire")
public class LaboratoireController {

	@Autowired
	LaboratoireService laboratoireService;
	
	@GetMapping(value = "/membres/{laboratoireId}")
	List<Integer> findMembresByLabos(@PathVariable int laboratoireId){
		return laboratoireService.findUsersByLabos(laboratoireId);
	}
	
	@GetMapping(value = "/")
	List<Laboratoire> findAll(){
		return laboratoireService.findAll();
	}
}