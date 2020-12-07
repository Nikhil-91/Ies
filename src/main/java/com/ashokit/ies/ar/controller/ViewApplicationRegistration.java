package com.ashokit.ies.ar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.ar.domain.AppRegistration;
import com.ashokit.ies.ar.service.ApplicationRegistration;

@Controller
public class ViewApplicationRegistration {
	
	@Autowired
	private ApplicationRegistration service;

	@GetMapping(value={"/ViewApplication","loadViewApps"})
	public String handleViewCntrlHyperLink(Model model) {
		List<AppRegistration> apps = service.getAllApplications();
		model.addAttribute("apps",apps);
		return "ViewApplications";
	}
	
	@GetMapping("/editApp")
	public String getPlan(@RequestParam("appId") String id,Model model) {
		AppRegistration pln = service.getApplicationById(id);
		model.addAttribute("apps",pln);
		return "EditApplication";
	}
	
	@PostMapping("/updateApplication")
	public String handleRegisterBtn(AppRegistration appl,RedirectAttributes redattr) {
		boolean saveApp = service.editApplication(appl);
		if(saveApp) {
			redattr.addFlashAttribute("succMsg", "Application Updated Successfully");
		}else {
			redattr.addFlashAttribute("errMsg", "Application Updation Failed");
		}
		return "redirect:loadViewApps";
	}
	
	@GetMapping("/deleteApp")
	public String deleteAccount(@RequestParam("appId") String id,Model model) {
		AppRegistration deleteApp = service.deleteApplication(id);
		if(deleteApp.getStatus() == "D") {
			model.addAttribute("errMsg","Plan Disabled Successfully");
			model.addAttribute("status","D");
		}else {
			model.addAttribute("succMsg","plan enabled Successfully");
			model.addAttribute("status","A");
		}
		return "redirect:loadViewApps";
	}
	

}
