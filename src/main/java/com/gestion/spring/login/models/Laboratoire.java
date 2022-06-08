package com.gestion.spring.login.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Laboratoire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nom;
	private String adresse;
	@OneToOne
	private User responsable;
	@OneToMany
	private List<User> membres;
	@OneToMany
	private List<Budget> budgets;
	
	private String telephone;
	private String ville;
	private String domaine;

	
	
	
	
}
