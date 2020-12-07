package com.ashokit.ies.dc.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ApiError {
	
	private String errCode;
	private String errDesc;
	private Date date;

}
