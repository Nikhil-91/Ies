package com.ashokit.ies.admin.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.admin.domain.AccountRegistration;
import com.ashokit.ies.admin.domain.PlanRegistration;
import com.ashokit.ies.admin.entity.AccountMasterEntity;
import com.ashokit.ies.admin.entity.PlanMasterEntity;
import com.ashokit.ies.admin.repository.AccountMasterRepsitory;
import com.ashokit.ies.admin.repository.PlanMasterRepository;
import com.ashokit.ies.util.EmailUtil;

@Service
public class AccountRegistrationServiceImpl implements AccountRegistrationService {
	
	@Autowired
	private AccountMasterRepsitory repo;
	
	@Autowired
	private PlanMasterRepository planRepo;
	
	@Autowired
	private EmailUtil emailUtil;

	@Override
	public boolean saveAccount(AccountRegistration acct) {
		AccountMasterEntity entity=new AccountMasterEntity();
		acct.setStatus("A");
		BeanUtils.copyProperties(acct, entity);
		AccountMasterEntity save = repo.save(entity);
		if(save!=null && save.getAccountId()!=null) {
			String to=acct.getEmail();
			String subject="Welcome to IES Family||Registration successfully completed";
			String body=getSuccRegMailBody(acct);
			return sendSuccRegMail(to, subject, body);
		}
		return false;
	}

	@Override
	public String getSuccRegMailBody(AccountRegistration acct) {
		String filename = "User_Account_Reg.txt";
		String body = null;

		Path path = Paths.get(filename, "");
		java.util.stream.Stream<String> lines;
		try {
			lines = Files.lines(path);
			List<String> replacedLines = lines.map(
					line -> line.replace("{fname}", acct.getFname()).replace("{lname}", acct.getLname())
							.replace("{email}",acct.getEmail()).replace("{passwd}", acct.getPasswd())
							.replace("{role}",acct.getRole()))
					.collect(Collectors.toList());
			body = String.join("", replacedLines);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return body;
	}

	@Override
	public boolean sendSuccRegMail(String to, String subject, String body) {
		return emailUtil.sendMail(to, subject, body);
	}
	
	public boolean isUniqueEmail(String email) {
		AccountMasterEntity isUnqEmail = repo.findByemail(email);
		return isUnqEmail != null ? false : true;
	}
	
	public List<AccountRegistration> getAllCaseWorkers(String role){
		List<AccountMasterEntity> findAllByrole = repo.findAllByrole(role);
		List<AccountRegistration> acctList=new ArrayList<AccountRegistration>();
		findAllByrole.forEach(entity -> {
			AccountRegistration acct=new AccountRegistration();
			BeanUtils.copyProperties(entity, acct);
			acctList.add(acct);
		});
		return acctList;
	}

	@Override
	public AccountRegistration getAccuountById(Integer id) {
		AccountRegistration acct=new AccountRegistration();
		Optional<AccountMasterEntity> findById = repo.findById(id);
		if(findById.isPresent()) {
			AccountMasterEntity entity = findById.get();
			BeanUtils.copyProperties(entity, acct);
			return acct;
		}
		return null;
	}

	@Override
	public AccountRegistration deleteAccount(Integer id) {
		String status="";
		Optional<AccountMasterEntity> findById = repo.findById(id);
		if(findById.isPresent()) {
			AccountMasterEntity entity = findById.get();
			if(entity.getStatus().equals("A")) {
				status="D";
			}
			
			if(entity.getStatus().equals("D")) {
				status="A";
			}
			entity.setStatus(status);
			AccountMasterEntity update = repo.save(entity);
			AccountRegistration acct=new AccountRegistration();
			BeanUtils.copyProperties(update, acct);
			if(update!=null) {
				return acct;
			}
		}
		return null;
	}

	@Override
	public boolean editAccount(AccountRegistration accReg) {
		Optional<AccountMasterEntity> findById = repo.findById(accReg.getAccountId());
		if(findById.isPresent()) {
			AccountMasterEntity entity = findById.get();
			entity.setFname(accReg.getFname());
			entity.setLname(accReg.getLname());
			entity.setEmail(accReg.getEmail());
			entity.setRole(accReg.getRole());
			AccountMasterEntity save = repo.save(entity);
			if(save!=null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean savePlan(PlanRegistration pln) {
		PlanMasterEntity entity=new PlanMasterEntity();
		BeanUtils.copyProperties(pln, entity);
		entity.setStatus("A");
		PlanMasterEntity save = planRepo.save(entity);
		if(save!=null && save.getPlanId()!=null) {
			return true;
		}
		return false;
	}

	@Override
	public List<PlanRegistration> getAllPlans() {
		List<PlanMasterEntity> all = planRepo.findAll();
		List<PlanRegistration> allArr=new ArrayList<PlanRegistration>();
		all.forEach(entity -> {
			PlanRegistration pln=new PlanRegistration();
			BeanUtils.copyProperties(entity, pln);
			allArr.add(pln);
		});
		return allArr;
	}

	@Override
	public PlanRegistration getPlanById(Integer id) {
		PlanRegistration pln=new PlanRegistration();
		Optional<PlanMasterEntity> findById = planRepo.findById(id);
		if(findById.isPresent()) {
			PlanMasterEntity entity = findById.get();
			BeanUtils.copyProperties(entity, pln);
			return pln;
		}
		return null;
	}

	@Override
	public PlanRegistration deletePlan(Integer id) {
		String status="";
		Optional<PlanMasterEntity> findById = planRepo.findById(id);
		if(findById.isPresent()) {
			PlanMasterEntity entity = findById.get();
			if(entity.getStatus().equals("A")) {
				status="D";
			}
			
			if(entity.getStatus().equals("D")) {
				status="A";
			}
			entity.setStatus(status);
			PlanMasterEntity update = planRepo.save(entity);
			PlanRegistration pln=new PlanRegistration();
			BeanUtils.copyProperties(update, pln);
			if(update!=null) {
				return pln;
			}
		}
		return null;
	}

	@Override
	public boolean editPlan(PlanRegistration pln) {
		PlanMasterEntity entity=new PlanMasterEntity();
		BeanUtils.copyProperties(pln, entity);
		PlanMasterEntity save = planRepo.save(entity);
			if(save!=null) {
				return true;
			}
		return false;
	}



}
