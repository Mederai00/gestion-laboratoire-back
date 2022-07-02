package com.gestion.spring.login.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.spring.login.models.Besoin;
import com.gestion.spring.login.models.User;
import com.gestion.spring.login.repository.BesoinRepository;
import com.gestion.spring.login.repository.LaboratoireRepository;

@Service
public class BesoinService {
	@Autowired
	BesoinRepository besoinRepository;
	@Autowired
	LaboratoireRepository laboratoireRepository;
	
	public List<Integer> countByTypeParRepoId(long id){
		int countBillet = 0;
		int countMateriel = 0;
		int countSejour = 0;
		List<Integer> countTypeList = new ArrayList<Integer>();
		List<User> membersLaboByRespo = laboratoireRepository.findByResponsableId(id).getMembres();
		for(User m: membersLaboByRespo) {
			List<Besoin> besoins = besoinRepository.findByUserId(m.getId());
			for(Besoin b: besoins) {
				if(b.getTypeBesoin().getId() == 1) countBillet ++;
				if(b.getTypeBesoin().getId() == 2) countMateriel ++;
				if (b.getTypeBesoin().getId() == 3) countSejour ++;
			}
		}
		countTypeList.add(countBillet);
		countTypeList.add(countMateriel);
		countTypeList.add(countSejour);
		System.out.println("compteur");
		System.out.println(countTypeList);
		return countTypeList;
	}
}
