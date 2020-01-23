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

import com.example.absenceManager.entity.Classe;
import com.example.absenceManager.repository.ClasseRepo;

@Controller
@RequestMapping("/classes/")
public class ClasseController {

	private final  ClasseRepo classeRepo;

	@Autowired
	public ClasseController(ClasseRepo classeRepo) {
		this.classeRepo = classeRepo;
	}

	@GetMapping("signup")
	public String showSignUpForm(Classe classe) {
		return "classeTemplates/add-classe";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("classes", classeRepo.findAll());
		return "classeTemplates/indexC";
	}

	@PostMapping("add")
	public String addClasse(@Valid Classe classe, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "classeTemplates/add-classe";
		}

		classeRepo.save(classe);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Classe classe = classeRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid classe Id:" + id));
		model.addAttribute("classe", classe);
		return "classeTemplates/update-classe";
	}

	@PostMapping("update/{id}")
	public String updateClasse(@PathVariable("id") long id, @Valid Classe classe, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			classe.setId(id);
			return "classeTemplates/update-classe";
		}

		classeRepo.save(classe);
		model.addAttribute("classes", classeRepo.findAll());
		return "classeTemplates/indexC";
	}

	@GetMapping("delete/{id}")
	public String deleteClasse(@PathVariable("id") long id, Model model) {
		Classe classe = classeRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid classe Id:" + id));
		classeRepo.delete(classe);
		model.addAttribute("classes", classeRepo.findAll());
		return "classeTemplates/indexC";
	}
}
