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

import com.habay.model.Doctor;

import com.habay.service.DoctorService;

@RestController
@RequestMapping("api/doctor")
public class DoctorController {
	
	@Autowired
	DoctorService dservice;


	@PostMapping
	public ResponseEntity<?> saveDoctor(@RequestBody Doctor doctor)
	{
		if(dservice.findByfirstNameandlastNameandemail(doctor.getFirstName(),doctor.getLastName(),doctor.getEmail()).isPresent()){
		return new ResponseEntity<>(HttpStatus.CONFLICT);	
		}
		return new ResponseEntity<>(dservice.saveDoctor(doctor),HttpStatus.CREATED);
		}
	//	return new ResponseEntity<>(dservice.saveDoctor(doctor),HttpStatus.CREATED);
	//}
	
	@DeleteMapping("{doctorId}")
	public ResponseEntity<?> deleteDoctor(@PathVariable Long doctorId){
		dservice.deleteDoctor(doctorId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping 
	public ResponseEntity<?> getAllDoctors()
	{
		return ResponseEntity.ok(dservice.findAllDoctors());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<?> getOne(@PathVariable Long id)
	{
		return ResponseEntity.ok(dservice.findOne(id));
	}
	
}
