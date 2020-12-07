package com.ashokit.ies.admin.service;

import java.util.List;

import com.ashokit.ies.admin.domain.AccountRegistration;
import com.ashokit.ies.admin.domain.PlanRegistration;

public interface AccountRegistrationService {
	public boolean saveAccount(AccountRegistration acct);
	public String getSuccRegMailBody(AccountRegistration acct);
	public boolean sendSuccRegMail(String to,String subject,String body);
	public boolean isUniqueEmail(String email);
	public List<AccountRegistration> getAllCaseWorkers(String role);
	public AccountRegistration getAccuountById(Integer id);
	public AccountRegistration deleteAccount(Integer id);
	public boolean editAccount(AccountRegistration accReg);
	public boolean savePlan(PlanRegistration pln);
	public List<PlanRegistration> getAllPlans();
	public PlanRegistration getPlanById(Integer id);
	public PlanRegistration deletePlan(Integer id);
	public boolean editPlan(PlanRegistration accReg);

}
