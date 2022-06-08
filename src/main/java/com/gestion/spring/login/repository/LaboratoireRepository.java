package com.gestion.spring.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestion.spring.login.models.Laboratoire;

@Repository
public interface LaboratoireRepository extends JpaRepository<Laboratoire, Long>{

	Laboratoire findByResponsableId(long id);
	
	@Query(value = "SELECT l.membres_id FROM LABORATOIRE_MEMBRES l WHERE l.laboratoire_id = ?1", nativeQuery = true)
	List<Integer> findMembresByLabos(int laboratoireId);
}
