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
import com.example.absenceManager.entity.Absence;
import com.example.absenceManager.repository.AbsenceRepo;
import com.example.absenceManager.repository.EtudiantRepo;
import com.example.absenceManager.repository.MatiereRepo;
import com.example.absenceManager.service.AbsenceServiceImp;

@Controller
@RequestMapping("/absences/")
public class AbsenceController {
	private final  AbsenceRepo absenceRepo;
	
	@Autowired
	public AbsenceController(AbsenceRepo absenceRepo , AbsenceServiceImp absenceService , EtudiantRepo etudiantRepo,MatiereRepo matiereRepo) {
		this.absenceRepo = absenceRepo;
	}
	
	
	

	@GetMapping("signup")
	public String showSignUpForm(Absence absence) {
		return "absenceTemplates/add-absence";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model ) {
		model.addAttribute("absences", absenceRepo.findAll());
		
		//model.addAttribute("absence", absenceService.sumAbsense());
		return "absenceTemplates/indexA";
	}
	@GetMapping("absence/{id}")
	public String showUpdateForm2(Model model , @PathVariable("id") Long id) {	
		//model.addAttribute("etudiant", etudiantRepo.findAll());
		
		model.addAttribute("findby", absenceRepo.sumAbsAllMatiere(id));
		//model.addAttribute("absence", absenceService.sumAbsense());
		return "absenceTemplates/indexB";
	}
	
	@GetMapping("absence/{id}/{idd}")
	public String showUpdateForm3(Model model , @PathVariable("id") Long id , @PathVariable("idd") Long idd) {	
		//model.addAttribute("etudiant", etudiantRepo.findAll());
		
		model.addAttribute("findbyy", absenceRepo.sumAbsenceSingleMatiere(id,idd));
		//model.addAttribute("absence", absenceService.sumAbsense());
		return "absenceTemplates/indexB";
	}
	
	@GetMapping("absence")
	public String showUpdateForm4(Model model) {	
		//model.addAttribute("etudiant", etudiantRepo.findAll());
		
		model.addAttribute("findbyyyy", absenceRepo.sumAbss());
		//model.addAttribute("absence", absenceService.sumAbsense());
		return "absenceTemplates/indexB";
	}
	@PostMapping("add")
	public String addAbsence(@Valid Absence absence, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "absenceTemplates/add-absence";
		}

		absenceRepo.save(absence);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Absence absence = absenceRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid absence Id:" + id));
		model.addAttribute("absence", absence);
		return "absenceTemplates/update-absence";
	}

	@PostMapping("update/{id}")
	public String updateClasse(@PathVariable("id") Long id, @Valid Absence absence, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			absence.setId(id);
			return "absenceTemplates/update-absence";
		}

		absenceRepo.save(absence);
		model.addAttribute("absences", absenceRepo.findAll());
		return "absenceTemplates/indexA";
	}

	@GetMapping("delete/{id}")
	public String deleteAbsence(@PathVariable("id") Long id, Model model) {
		Absence absence = absenceRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid etudiant Id:" + id));
		absenceRepo.delete(absence);
		model.addAttribute("absences", absenceRepo.findAll());
		return "absenceTemplates/indexA";
	}
	
	
	
	
				


}