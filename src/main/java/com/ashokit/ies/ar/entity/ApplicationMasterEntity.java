package com.ashokit.ies.ar.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="Appl_Master")
public class ApplicationMasterEntity {
	@Id
	@GenericGenerator(name = "app_master_seq", strategy = "com.ashokit.ies.ar.generator.AppilicationGenerator")
	@GeneratedValue(generator ="app_master_seq" )
	private String appId;
	@Column(name="FirstName")
	private String fname;
	@Column(name="LastName")
	private String lname;
	@Column(name="DOB")
	private String dob;
	@Column(name="Gender")
	private String gender;
	@Column(name="SSN")
	private long ssn;
	@Column(name="PhoneNumber")
	private long phoneNo;
	@Column(name="Email")
	private String email;
	@Column(name="Status")
	private String status;
	@CreationTimestamp
	private Timestamp createDate;
	@UpdateTimestamp
	private Timestamp updateDate;

}
