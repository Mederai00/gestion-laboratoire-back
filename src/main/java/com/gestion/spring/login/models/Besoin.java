package com.gestion.spring.login.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Besoin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    @ManyToOne
	private TypeBesoin typeBesoin;
    private Double montant;
    private String Description;
    @ManyToOne
    private User user;
    
    
	
}
