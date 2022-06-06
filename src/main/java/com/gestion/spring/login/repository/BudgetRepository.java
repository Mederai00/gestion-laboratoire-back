package com.gestion.spring.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.gestion.spring.login.models.Budget;

@RepositoryRestResource(collectionResourceRel = "budgets", path = "budgets")
public interface BudgetRepository extends JpaRepository<Budget, Long> {

	List<Budget> findByLaboratoireId(Long id);

}
