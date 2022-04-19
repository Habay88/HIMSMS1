package com.habay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habay.exception.ResourceNotFoundException;
import com.habay.model.Doctor;
import com.habay.repo.DoctorRepository;
import com.habay.service.DoctorService;
@CrossOrigin(origins = "http://localhost:3333")
@RestController
@RequestMapping("api/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService dservice;
	
	private DoctorRepository drepo;


	@PostMapping
	public ResponseEntity<?> createDoctor(@RequestBody Doctor doctor)
	{
		return dservice.createDoctor(doctor);
		}
	
	
	
	@DeleteMapping("/{doctorId}")
	public ResponseEntity<?> deleteDoctor(@PathVariable Long doctorId){
		return dservice.deleteDoctor(doctorId);
	}
	
	@GetMapping 
	public List<Doctor> getAllDoctors()
	{
		return dservice.findAllDoctors();
	}
	
	@PutMapping("/{id}")

	public ResponseEntity<Object> updateUser(@PathVariable Long id,@RequestBody Doctor doctor){
		return dservice.updateDoctor(doctor, id);
	}

	
	@GetMapping("/{id}") 
	public ResponseEntity<Doctor> getDoctorbyId(@PathVariable("id") Long id)
	{
	Doctor doctor = dservice.findOne(id)
	.orElseThrow(() -> new ResourceNotFoundException ("Not Found Doctor with id=" + id));			
	return new ResponseEntity<>(doctor, HttpStatus.OK);
	}
}
