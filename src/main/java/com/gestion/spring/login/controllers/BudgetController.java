package com.gestion.spring.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.spring.login.models.Budget;
import com.gestion.spring.login.service.BudgetService;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/api/budget")
public class BudgetController {
	@Autowired
	BudgetService budgetService;
	@PostMapping(value = "/save-budget/")
	public Budget save(@RequestBody Budget budget) {
		return budgetService.save(budget);
	}
}
