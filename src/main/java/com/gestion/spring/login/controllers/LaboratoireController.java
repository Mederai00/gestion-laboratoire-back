package com.gestion.spring.login.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping(value = "/save-laboratoire/")
	Laboratoire save(@RequestBody Laboratoire laboratoire) {
		return laboratoireService.save(laboratoire);
	}
	
	@DeleteMapping("/delete-laboratoire/id/{idLab}")
	void deleteById(@PathVariable long idLab) {
		laboratoireService.deleteById(idLab);
	}
	
	@GetMapping(value = "/user/id/{idUser}")
	Laboratoire findByUserId(@PathVariable int idUser) {
		return laboratoireService.findByUserId(idUser);
	}
	
}