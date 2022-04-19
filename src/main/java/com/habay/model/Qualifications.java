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
	private Long doctorId;
	
	@Column(name="qualificationname", length=100, nullable=false)
	private String qualificationName;
	
	@Column(name="institutename", length=100, nullable=false)
	private String instituteName;
	
	@Column(name="procurementyear", length=100, nullable=false)
	private LocalDate procurement_year;

	public Qualifications() {
	
	}

	public Qualifications(Long id, Long doctorId, String qualificationName, String instituteName,
			LocalDate procurement_year) {
		super();
		this.id = id;
		this.doctorId = doctorId;
		this.qualificationName = qualificationName;
		this.instituteName = instituteName;
		this.procurement_year = procurement_year;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
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

	@Override
	public String toString() {
		return "Qualifications [id=" + id + ", doctorId=" + doctorId + ", qualificationName=" + qualificationName
				+ ", instituteName=" + instituteName + ", procurement_year=" + procurement_year + "]";
	}



	



	
}
