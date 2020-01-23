package com.example.absenceManager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.absenceManager.entity.Etudiant;
import com.example.absenceManager.repository.EtudiantRepo;

@Controller
@RequestMapping("/etudiants/")
public class EtudiantController {

	private final  EtudiantRepo etudiantRepo;

	@Autowired
	public EtudiantController(EtudiantRepo etudiantRepo) {
		this.etudiantRepo = etudiantRepo;
	}

	@GetMapping("signup")
	public String showSignUpForm(Etudiant etudiant) {
		return "etudiantTemplates/add-etudiant";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("etudiants", etudiantRepo.findAll());
		return "etudiantTemplates/index";
	}

	@PostMapping("add")
	public String addEtudiant(@Valid Etudiant etudiant, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "etudiantTemplates/add-etudiant";
		}

		etudiantRepo.save(etudiant);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Etudiant etudiant = etudiantRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid etudiant Id:" + id));
		model.addAttribute("etudiant", etudiant);
		return "etudiantTemplates/update-etudiant";
	}

	@PostMapping("update/{id}")
	public String updateClasse(@PathVariable("id") long id, @Valid Etudiant etudiant, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			etudiant.setId(id);
			return "etudiantTemplates/update-etudiant";
		}

		etudiantRepo.save(etudiant);
		model.addAttribute("etudiants", etudiantRepo.findAll());
		return "etudiantTemplates/index";
	}

	@GetMapping("delete/{id}")
	public String deleteEtudiant(@PathVariable("id") long id, Model model) {
		Etudiant etudiant = etudiantRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid etudiant Id:" + id));
		etudiantRepo.delete(etudiant);
		model.addAttribute("etudiants", etudiantRepo.findAll());
		return "etudiantTemplates/index";
	}
}
