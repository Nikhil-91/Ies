package com.ashokit.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.admin.domain.AccountRegistration;
import com.ashokit.ies.admin.service.AccountRegistrationService;

@Controller
public class AccountRegistrationController {
	
	@Autowired
	private AccountRegistrationService service;
	
	@GetMapping(value= {"/account","loadAdmin"})
	public String loadIndex(Model model) {
		AccountRegistration accReg=new AccountRegistration();
		model.addAttribute("account", accReg);
		return "AccountRegistration";
	}
	
	@PostMapping("/register")
	public String handleRegisterBtn(AccountRegistration accReg,RedirectAttributes redattr) {
		boolean saveAccount = service.saveAccount(accReg);
		if(saveAccount) {
			redattr.addFlashAttribute("succMsg", "Account Created Successfully, please check email for more details");
		}else {
			redattr.addFlashAttribute("errMsg", "Registration Failed");
		}
		return "redirect:loadAdmin";
	}
	
	@GetMapping("/uniqueMailCheck")
	@ResponseBody
	public String isEmailUnique(@RequestParam("email") String email) {
		System.out.println("In IsEmailUniqye");
		return service.isUniqueEmail(email) ? "UNIQUE" : "DUPLICATE";
	}
	


}
