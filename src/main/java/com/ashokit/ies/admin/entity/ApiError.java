package com.ashokit.ies.admin.entity;

import java.util.Date;

import lombok.Data;

@Data
public class ApiError {

	private Integer errCode;
	private String errStatus;
	private Date errDate;

}
