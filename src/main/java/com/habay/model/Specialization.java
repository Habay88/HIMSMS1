package com.habay.model;

import java.util.ArrayList;
import java.util.HashSet;
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
import javax.persistence.OneToMany;
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

	
  	public Specialization() {
		
	}








	public Specialization(Long id, String specializationName) {
		super();
		this.id = id;
		this.specializationName = specializationName;
	}








	public Specialization(String specializationName) {
		
		this.specializationName = specializationName;
		
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



	@Override
	public String toString() {
		return "Specialization [id=" + id + ", specializationName=" + specializationName + "]";
	}



	

	
}
