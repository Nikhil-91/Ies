package com.ashokit.ies.ar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.ar.domain.AppRegistration;
import com.ashokit.ies.ar.service.ApplicationRegistration;

@Controller
public class ApplicationRegistrationController {

	@Autowired
	private ApplicationRegistration service;

	@GetMapping(value = { "/appl", "loadAppl" })
	public String loadIndex(Model model) {
		AppRegistration accReg = new AppRegistration();
		model.addAttribute("apps", accReg);
		return "ApplicationRegistration";
	}

	@PostMapping("/appRegister")
	public String handleRegisterBtn(AppRegistration accReg, RedirectAttributes redattr) {
		AppRegistration  saveAppl= service.saveApplication(accReg);
		if (saveAppl!=null && saveAppl.getAppId()!=null) {
			redattr.addFlashAttribute("succMsg", "Application Created Successfully, Your Application Id: "+saveAppl.getAppId());
		} else {
			redattr.addFlashAttribute("errMsg", "Registration Failed! User not belongs to Kentucky State");
		}
		return "redirect:loadAppl";
	}
	
	@GetMapping("/ssnCheck")
	@ResponseBody
	public String isSsnValid(@RequestParam("ssn") long ssn) {
		return service.isSsnValid(ssn) ? "Valid" : "Invalid";
	}

}
