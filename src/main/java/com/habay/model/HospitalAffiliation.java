package com.habay.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hospital_affiliation")
public class HospitalAffiliation {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String HospitalName;
	private String City;
	private String Country;
	private Date StartDate;
	private Date EndDate;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "doctor_id", nullable=false)
	private Doctor doctor;
	
}

