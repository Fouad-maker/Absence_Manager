package com.example.absenceManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import com.example.absenceManager.repository.AbsenceRepo;
import com.example.absenceManager.repository.EtudiantRepo;
import com.example.absenceManager.service.EmailService;

@Controller
public class MailController {
	
	@Autowired
    private EmailService emailService;
	
	@Autowired
	EtudiantRepo etudiantRepo;
	
	@Autowired
	AbsenceRepo absenceRepo;

	@Scheduled(cron = "0 0 * * 0 ")
    public String sendmail() {
    	
    	
    	
    	
    		
        emailService.sendMail("fouadhaddad916@gmail.com", "Test Subject", "Test mail");

    		
    	
        return "emailSent";
    }
    
    
    
    
}
