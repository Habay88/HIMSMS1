package com.habay.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="qualifications")
public class Qualifications {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	
	@Column(name="qualificationname", length=100, nullable=false)
	private String qualificationName;
	
	@Column(name="institutename", length=100, nullable=false)
	private String instituteName;
	
	@Column(name="procurementyear", length=100, nullable=false)
	private LocalDate procurement_year;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "doctor_id")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Doctor doctor;

	
	



	



	
}
