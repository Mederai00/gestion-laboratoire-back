package com.gestion.spring.login;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootGestionApplication 
//implements CommandLineRunner 
	{
//
//	@Autowired
//	private UserRepository userRepository;
////	private LaboratoireRepository laboratoireRepository;
//	@Autowired
//	private PasswordEncoder encoder;


	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootGestionApplication.class, args);
	}
	
//
//	@Override
//	@Transactional
//	public void run(String... args) throws Exception {
//
//			List<User> users = userRepository.findAll();
//			for(User user: users) {
//				String encodedPass = encoder.encode(user.getPassword());
//				user.setPassword(encodedPass);
//				userRepository.save(user);
//			}
			
			
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
//		}
		

	}


