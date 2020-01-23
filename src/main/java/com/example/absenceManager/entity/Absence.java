package com.example.absenceManager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Absence {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
 
    @OneToOne
    @JoinColumn(name = "etudiant")
    Etudiant etudiant;
 
    @OneToOne
    @JoinColumn(name = "matiere")
    Matiere matiere;
    
    
    
    Integer absence;
    
    String dateOfAbsence;

    public Absence(Long id ) {
    	this.id = id ;
    }
}

