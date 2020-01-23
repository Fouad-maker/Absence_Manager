package com.example.absenceManager.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.absenceManager.entity.Absence;



public interface AbsenceRepo extends CrudRepository<Absence , Long>{
	
	//@Query("select count(a.absence) from Absence a where a.etudiant=?1 and a.matiere= ?2 ")
	//double findNbHeureAbsByEtudiantAndMatiere(long id, long id2);
	

	//@Query(value = "UPDATE Absence SET absence= absence + 1 ")
	//void incrementAbsenceByID();
	
	//@Query(value = "SELECT sum(absence) FROM Absence")
	//public Integer sumAbsence();
	//@Query(value  ="SELECT sum(absence) FROM Absence WHERE etudiant=idd AND matiere = id")	//WHERE etudiant=matricule AND matiere = id"
	
	
	@Query("SELECT sum(a.absence) FROM Absence a where a.etudiant.id = :id ") 
	public Integer sumAbsAllMatiere(@PathVariable("id") Long id);	
	
	
	
	@Query("SELECT sum(a.absence) FROM Absence a where a.etudiant.id = :id and a.matiere.id = :idd") 
	public Integer sumAbsenceSingleMatiere(@PathVariable("id") Long id, @PathVariable("idd") Long idd );	
	
	@Query("SELECT sum(a.absence) FROM Absence a GROUP BY a.etudiant.id") 
	public Integer sumAbss();	
	
	
	}
	
	


