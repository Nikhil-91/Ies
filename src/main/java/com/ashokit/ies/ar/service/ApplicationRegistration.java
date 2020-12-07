package com.ashokit.ies.ar.service;

import java.util.List;

import com.ashokit.ies.ar.domain.AppRegistration;

public interface ApplicationRegistration {
	
	public AppRegistration saveApplication(AppRegistration appl);
	public List<AppRegistration> getAllApplications();
	public AppRegistration getApplicationById(String id);
	public AppRegistration deleteApplication(String id);
	public boolean editApplication(AppRegistration appl);
	boolean isSsnValid(long ssn);

}
