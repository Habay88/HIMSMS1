package com.habay.model;

import java.time.LocalDate;

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
@Table(name="office")
public class Office {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int time_slot_per_client_in_min;
	
	private int first_consultation_fee;
	
	private int followup_consultation_fee;
	
	private String street_address;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String zip;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "doctor_id")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Doctor doctor;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "hospital_affiliation_id")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private HospitalAffiliation hospital_affiliation;
	
}
