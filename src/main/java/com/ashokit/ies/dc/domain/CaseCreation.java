package com.ashokit.ies.dc.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CaseCreation {
	public Integer caseId;
	private String appId;
	private String fname;
	private String lname;
	private String dob;
	private String gender;
	private long ssn;
	private long phoneNo;
	private String email;
	private Timestamp createDate;
	private Timestamp updateDate;
	

}
