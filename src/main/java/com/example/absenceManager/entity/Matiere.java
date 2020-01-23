package com.example.absenceManager.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Matiere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	@Column(nullable = false)
	//@NotBlank(message = "Label is mandatory")
	private String Label;
	
	@Column(nullable = false)
	//@NotBlank(message = "nbr of hours is mandatory")
	private Integer nbrHeur;
	
	@Column(nullable = false)
	//@NotBlank(message = "permit absence hours is mandatory")
	private Integer absHoursPermit;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "etudiant_matiere_tab", 
      joinColumns = @JoinColumn(name = "etudiant_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "matiere_id", 
      referencedColumnName = "id"))
    private List<Etudiant> etudiantList;
	
	
	@OneToMany(mappedBy = "matiere")
    Set<Absence> absences;
	
	

}
