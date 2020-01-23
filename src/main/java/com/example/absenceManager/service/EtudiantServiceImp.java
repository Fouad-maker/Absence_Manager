package com.example.absenceManager.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.absenceManager.entity.Etudiant;
import com.example.absenceManager.repository.EtudiantRepo;


@Service
public class EtudiantServiceImp implements EtudiantService {
	
	
	@Autowired
	private EtudiantRepo etudiantRepo;
	
	@Override
	public Etudiant addEtudiant(Etudiant std) {
	
		return etudiantRepo.save(std);
	}
	
	@Override
	public List<Etudiant> getAllEtudiant() {
		return (List<Etudiant>) etudiantRepo.findAll();
	}
	
	@Override
	public Etudiant updateEtudiant(Long id, Etudiant etudiant) {
		if (!etudiantRepo.existsById(id))
			throw new NoSuchElementException();
		etudiant.setId(id);
		return etudiantRepo.save(etudiant);
	}
	
	@Override
	public Etudiant deleteEtudiant(Long id) {
		Etudiant etudiant = etudiantRepo.findById(id).orElseThrow(() -> new NoSuchElementException());
		etudiantRepo.deleteById(id);
		return etudiant;
	}
	

}
