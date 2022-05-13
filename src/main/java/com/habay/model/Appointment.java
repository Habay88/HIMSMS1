package com.habay.model;

import java.sql.Timestamp;
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
@Table(name="appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Timestamp probableStartTime;
	private Timestamp probableEndTime;
	private Date appointmentTakenDate;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "user_account_id")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private ClientAccount clientaccount;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "office_id")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Office office;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "Appointment_Status_id")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private AppointmentStatus appointmentStatus;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "appBooking_Channel_id")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private AppBookingChannel appBookingChannel;
}
