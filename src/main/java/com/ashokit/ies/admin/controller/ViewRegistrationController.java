package com.ashokit.ies.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.admin.domain.AccountRegistration;
import com.ashokit.ies.admin.service.AccountRegistrationService;

@Controller
public class ViewRegistrationController {
	
	@Autowired
	private AccountRegistrationService service;

	@GetMapping(value={"/ViewAccounts","loadViewAccounts"})
	public String handleViewCntrlHyperLink(Model model) {
		List<AccountRegistration> caseWorkers = service.getAllCaseWorkers("caseworker");
		model.addAttribute("users",caseWorkers);
		return "ViewAccounts";
	}
	
	@GetMapping("/editAccount")
	public String getAccount(@RequestParam("accountId") Integer id,Model model) {
		AccountRegistration acct = service.getAccuountById(id);
		model.addAttribute("account",acct);
		return "EditAccount";
	}
	
	@PostMapping("/updateAccount")
	public String handleRegisterBtn(AccountRegistration accReg,RedirectAttributes redattr) {
		boolean saveAccount = service.editAccount(accReg);
		if(saveAccount) {
			redattr.addFlashAttribute("succMsg", "Account Details Updated Successfully");
		}else {
			redattr.addFlashAttribute("errMsg", "Updation Failed");
		}
		return "redirect:loadViewAccounts";
	}
	
	@GetMapping("/deleteAccount")
	public String deleteAccount(@RequestParam("accountId") Integer id,Model model) {
		AccountRegistration deleteAccount = service.deleteAccount(id);
		if(deleteAccount.getStatus() == "D") {
			model.addAttribute("errMsg","Account Disabled Successfully");
			model.addAttribute("status","D");
		}else {
			model.addAttribute("succMsg","Account enabled Successfully");
			model.addAttribute("status","A");
		}
		return "redirect:loadViewAccounts";
	}
	
	@GetMapping("/getAccountsByRole")
	public String getAccountsByRole(@RequestParam("role") String role,Model model) {
		System.out.println(role);
		List<AccountRegistration> roles = service.getAllCaseWorkers(role);
		model.addAttribute("users",roles);
		System.out.println(roles);
		return "ViewAccounts";
	}
}
