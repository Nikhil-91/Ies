package com.ashokit.ies.ed.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="co_triggers")
public class CoTriggersEntity {
	@Id
	@GeneratedValue
	@Column(name="trg_id")
	private Integer triggerId;
	@Column(name="case_num")
	private Integer caseNo;
	@Column(name="create_dt")
	private Timestamp createDate;
	@Column(name="trg_status")
	private String triggerStatus;
	@Column(name="update_dt")
	private Timestamp updateDate;

}
