package com.gestion.spring.login.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.spring.login.models.Budget;
import com.gestion.spring.login.models.Laboratoire;
import com.gestion.spring.login.repository.BudgetRepository;
import com.gestion.spring.login.repository.LaboratoireRepository;


@Service
public class LaboratoireService {
	@Autowired
	LaboratoireRepository laboratoireRepository;
	@Autowired
	BudgetRepository budgetRepository;
	
	public List<Integer> findUsersByLabos(int laboratoireId){
		return laboratoireRepository.findMembresByLabos(laboratoireId);
	}
	
	public List<Laboratoire> findAll(){
		return laboratoireRepository.findAll();
	}
	
	public Laboratoire save(Laboratoire laboratoire) {
		for (Budget b : laboratoire.getBudgets()) {
			budgetRepository.save(b);
		}
		return laboratoireRepository.save(laboratoire);
	}
	
	@Transactional
	public void deleteById(long idLab) {
		laboratoireRepository.dissocierBudgetsLabo(idLab);
		laboratoireRepository.dissocierMembresLabo(idLab);
		laboratoireRepository.deleteById(idLab);
		//return labo;
	}
	
	public Laboratoire findByUserId(int idUser) {
		int idLabo = laboratoireRepository.findIdLaboratoireByUserId(idUser);
		return laboratoireRepository.findById(idLabo);
	}
}