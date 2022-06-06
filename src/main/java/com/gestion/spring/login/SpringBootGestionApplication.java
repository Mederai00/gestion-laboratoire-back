package com.gestion.spring.login;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.spring.login.models.Budget;
import com.gestion.spring.login.models.BudgetPersonnel;
import com.gestion.spring.login.models.User;
import com.gestion.spring.login.repository.BudgetPersonnelRepository;
import com.gestion.spring.login.repository.BudgetRepository;
import com.gestion.spring.login.repository.UserRepository;


@SpringBootApplication
public class SpringBootGestionApplication 
//implements CommandLineRunner 
	{
//
//	
//	private BudgetPersonnelRepository budgetPersonnelRepository;
//	private BudgetRepository budgetRepository;
//	private UserRepository userRepository;
//	private PasswordEncoder encoder;
//
//
//
//	public SpringBootGestionApplication(BudgetPersonnelRepository budgetPersonnelRepository,PasswordEncoder encoder, BudgetRepository budgetRepository,UserRepository userRepository ) {
//        this.budgetPersonnelRepository = budgetPersonnelRepository;
//        this.budgetRepository = budgetRepository;
//        this.userRepository = userRepository;
//        this.encoder = encoder;
//    }


	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootGestionApplication.class, args);
	}
	

//	@Override
//	@Transactional
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//
//		List<User> users = userRepository.findAll();
//		for(User user: users) {
			
//			String encodedPass = encoder.encode("hikSDe1DWFYR");
//			String encodedPass = encoder.encode(user.getPassword());

//			int leftLimit = 48; // numeral '0'
//		    int rightLimit = 122; // letter 'z'
//		    int targetStringLength = 10;
//		    Random random = new Random();
//
//		    String generatedString = random.ints(leftLimit, rightLimit + 1)
//		      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
//		      .limit(targetStringLength)
//		      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
//		      .toString();
//			user.setPassword(generatedString);
//			user.setPassword(encodedPass);
//			userRepository.save(user);
//		}
		
//		System.out.println(encodedPass);
		
		
		
		
		
		
//		for (int i =1; i<11; i++) {
//			List<User> users = userRepository.findByLaboratoireId((long) i);
//			List<Budget> budgets = budgetRepository.findByLaboratoireId((long) i);
//			for(Budget budget: budgets) {
//				for(User user: users) {
//					Random r = new Random();
//					double randomValue = 10000 + (40000 - 10000) * r.nextDouble();
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
//		}
//		
//
//	}
}

