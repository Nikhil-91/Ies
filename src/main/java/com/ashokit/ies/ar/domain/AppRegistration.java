package com.ashokit.ies.ar.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AppRegistration {
	private String appId;
	private String fname;
	private String lname;
	private String dob;
	private String gender;
	private long ssn;
	private long phoneNo;
	private String email;
	private String status;
	private Timestamp createDate;
	private Timestamp updateDate;
	

}
