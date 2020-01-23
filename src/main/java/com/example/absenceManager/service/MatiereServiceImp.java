package com.example.absenceManager.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.absenceManager.entity.Matiere;
import com.example.absenceManager.repository.MatiereRepo;


@Service
public class MatiereServiceImp implements MatiereService {
	
	@Autowired
	private MatiereRepo matiereRepo;
	
	
	@Override
	public Matiere addMatiere(Matiere mtr) {
		return matiereRepo.save(mtr);
	}
	@Override
	public Matiere deleteMatiere(Long id) {
		Matiere matiere = matiereRepo.findById(id).orElseThrow(() -> new NoSuchElementException());
		matiereRepo.deleteById(id);
		return matiere;
	}
	@Override
	public Matiere updateMatiere(Long id, Matiere matiere) {
		if (!matiereRepo.existsById(id))
			throw new NoSuchElementException();
		matiere.setId(id);
		return matiereRepo.save(matiere);
	}
	@Override
	public List<Matiere> getAllMatiere() {
		return (List<Matiere>) matiereRepo.findAll();
	}

}
