package com.gestion.spring.login.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Budget {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int annee;
	private Double db;
	private Double dr;
	@ManyToOne
	private Laboratoire laboratoire;
	@OneToMany(mappedBy = "budget")
	private List<BudgetPersonnel> budgetPersonnels;
	
	

}
