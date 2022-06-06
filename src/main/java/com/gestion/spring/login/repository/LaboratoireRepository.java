package com.gestion.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gestion.spring.login.models.Laboratoire;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RepositoryRestResource(collectionResourceRel = "laboratoire", path = "laboratoire")
public interface LaboratoireRepository extends JpaRepository<Laboratoire, Long>{

}
