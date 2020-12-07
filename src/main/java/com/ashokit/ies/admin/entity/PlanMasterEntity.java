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
@Table(name="Plan_Master")
public class PlanMasterEntity {
	@Id
	@SequenceGenerator(name = "pln_mstr_seq",sequenceName ="plan_master_seq",allocationSize = 1)
	@GeneratedValue(generator = "pln_mstr_seq",strategy = GenerationType.SEQUENCE)
	private Integer planId;
	@Column(name="PlanName")
	private String pname;
	@Column(name="Description")
	private String pdesc;
	@Column(name="Start_Date")
	private String sdate;
	@Column(name="End_Date")
	private String edate;
	@Column(name="status")
	private String status;
	@CreationTimestamp
	private Timestamp createDate;
	@UpdateTimestamp
	private Timestamp updateDate;

}
