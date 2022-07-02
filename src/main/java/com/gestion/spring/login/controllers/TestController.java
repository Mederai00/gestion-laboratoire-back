package com.gestion.spring.login.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.spring.login.models.Budget;
import com.gestion.spring.login.models.BudgetPersonnel;
import com.gestion.spring.login.models.Laboratoire;
import com.gestion.spring.login.models.User;
import com.gestion.spring.login.repository.BudgetPersonnelRepository;
import com.gestion.spring.login.repository.BudgetRepository;
import com.gestion.spring.login.repository.LaboratoireRepository;
import com.gestion.spring.login.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/api/test")
public class TestController {

	@Autowired
	LaboratoireRepository laboratoireRepository;

	@Autowired
	BudgetPersonnelRepository budgetPersonnelRepository;

	@Autowired
	BudgetRepository budgetRepository;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/laboratoire/{id}")
	public Laboratoire findByResponsableId(@PathVariable long id) {
		Laboratoire laboratoire = laboratoireRepository.findByResponsableId(id);
		for (User user : laboratoire.getMembres()) {
			List<BudgetPersonnel> budgetPersonnels = budgetPersonnelRepository.findByUserId(user.getId());
			user.setBudgetPersonnels(budgetPersonnels);
		}
		return laboratoire;
	}

	@PutMapping(value = "/save-laboratoire")
	Laboratoire saveLabo(@RequestBody Laboratoire laboratoire) {

		Laboratoire returnlaboratoire = laboratoireRepository.save(laboratoire);
		for (User user : returnlaboratoire.getMembres()) {
			List<BudgetPersonnel> budgetPersonnels = budgetPersonnelRepository.findByUserId(user.getId());
			user.setBudgetPersonnels(budgetPersonnels);
		}
		return returnlaboratoire;
	}

	@GetMapping("/find-user/{id}")
	public User findUserById(@PathVariable long id) {

		User retUser = userRepository.findById(id);
		List<BudgetPersonnel> retUserbudgetPersonnels = budgetPersonnelRepository.findByUserId(retUser.getId());
		retUser.setBudgetPersonnels(retUserbudgetPersonnels);

		return retUser;
	}

	@PutMapping(value = "/save-user")
	User saveUser(@RequestBody User user) {
		User returnUser = userRepository.save(user);
		return returnUser;
	}

	@GetMapping("/budgetpersonnel/{id}")
	public List<BudgetPersonnel> findByUserId(@PathVariable long id) {
		List<BudgetPersonnel> budgetPersonnels = budgetPersonnelRepository.findByUserId(id);
		return budgetPersonnels;
	}

	@PostMapping("/budget")
	public Budget saveB(@RequestBody Budget b) {
		return budgetRepository.save(b);
	}

	@PostMapping("/budgetpersonnel")
	public User saveBP(@RequestBody BudgetPersonnel bp) {
		budgetPersonnelRepository.save(bp);
		User retUser = userRepository.findById(bp.getUser().getId()).get();
		List<BudgetPersonnel> retUserbudgetPersonnels = budgetPersonnelRepository.findByUserId(retUser.getId());
		retUser.setBudgetPersonnels(retUserbudgetPersonnels);

		return retUser;
	}

	@GetMapping(value = "/users-without-labos")
	List<User> findUsersWithoutLabosClearBp() {
		List<User> allUsers = userRepository.findAll();
		List<User> allUsersWithLabo = new ArrayList<User>();
		List<User> usersWithoutLabos = new ArrayList<User>();
		List<Laboratoire> allLabos = laboratoireRepository.findAll();
		for (Laboratoire l : allLabos) {
			allUsersWithLabo.addAll(l.getMembres());
		}
		for (int i = 0; i < allUsers.size(); i++) {
			if (!allUsersWithLabo.contains(allUsers.get(i))) {
				usersWithoutLabos.add(allUsers.get(i));
			}
		}
		for (User user : usersWithoutLabos) {
			List<BudgetPersonnel> budgetPersonnels = budgetPersonnelRepository.findByUserId(user.getId());
			budgetPersonnelRepository.deleteAll(budgetPersonnels);
			user.setBudgetPersonnels(new ArrayList<BudgetPersonnel>());
		}
		return usersWithoutLabos;
	}
}