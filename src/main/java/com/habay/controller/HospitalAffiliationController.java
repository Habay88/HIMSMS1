package com.habay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habay.exception.ResourceNotFoundException;
import com.habay.model.HospitalAffiliation;
import com.habay.repo.DoctorRepository;
import com.habay.repo.HospitalAffiliationRepository;

@CrossOrigin(origins = "http://localhost:3333")
@RestController
@RequestMapping("/api")
public class HospitalAffiliationController {

	@Autowired
	DoctorRepository drepo;
	@Autowired
	HospitalAffiliationRepository hrepo;
	
	@GetMapping("/doctors/{doctorId}/hospitalaffiliations")
	public ResponseEntity<List<HospitalAffiliation>> getAllHospitalAffiliationsByDoctorId(@PathVariable(value = "doctorId")Long doctorId){
		
		if(!drepo.existsById(doctorId)) {
			throw new ResourceNotFoundException("Not found doctor with id ="+ doctorId, null, doctorId);
		}
		List<HospitalAffiliation> qual = hrepo.findBydoctorId(doctorId);
		return new ResponseEntity<>(qual, HttpStatus.OK);
	}
	
}
