package com.gestion.spring.login.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }
 
  @GetMapping("/laboratoire/{id}")
public Laboratoire findByResponsableId(@PathVariable long id) {
  Laboratoire laboratoire = laboratoireRepository.findByResponsableId(id);
  for(User user: laboratoire.getMembres()) {
    List<BudgetPersonnel> budgetPersonnels = budgetPersonnelRepository.findByUserId(user.getId());
  user.setBudgetPersonnels(budgetPersonnels);
  }
 return laboratoire;
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
 
  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }
 
 

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }
 
 
 
}