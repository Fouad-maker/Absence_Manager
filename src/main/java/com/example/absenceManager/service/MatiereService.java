package com.example.absenceManager.service;

import java.util.List;

import com.example.absenceManager.entity.Matiere;

public interface MatiereService {
	Matiere addMatiere(Matiere matiere);
	List<Matiere> getAllMatiere();
	
	Matiere deleteMatiere(Long id);
	Matiere updateMatiere(Long id, Matiere matiere);

	

}
