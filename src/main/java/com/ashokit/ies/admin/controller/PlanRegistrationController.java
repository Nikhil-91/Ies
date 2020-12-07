package com.ashokit.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.admin.domain.PlanRegistration;
import com.ashokit.ies.admin.service.AccountRegistrationService;

@Controller
public class PlanRegistrationController {
	
	@Autowired
	private AccountRegistrationService service;
	
	@GetMapping(value= {"/plan","loadPlan"})
	public String loadIndex(Model model) {
		PlanRegistration pln=new PlanRegistration();
		model.addAttribute("plans", pln);
		return "PlanRegistration";
	}
	
	@PostMapping("/planRegister")
	public String handleRegisterBtn(PlanRegistration pln,RedirectAttributes redattr) {
		boolean savePlan = service.savePlan(pln);
		if(savePlan) {
			redattr.addFlashAttribute("succMsg", "Plan Created Successfully");
		}else {
			redattr.addFlashAttribute("errMsg", "Plan Creation Failed");
		}
		return "redirect:loadPlan";
	}
	

}
