package com.habay.model;

import java.sql.Timestamp;

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
@Entity
@Table(name="in_network_insurance")
public class InNetworkInsurance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String insuranceName;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "office_id")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Office office;
}
