package com.example.absenceManager.service;

import java.util.List;

import com.example.absenceManager.entity.Etudiant;

public interface EtudiantService {
	Etudiant addEtudiant(Etudiant std);
	List<Etudiant> getAllEtudiant();
	
	Etudiant deleteEtudiant(Long id);
	Etudiant updateEtudiant(Long id, Etudiant Etudiant);

}
