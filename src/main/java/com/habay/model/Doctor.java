package com.habay.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import javax.persistence.*;
import javax.validation.constraints.Email;

import lombok.Data;

@Entity
@Table(name="doctor")
public class Doctor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="firstname", length=100, nullable=false)
	private String firstName;
	
	@Column(name="lastname", length=100, nullable=false)
	private String lastName;
	
	 @Email(message = "Please enter a valid e-mail address")
		@Column(length = 120, nullable = false, unique = true)
		private String email;
	
	@Column(name="professionalstatement", length=100, nullable=false)
	private String professionalStatement;
	
	
	@Column(name="practicingfrom", nullable=false)
	private LocalDate practicing_from;

	@Column(name="create_time")
	private LocalDateTime createTime;
	
	@OneToMany(mappedBy="doctor", cascade = CascadeType.ALL,orphanRemoval=true)
	private Set<Qualifications> qualifications = new HashSet<>();

	@OneToMany(mappedBy="doctor",cascade = CascadeType.ALL,orphanRemoval=true )
	private Set<Specialization> specializations = new HashSet<>() ;
	
	

	@OneToMany(mappedBy="doctor", cascade = CascadeType.ALL,orphanRemoval=true)
	private Set<HospitalAffiliation> hospitalAffiliations = new HashSet<>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getProfessionalStatement() {
		return professionalStatement;
	}


	public void setProfessionalStatement(String professionalStatement) {
		this.professionalStatement = professionalStatement;
	}


	public LocalDate getPracticing_from() {
		return practicing_from;
	}


	public void setPracticing_from(LocalDate practicing_from) {
		this.practicing_from = practicing_from;
	}


	public LocalDateTime getCreateTime() {
		return createTime;
	}


	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}


	public Set<Qualifications> getQualifications() {
		return qualifications;
	}


	public void setQualifications(Set<Qualifications> qualifications) {
		this.qualifications = qualifications;
		for(Qualifications q : qualifications) {
			q.setDoctor(this);
		}
	}


	public Set<Specialization> getSpecializations() {
		return specializations;
	}


	public void setSpecializations(Set<Specialization> specializations) {
		this.specializations = specializations;
//		for(Specialization s : specializations) {
//			s.setDoctor(this);
//		}
	}


	public Set<HospitalAffiliation> getHospitalAffiliations() {
		return hospitalAffiliations;
	}


	public void setHospitalAffiliations(Set<HospitalAffiliation> hospitalAffiliations) {
		this.hospitalAffiliations = hospitalAffiliations;
		for(HospitalAffiliation h : hospitalAffiliations) {
			h.setDoctor(this);
		}
	}
	
	

}
























































