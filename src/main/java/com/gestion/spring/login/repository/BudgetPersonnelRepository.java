package com.gestion.spring.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gestion.spring.login.models.BudgetPersonnel;

@RepositoryRestResource(collectionResourceRel = "budget_personnel", path = "budget_personnel")
public interface BudgetPersonnelRepository extends JpaRepository<BudgetPersonnel, Long> {

	List<BudgetPersonnel> findByUserId(Long id);

}
