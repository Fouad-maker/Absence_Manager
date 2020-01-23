package com.example.absenceManager.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.absenceManager.entity.Etudiant;

public interface EtudiantRepo extends CrudRepository<Etudiant, Long> {
	

}
