package com.example.absenceManager.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classe {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(nullable = false)
	//@NotBlank(message = "label is mandatory")
	private String label;
	
	
	@Column(nullable = false)
	//@NotBlank(message = "nom complet is mandatory")
	private String nomComplet;
	
	@OneToMany(mappedBy = "classe")
    private List<Etudiant> etudiants;

	
	
	
}
