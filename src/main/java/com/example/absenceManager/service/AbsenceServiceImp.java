package com.example.absenceManager.service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.absenceManager.entity.Absence;
import com.example.absenceManager.repository.AbsenceRepo;


@Service
public class AbsenceServiceImp implements AbsenceService {
	
	
	@Autowired
	private AbsenceRepo absenceRepo;
	
	
	
	@Override
	public Absence addAbsence(Absence abs) {
	
		return absenceRepo.save(abs);
	}
	
	
public Absence findAbsenceByIdMat(Long id,Long Matricule) {
		
		List<Absence> absences = (List<Absence>) absenceRepo.findAll();
		List<Absence> r = absences.stream().filter(x->x.getEtudiant().getId().equals(Matricule))
				.collect(Collectors.toList());
		 Absence k = r.stream().filter(x->x.getMatiere().getId().equals(id)).findFirst().get();
		
		return k;
		}
	
	 /*public Integer sumAbsense() {
		// TODO Auto-generated method stub
		return absenceRepo.sumAbsence();
	}*/
	

	@Override
	public Absence updateAbsence(Long id, Absence absence) {
		if (!absenceRepo.existsById(id))
			throw new NoSuchElementException();
		absence.setId(id);
		return absenceRepo.save(absence);
	}
	
	@Override
	public Absence deleteAbsence(Long id) {
		Absence absence = absenceRepo.findById(id).orElseThrow(() -> new NoSuchElementException());
		absenceRepo.deleteById(id);
		return absence;
	}

	@Override
	public List<Absence> getAllAbsence() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	


	
				  
				  
				   
	}

	
		
		
		
		
	
	


