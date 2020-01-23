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

import com.example.absenceManager.entity.Matiere;
import com.example.absenceManager.repository.MatiereRepo;

@Controller
@RequestMapping("/matieres/")
public class MatiereController {

	private final  MatiereRepo matiereRepo;

	@Autowired
	public MatiereController(MatiereRepo matiereRepo) {
		this.matiereRepo = matiereRepo;
	}

	@GetMapping("signup")
	public String showSignUpForm(Matiere matiere) {
		return "matiereTemplates/add-matiere";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("matieres", matiereRepo.findAll());
		return "matiereTemplates/indexM";
	}

	@PostMapping("add")
	public String addMatiere(@Valid Matiere matiere, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "matiereTemplates/add-matiere";
		}

		matiereRepo.save(matiere);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Matiere matiere = matiereRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Matiere Id:" + id));
		model.addAttribute("matiere", matiere);
		return "matiereTemplates/update-matiere";
	}

	@PostMapping("update/{id}")
	public String updateEtudiant(@PathVariable("id") long id, @Valid Matiere matiere, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			matiere.setId(id);
			return "matiereTemplates/update-matiere";
		}

		matiereRepo.save(matiere);
		model.addAttribute("matieres", matiereRepo.findAll());
		return "matiereTemplates/indexM";
	}

	@GetMapping("delete/{id}")
	public String deleteEtudiant(@PathVariable("id") long id, Model model) {
		Matiere matiere = matiereRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Etudiant Id:" + id));
		matiereRepo.delete(matiere);
		model.addAttribute("matieres", matiereRepo.findAll());
		return "matiereTemplates/indexM";
	}
}
