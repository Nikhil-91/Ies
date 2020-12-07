package com.ashokit.ies.co.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CO_PDFS")
public class CoPdfsEntity {
	@Id
	@GeneratedValue
	@Column(name="CO_PDF_ID")
	private Integer id;
	@Column(name="PLAN_STATUS")
	private String status;
	@Column(name="CASE_NUMBER")
	private Integer caseNo;
	@Column(name="PDF_DOCUMENT")
	private Blob pdfDoc;
	@Column(name="PLAN_NAME")
	private String planName;

}
