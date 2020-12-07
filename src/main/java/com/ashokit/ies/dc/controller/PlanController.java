package com.ashokit.ies.dc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlanController {

	@GetMapping(value="/loadPlanSelection")
	public String loadPlanForm(Model model) {
		return "planCreation";
		
	}
}
