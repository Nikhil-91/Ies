package com.ashokit.ies.co.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="BATCH_RUN_DTLS")
public class BatchRunDtlsEntity {

	@Id
	@GeneratedValue
	@Column(name="BATCH_RUN_SEQ")
	private Integer batchRunSeq;
	@Column(name="BATCH_NAME")
	private String batchName;
	@Column(name="BATCH_RUN_STATUS")
	private String status;
	@Column(name="END_DATE")
	private Timestamp endDate;
	@Column(name="INSTANCE_NUM")
	private String instanceNo;
	@Column(name="START_DATE")
	private Timestamp startDate;
}
