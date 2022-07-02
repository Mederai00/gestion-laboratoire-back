package com.gestion.spring.login.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.spring.login.models.Besoin;
import com.gestion.spring.login.models.TypeBesoin;
import com.gestion.spring.login.models.User;
import com.gestion.spring.login.repository.BesoinRepository;
import com.gestion.spring.login.repository.TypeBesoinRepository;
import com.gestion.spring.login.repository.UserRepository;
import com.gestion.spring.login.service.BesoinService;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/api/besoin")
public class BesoinController {
	
	@Autowired
	BesoinRepository besoinRepository;
	@Autowired
	BesoinService besoinService;
	@Autowired
	TypeBesoinRepository typeBesoinRepository;
	@Autowired 
	UserRepository userRepository;
	
	
	@GetMapping("/users-besoin/id/{id}")
	List<Besoin> findByUserId(@PathVariable long id){
		return besoinRepository.findByUserId(id);		
	}
	
	@GetMapping("/besoins/")
	List<TypeBesoin> findAllTypeBesoin(){
		return typeBesoinRepository.findAll();
	}
	
	@GetMapping("/respo/{id}/membres-count-types-besoins")
	List<Integer> countByTypeParRepoId(@PathVariable long id){
		return besoinService.countByTypeParRepoId(id);
	}
	@PostMapping("/save/")
	Besoin save(@RequestBody Besoin besoin) {
		return besoinRepository.save(besoin);
	}
	
	
	@GetMapping(value = "/user-count-types-besoins/{id}")
	List<Integer> countBesoinsTypesByUserId(@PathVariable long id){
	int countBillet = 0;
	int countMateriel = 0;
	int countSejour = 0;
	List<Integer> countTypeList = new ArrayList<Integer>();

	User user = userRepository.findById(id);

	List<Besoin> besoins = besoinRepository.findByUserId(user.getId());
	for(Besoin b: besoins) {
	if(b.getTypeBesoin().getId() == 1) countBillet ++;
	if(b.getTypeBesoin().getId() == 2) countMateriel ++;
	if (b.getTypeBesoin().getId() == 3) countSejour ++;
	}
	countTypeList.add(countBillet);
	countTypeList.add(countMateriel);
	countTypeList.add(countSejour);
	//System.out.println("compteur");
	System.out.println(countTypeList);

	return countTypeList;
	}
}
