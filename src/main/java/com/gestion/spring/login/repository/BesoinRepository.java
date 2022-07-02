package com.gestion.spring.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.spring.login.models.Besoin;

public interface BesoinRepository extends JpaRepository<Besoin, Long>{
	List<Besoin> findByUserId(long id);
	
	
}
