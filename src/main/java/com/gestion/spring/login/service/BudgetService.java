package com.gestion.spring.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.spring.login.models.Budget;
import com.gestion.spring.login.repository.BudgetRepository;

@Service
public class BudgetService {
	
	@Autowired
	BudgetRepository budgetRepository;
	
	public Budget save(Budget budget) {
		return budgetRepository.save(budget);
	}
}
