package com.ashokit.ies.ar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ashokit.ies.admin.entity.ApiError;
import com.ashokit.ies.ar.domain.AppRegistration;
import com.ashokit.ies.ar.domain.SsaWebResponse;
import com.ashokit.ies.ar.entity.ApplicationMasterEntity;
import com.ashokit.ies.ar.repository.ApplicationMasterRepository;
@Service
public class ApplicationRegistrationImpl implements ApplicationRegistration {

	@Autowired
	private ApplicationMasterRepository repo;

	@Override
	public AppRegistration saveApplication(AppRegistration appl) {
		ApplicationMasterEntity entity = new ApplicationMasterEntity();
		AppRegistration app=new AppRegistration();
		BeanUtils.copyProperties(appl, entity);
		RestTemplate rt = new RestTemplate();
		ResponseEntity<SsaWebResponse> forEntity = rt
				.getForEntity("http://localhost:9000/getUserDetailsBySsn/" + appl.getSsn(), SsaWebResponse.class);
		if (forEntity.getStatusCodeValue() == 200) {
			SsaWebResponse body = forEntity.getBody();
			System.out.println(body.getStateName());
			if (body.getStateName().equals("KT")) {
				entity.setStatus("A");
				ApplicationMasterEntity save = repo.save(entity);
				BeanUtils.copyProperties(entity, app);
				if (save != null && save.getAppId() != null) {
					return app;
				}
			}
		}

		return null;
	}

	@Override
	public List<AppRegistration> getAllApplications() {
		List<ApplicationMasterEntity> all = repo.findAll();
		List<AppRegistration> allArr = new ArrayList<AppRegistration>();
		all.forEach(entity -> {
			AppRegistration pln = new AppRegistration();
			BeanUtils.copyProperties(entity, pln);
			allArr.add(pln);
		});
		return allArr;
	}

	@Override
	public AppRegistration getApplicationById(String id) {
		AppRegistration pln = new AppRegistration();
		Optional<ApplicationMasterEntity> findById = repo.findById(id);
		if (findById.isPresent()) {
			ApplicationMasterEntity entity = findById.get();
			BeanUtils.copyProperties(entity, pln);
			return pln;
		}
		return null;
	}

	@Override
	public AppRegistration deleteApplication(String id) {
		String status = "";
		Optional<ApplicationMasterEntity> findById = repo.findById(id);
		if (findById.isPresent()) {
			ApplicationMasterEntity entity = findById.get();
			if (entity.getStatus().equals("A")) {
				status = "D";
			}

			if (entity.getStatus().equals("D")) {
				status = "A";
			}
			entity.setStatus(status);
			ApplicationMasterEntity update = repo.save(entity);
			AppRegistration pln = new AppRegistration();
			BeanUtils.copyProperties(update, pln);
			if (update != null) {
				return pln;
			}
		}
		return null;
	}

	@Override
	public boolean editApplication(AppRegistration appl) {
		Optional<ApplicationMasterEntity> findById = repo.findById(appl.getAppId());
		if (findById.isPresent()) {
			 ApplicationMasterEntity entity = findById.get();
		      entity.setFname(appl.getFname());
		      entity.setLname(appl.getLname());
		      entity.setDob(appl.getDob());
		      entity.setSsn(appl.getSsn());
		      ApplicationMasterEntity save = repo.save(entity);
				if (save != null) {
					return true;
				}
		}
		
		return false;
	}

	public boolean isSsnValid(long ssn) {
		try {
			RestTemplate rt = new RestTemplate();
			ResponseEntity<ApiError> forEntity = rt.getForEntity("http://localhost:9000/getUserDetailsBySsn/" + ssn,
					ApiError.class);
			if (forEntity.getStatusCodeValue() == 400) {
				return false;
			}
			return true;
		}catch(Exception e) {
			return false;
		}
		

	}

}
