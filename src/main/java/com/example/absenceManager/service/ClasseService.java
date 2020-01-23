package com.example.absenceManager.service;

import java.util.List;

import com.example.absenceManager.entity.Classe;

public interface ClasseService {
	Classe addClasse(Classe cls);
	List<Classe> getAllClasse();
	
	Classe deleteClasse(Long id);
	Classe updateClasse(Long id, Classe Classe);


}
