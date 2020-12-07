package com.ashokit.ies.admin.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AccountRegistration {
	private Integer accountId;
	private String fname;
	private String lname;
	private String email;
	private String passwd;
	private String dob;
	private String gender;
	private long ssn;
	private long phoneNo;
	private String role;
	private String status;
	private Timestamp createDate;
	private Timestamp updateDate;

}
