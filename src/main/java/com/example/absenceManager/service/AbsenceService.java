package com.example.absenceManager.service;

import java.util.List;

import com.example.absenceManager.entity.Absence;

public interface AbsenceService {
	Absence addAbsence(Absence absence);
	List<Absence> getAllAbsence();
	
	
	Absence updateAbsence(Long id, Absence absence);
	Absence deleteAbsence(Long id);
	//Integer sumAbsense();	

}
