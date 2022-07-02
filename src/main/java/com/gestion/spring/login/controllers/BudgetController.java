package com.gestion.spring.login.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.spring.login.models.Budget;
import com.gestion.spring.login.models.BudgetPersonnel;
import com.gestion.spring.login.repository.BudgetPersonnelRepository;
import com.gestion.spring.login.repository.BudgetRepository;
import com.gestion.spring.login.service.BudgetService;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/api/budget")
public class BudgetController {
	@Autowired
	BudgetService budgetService;
	@Autowired
	BudgetRepository budgetRepository;
	@Autowired
	BudgetPersonnelRepository budgetPersonnelRepository;
	
	
	@PostMapping(value = "/save-budget/")
	public Budget save(@RequestBody Budget budget) {
		return budgetService.save(budget);
	}
	
	@GetMapping("/personnel/user/id/{userId}/budget/annee/{annee}")
	BudgetPersonnel findBPersonnelByUserIdAndBudgetAnnee(@PathVariable long userId, @PathVariable int annee) {
		return budgetPersonnelRepository.findBPersonnelByUserIdAndBudgetAnnee(userId, annee);
	}
	
	@GetMapping(value = "/")
	List<Budget> findAll(){
		return budgetRepository.findAll();
	}
}
