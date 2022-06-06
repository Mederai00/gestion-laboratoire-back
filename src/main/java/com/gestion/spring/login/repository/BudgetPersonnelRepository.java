package com.gestion.spring.login.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.spring.login.models.BudgetPersonnel;

@Repository
public interface BudgetPersonnelRepository extends JpaRepository<BudgetPersonnel, Long> {


}
