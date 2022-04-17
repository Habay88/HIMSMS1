package com.habay.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name="doctor")
public class Doctor {

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
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      })
	//@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="doctor_specialization",
	joinColumns = @JoinColumn(name="specialization_Id",
	referencedColumnName="id"),
	inverseJoinColumns =@JoinColumn(name="doctor_id",
	referencedColumnName = "id"))
	private List<Specialization> specializations;
	

	public Doctor() {
		
	}


	public Doctor(Long id, String firstName, String lastName,
			@Email(message = "Please enter a valid e-mail address") String email, String professionalStatement,
			LocalDate practicing_from, LocalDateTime createTime, List<Specialization> specializations) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.professionalStatement = professionalStatement;
		this.practicing_from = practicing_from;
		this.createTime = createTime;
		this.specializations = specializations;
	}


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


	public List<Specialization> getSpecializations() {
		return specializations;
	}


	public void setSpecializations(List<Specialization> specializations) {
		this.specializations = specializations;
	}

	

	
}
