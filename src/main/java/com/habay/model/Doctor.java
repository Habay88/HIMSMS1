package com.habay.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="title", length=100, nullable=false)
	private String title;
	
	@Column(name="subtitle", length=100, nullable=false)
	private String subTitle;
	
	@Column(name="price", length=100, nullable=false)
	private Double price;
	
	@Column(name="create_time")
	private LocalDateTime createTime;

	public Course() {
	}

	public Course(Long id, String title, String subTitle, Double price, LocalDateTime createTime) {
		
		this.title = title;
		this.subTitle = subTitle;
		this.price = price;
		this.createTime = createTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	
	
}
