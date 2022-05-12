package com.habay.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.habay.exception.ResourceNotFoundException;
import com.habay.model.Doctor;
import com.habay.model.Specialization;
import com.habay.repo.DoctorRepository;
import com.habay.repo.SpecializationRepository;
import com.habay.service.DoctorService;
import com.habay.service.SpecializationService;


@CrossOrigin(origins = "http://localhost:3333")
@RestController
@RequestMapping("api/specialization")
public class SpecializationController {
	
	@Autowired
	DoctorRepository drepo;
	
	@Autowired
	SpecializationRepository srepo;
	
	@GetMapping("/doctors/{doctorId}/specializations")
	public ResponseEntity<List<Specialization>> getAllSpecializationsByDoctorId(@PathVariable(value = "doctorId")Long doctorId){
		
		if(!drepo.existsById(doctorId)) {
			throw new ResourceNotFoundException("Not found doctor with id ="+ doctorId, null, doctorId);
		}
		List<Specialization> spec = srepo.findBydoctorId(doctorId);
		return new ResponseEntity<>(spec, HttpStatus.OK);
	}
	@GetMapping("/specializations/{id}")
	public ResponseEntity<Specialization> getSpecializationsByDoctorId(@PathVariable(value="id")Long id){
		Specialization specialization = srepo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Not found qualification with id =" + id, null, id));
	return new ResponseEntity<>(specialization, HttpStatus.OK);
	}
	@PostMapping("/doctors/{doctorId}/specializations")
	public ResponseEntity<Specialization> createSpecialization(@PathVariable(value="doctorId")Long doctorId,@RequestBody Specialization specializationRequest){
		Specialization specialization = drepo.findById(doctorId).map(doctor ->{
			specializationRequest.setDoctor(doctor);
			return srepo.save(specializationRequest);
		}).orElseThrow(() -> new ResourceNotFoundException("Not found doctor with id = " + doctorId, null, doctorId));
		return new ResponseEntity<>(specialization,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/specializations/{id}")
	public ResponseEntity<Specialization> updateSpecialization(@PathVariable("id")long id,@RequestBody Specialization specializationRequest){
		Specialization specialization = srepo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Not found doctor with id = " + id, null, id));
	specialization.setSpecializationName(specializationRequest.getSpecializationName());
		return new ResponseEntity<>(srepo.save(specialization), HttpStatus.OK);
	}
	
	@DeleteMapping("/specializations/{id}")
	public ResponseEntity<HttpStatus> deleteQualification(@PathVariable("id") long id){
	srepo.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	@DeleteMapping("/doctors/{doctorId}/specializations")
	public ResponseEntity<List<Specialization>> deleteAllQualificationsOfDoctor(@PathVariable(value="doctorId")Long doctorId){
	
		if(!drepo.existsById(doctorId)) {
			throw new ResourceNotFoundException("Not found Tutorial with id = " + doctorId, null, doctorId);
		}
		srepo.deleteByDoctorId(doctorId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
}
