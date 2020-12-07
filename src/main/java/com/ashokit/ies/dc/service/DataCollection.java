package com.ashokit.ies.dc.service;

import com.ashokit.ies.dc.domain.AppRegiDtls;
import com.ashokit.ies.dc.domain.CaseCreation;

public interface DataCollection {
	
	public AppRegiDtls getApplDetails(String id);
	public boolean saveCaseDtls(CaseCreation appl);

}
