package com.ashokit.ies.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ashokit.ies.dc.domain.AppRegiDtls;
import com.ashokit.ies.dc.domain.CaseCreation;
import com.ashokit.ies.dc.service.DataCollection;

@Controller
public class CreateCaseController {
	
	@Autowired
	private DataCollection service;
	
	@GetMapping(value="/createCase")
	public String loadCaseForm() {
		return "CreateCase";
	}
	
	@GetMapping(value="/getApplDetails/{Appid}")
	@ResponseBody
	public ResponseEntity<AppRegiDtls> getApplDtls(@PathVariable("Appid") String id){
		System.out.println("Input"+id);
		AppRegiDtls applDetails = service.getApplDetails(id);
		return new ResponseEntity<AppRegiDtls>(applDetails,HttpStatus.OK);
		
	}
	
	@PostMapping(value="/createCaseDtls")
	@ResponseBody
	public String handleCaseCreation(@RequestBody CaseCreation cs) {
		AppRegiDtls applDetails = service.getApplDetails(cs.getAppId());
		if(applDetails.getAppId()!=cs.getAppId()) {
			boolean saveCaseDtls = service.saveCaseDtls(cs);
		    if(saveCaseDtls) {
		    	return "valid";
		    }
		    else {
		    	return "invalid";
		    }
		}else {
			return "duplicate";
		}
	    
	}

}
