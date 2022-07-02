package com.gestion.spring.login;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.spring.login.models.BudgetPersonnel;
import com.gestion.spring.login.repository.BudgetPersonnelRepository;


@SpringBootApplication
public class SpringBootGestionApplication 
implements CommandLineRunner 
	{

	@Autowired
	private BudgetPersonnelRepository budgetPersonnelRepository;


	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootGestionApplication.class, args);
	}
	

	@Override
	@Transactional
	public void run(String... args) throws Exception {

			List<BudgetPersonnel> budgetPersonnels = budgetPersonnelRepository.findAll();
			for(BudgetPersonnel budgetPersonnel: budgetPersonnels) {
				budgetPersonnel.setSomme(budgetPersonnel.getSomme()/2 );
				budgetPersonnel.setSomme((double)Math.round(budgetPersonnel.getSomme()) );
				
				budgetPersonnelRepository.save(budgetPersonnel);
			}
			
			
//			List<Laboratoire> laboratoires = laboratoireRepository.findAll();
//			for(Laboratoire laboratoire: laboratoires) {
//				
//			for(Budget budget: laboratoire.getBudgets()) {
//				for(User user: laboratoire.getMembres()) {
//					Random r = new Random();
//					double randomValue = 60000 + (90000 - 60000) * r.nextDouble();
//
//					BudgetPersonnel budgetPersonnel = new BudgetPersonnel();
//					
//					budgetPersonnel.setSomme(randomValue);
//					budgetPersonnel.setBudget(budget);
//					budgetPersonnel.setUser(user);
//					
//					budgetPersonnelRepository.save(budgetPersonnel);
//				}
//			}
//			}
//			
//			
//
//			
//			
		}
		

	}


