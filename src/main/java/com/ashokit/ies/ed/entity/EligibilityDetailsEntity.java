package com.ashokit.ies.ed.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="eligibility_details")
public class EligibilityDetailsEntity {
	@Id
	@GeneratedValue
	@Column(name="ed_trace_id")
	private Integer edTraceId;
	@Column(name="benefit_amt")
    private String benefitAmount;
	@Column(name="case_num")
    private Integer caseNo;
    @CreationTimestamp
    @Column(name="create_dt")
    private Date createdDate;
    @Column(name="denial_reason")
    private Date denialReason;
    @Column(name="plan_end_dt")
    private String planEndDate;
    @Column(name="plan_name")
    private String planName;
    @Column(name="plan_start_dt")
    private String planStartDate;
    @Column(name="plan_status")
    private String planStatus;
    @Column(name="update_dt")
    private Date updatedDate;
    

}
