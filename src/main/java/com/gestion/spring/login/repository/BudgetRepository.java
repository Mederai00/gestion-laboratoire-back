package com.gestion.spring.login.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.spring.login.models.Budget;


@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {


}
