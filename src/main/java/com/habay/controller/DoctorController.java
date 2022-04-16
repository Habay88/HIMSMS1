package com.habay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habay.model.Course;
import com.habay.service.CourseService;

@RestController
@RequestMapping("api/course")
public class CourseController {
	
	@Autowired
	CourseService cservice;

	@PostMapping
	public ResponseEntity<?> saveCourse(@RequestBody Course course)
	{
		return new ResponseEntity<>(cservice.saveCourse(course),HttpStatus.CREATED);
	}
	
	@DeleteMapping("{courseId}")
	public ResponseEntity<?> deleteCourse(@PathVariable Long courseId){
		cservice.deleteCourse(courseId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping 
	public ResponseEntity<?> getAllCourses()
	{
		return ResponseEntity.ok(cservice.findAllCourses());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<?> getOne(@PathVariable Long id)
	{
		return ResponseEntity.ok(cservice.findOne(id));
	}
	
}
