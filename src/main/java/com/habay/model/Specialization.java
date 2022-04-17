package com.habay.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="specialization")
public class Specialization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="specializationname", length=100, nullable=false,unique=true)
	private String specializationName;
	
	
	 @ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      },
mappedBy="specializations")
	 @JsonIgnore
private List<Doctor> doctors;



	public Specialization() {
		
	}



	public Specialization(Long id, String specializationName, List<Doctor> doctors) {
		super();
		this.id = id;
		this.specializationName = specializationName;
		this.doctors = doctors;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getSpecializationName() {
		return specializationName;
	}



	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}



	public List<Doctor> getDoctors() {
		return doctors;
	}



	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}


	

	
}
