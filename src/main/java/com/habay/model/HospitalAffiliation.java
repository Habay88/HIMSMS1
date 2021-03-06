package com.habay.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="hospital_affiliation")
public class HospitalAffiliation {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="hospitalname", length=100, nullable=false)
	private String HospitalName;
	@Column(name="city", length=100, nullable=false)
	private String City;
	@Column(name="country", length=50, nullable=false)
	private String Country;
	@Column(name="startDate", nullable=false)
	private Date StartDate;
	
	@Column(name="endDate",  nullable=false)
	private Date EndDate;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "doctor_id", nullable=false)
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Doctor doctor;
	
}

