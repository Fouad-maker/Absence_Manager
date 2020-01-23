package com.example.absenceManager.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = {"absences","classe"})
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	 //@NotBlank(message = "Name is mandatory")
	@Column(nullable = false)
	private String nom;
	
	 //@NotBlank(message = "Name is mandatory")
	@Column(nullable = false)
	private String  prenom;
	
	// @NotBlank(message = "email is mandatory")
    @Column(nullable = false)
    private String email;
    
    @Column
	private String dateNaissance;
	
	
	
	@OneToMany(mappedBy = "etudiant")
    Set<Absence> absences;
	
	@ManyToOne(cascade = CascadeType.ALL)
    private Classe classe;
	
	
	
	 
	

}
