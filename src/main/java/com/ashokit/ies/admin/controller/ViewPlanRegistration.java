package com.ashokit.ies.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.admin.domain.PlanRegistration;
import com.ashokit.ies.admin.service.AccountRegistrationService;

@Controller
public class ViewPlanRegistration {
	
	@Autowired
	private AccountRegistrationService service;

	@GetMapping(value={"/ViewPlans","loadViewPlans"})
	public String handleViewCntrlHyperLink(Model model) {
		List<PlanRegistration> plans = service.getAllPlans();
		model.addAttribute("plans",plans);
		return "ViewPlans";
	}
	
	@GetMapping("/editPlan")
	public String getPlan(@RequestParam("planId") Integer id,Model model) {
		PlanRegistration pln = service.getPlanById(id);
		model.addAttribute("plans",pln);
		return "EditPlan";
	}
	
	@PostMapping("/updatePlan")
	public String handleRegisterBtn(PlanRegistration pln,RedirectAttributes redattr) {
		boolean savePlan = service.editPlan(pln);
		if(savePlan) {
			redattr.addFlashAttribute("succMsg", "Plan Updated Successfully");
		}else {
			redattr.addFlashAttribute("errMsg", "Plan Updation Failed");
		}
		return "redirect:loadViewPlans";
	}
	
	@GetMapping("/deletePlan")
	public String deleteAccount(@RequestParam("planId") Integer id,Model model) {
		PlanRegistration deleteAccount = service.deletePlan(id);
		if(deleteAccount.getStatus() == "D") {
			model.addAttribute("errMsg","Plan Disabled Successfully");
			model.addAttribute("status","D");
		}else {
			model.addAttribute("succMsg","plan enabled Successfully");
			model.addAttribute("status","A");
		}
		return "redirect:loadViewPlans";
	}
	

}
