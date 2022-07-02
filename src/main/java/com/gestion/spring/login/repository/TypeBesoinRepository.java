package com.gestion.spring.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.spring.login.models.TypeBesoin;

@Repository
public interface TypeBesoinRepository extends JpaRepository<TypeBesoin, Long>{

}
