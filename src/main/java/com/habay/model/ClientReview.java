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

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="clientreview")
public class ClientReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Boolean isReviewAnonymous;
	private int wait_time_rating;
	private int bedside_manner_rating;
	private int overall_rating;
	private String review;
	private Boolean isDoctorRecommended;
	private Date reviewDate;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "doctor_id")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Doctor doctor;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "user_account_id")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private ClientAccount clientaccount;
	
}
