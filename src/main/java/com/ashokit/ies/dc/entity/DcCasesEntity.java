package com.ashokit.ies.dc.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="dc_cases")
public class DcCasesEntity {
	@Id
	@SequenceGenerator(name="case_id",sequenceName ="case_id_seq",allocationSize = 1)
	@GeneratedValue(generator = "case_id",strategy = GenerationType.SEQUENCE)
	public Integer caseId;
	private String appId;
	private String fname;
	private String lname;
	private String dob;
	private String gender;
	private long ssn;
	private long phoneNo;
	private String email;
	@CreationTimestamp
	private Timestamp createDate;
	@UpdateTimestamp
	private Timestamp updateDate;

}
