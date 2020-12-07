package com.ashokit.ies.dc.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.ar.entity.ApplicationMasterEntity;
import com.ashokit.ies.ar.repository.ApplicationMasterRepository;
import com.ashokit.ies.dc.domain.AppRegiDtls;
import com.ashokit.ies.dc.domain.CaseCreation;
import com.ashokit.ies.dc.entity.DcCasesEntity;
import com.ashokit.ies.dc.repository.DcCasesRepository;
import com.ashokit.ies.exception.DataNotFoundException;
@Service
public class DataCollectionImpl implements DataCollection {
	@Autowired
	private ApplicationMasterRepository repo;
	
	@Autowired
	private DcCasesRepository dc_repo;

	@Override
	public AppRegiDtls getApplDetails(String id) {
	  AppRegiDtls appl=new AppRegiDtls();
		Optional<ApplicationMasterEntity> findById = repo.findById(id);
		if(findById.isPresent()) {
			 ApplicationMasterEntity entity = findById.get();
			 BeanUtils.copyProperties(entity, appl);
			 return appl;
		}else {
			throw new DataNotFoundException("Application Number Not Found");
		}
		
	}

	@Override
	public boolean saveCaseDtls(CaseCreation appl) {
		DcCasesEntity entity=new DcCasesEntity();
		BeanUtils.copyProperties(appl, entity);
		DcCasesEntity save = dc_repo.save(entity);
		return save!=null && save.getCaseId()!=null ? true : false;
	}

}
