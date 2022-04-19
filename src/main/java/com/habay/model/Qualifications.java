package com.habay.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qualifications")
public class Qualifications {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="doctor_id", length=100, nullable=false)
	private int doctor_id;
	
	@Column(name="qualificationname", length=100, nullable=false)
	private String qualificationName;
	
	@Column(name="institutename", length=100, nullable=false)
	private String instituteName;
	
	@Column(name="procurementyear", length=100, nullable=false)
	private LocalDate procurement_year;

	public Qualifications() {
	
	}

	public Qualifications(Long id, int doctor_id, String qualificationName, String instituteName,
			LocalDate procurement_year) {
		
		this.id = id;
		this.doctor_id = doctor_id;
		this.qualificationName = qualificationName;
		this.instituteName = instituteName;
		this.procurement_year = procurement_year;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getQualificationName() {
		return qualificationName;
	}

	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public LocalDate getProcurement_year() {
		return procurement_year;
	}

	public void setProcurement_year(LocalDate procurement_year) {
		this.procurement_year = procurement_year;
	}
	
	
	
}
