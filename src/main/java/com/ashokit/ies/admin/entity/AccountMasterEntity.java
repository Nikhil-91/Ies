package com.ashokit.ies.admin.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Data
@Entity
@Table(name="Account_Master")
public class AccountMasterEntity {
	@Id
	@SequenceGenerator(name = "acct_mstr_seq",sequenceName ="account_master_seq",allocationSize = 1)
	@GeneratedValue(generator = "acct_mstr_seq",strategy = GenerationType.SEQUENCE)
	@Column(name="AccountId")
	private Integer accountId;
	@Column(name="FirstName")
	private String fname;
	@Column(name="LastName")
	private String lname;
	@Column(name="Email")
	private String email;
	@Column(name="Password")
	private String passwd;
	@Column(name="DOB")
	private String dob;
	@Column(name="Gender")
	private String gender;
	@Column(name="SSN")
	private long ssn;
	@Column(name="PhoneNo")
	private long phoneNo;
	@Column(name="Role")
	private String role;
	@Column(name="status")
	private String status;
	@CreationTimestamp
	private Timestamp createDate;
	@UpdateTimestamp
	private Timestamp updateDate;
}
