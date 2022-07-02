package com.gestion.spring.login.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.spring.login.models.BudgetPersonnel;

@Repository
public interface BudgetPersonnelRepository extends JpaRepository<BudgetPersonnel, Long> {

	List<BudgetPersonnel> findByUserId(long id);
	BudgetPersonnel findBPersonnelByUserIdAndBudgetAnnee(long userId, int annee);
}
