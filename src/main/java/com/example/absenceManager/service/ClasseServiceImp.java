package com.example.absenceManager.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.absenceManager.entity.Classe;
import com.example.absenceManager.repository.ClasseRepo;



@Service("ClasseService")
public class ClasseServiceImp implements ClasseService {
	
	@Autowired
	private ClasseRepo classeRepo;
	
	
	@Override
	public Classe addClasse(Classe cls) {
		return classeRepo.save(cls);
	}
	
	
	@Override
	public Classe deleteClasse(Long id) {
		Classe classe = classeRepo.findById(id).orElseThrow(() -> new NoSuchElementException());
		classeRepo.deleteById(id);
		return classe;
	}
	@Override
	public List<Classe> getAllClasse() {
		return (List<Classe>) classeRepo.findAll();
	}
	
	@Override
	public Classe updateClasse(Long id, Classe classe) {
		if (!classeRepo.existsById(id))throw 
		new NoSuchElementException();
		      classe.setId(id);
		return classeRepo.save(classe);
	}
	
	

    
	
	
	
}
