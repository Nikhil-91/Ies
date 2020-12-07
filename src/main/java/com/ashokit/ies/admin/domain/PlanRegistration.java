package com.ashokit.ies.admin.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PlanRegistration {
	
	private Integer planId;
	private String pname;
	private String pdesc;
	private String sdate;
	private String edate;
	private String status;
	private Timestamp createDate;
	private Timestamp updateDate;
	

}
