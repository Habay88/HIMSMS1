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
	
	@GetMapping("/hospitalaffiliations/{id}")
	public ResponseEntity<HospitalAffiliation> getHospitalffiliationsByDoctorId(@PathVariable(value="id")Long id){
		HospitalAffiliation hospitalaffiliation = hrepo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Not found qualification with id =" + id, null, id));
	return new ResponseEntity<>(hospitalaffiliation, HttpStatus.OK);
	}
	@PostMapping("/doctors/{doctorId}/hospitalaffiliations")
	public ResponseEntity<HospitalAffiliation> createAffiliation(@PathVariable(value="doctorId")Long doctorId,@RequestBody HospitalAffiliation affiliationRequest){
		HospitalAffiliation hospitalAffiliation = drepo.findById(doctorId).map(doctor ->{
			affiliationRequest.setDoctor(doctor);
			return hrepo.save(affiliationRequest);
		}).orElseThrow(() -> new ResourceNotFoundException("Not found doctor with id = " + doctorId, null, doctorId));
		return new ResponseEntity<>(hospitalAffiliation,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/hospitalaffiliations/{id}")
	public ResponseEntity<HospitalAffiliation> updateAffiliation(@PathVariable("id")long id,@RequestBody HospitalAffiliation affiliationRequest){
		HospitalAffiliation hospitalAffiliation = hrepo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Not found doctor with id = " + id, null, id));
		hospitalAffiliation.setHospitalName(affiliationRequest.getHospitalName());
		hospitalAffiliation.setCity(affiliationRequest.getCity());
		hospitalAffiliation.setCountry(affiliationRequest.getCountry());
		hospitalAffiliation.setStartDate(affiliationRequest.getStartDate());
		hospitalAffiliation.setEndDate(affiliationRequest.getEndDate());
		return new ResponseEntity<>(hrepo.save(hospitalAffiliation), HttpStatus.OK);
	}
	@DeleteMapping("/hospitalaffiliations/{id}")
	public ResponseEntity<HttpStatus> deleteAffiliation(@PathVariable("id") long id){
	hrepo.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	@DeleteMapping("/doctors/{doctorId}/hospitalaffiliations")
	public ResponseEntity<List<HospitalAffiliation>> deleteAllAffiliationsOfDoctor(@PathVariable(value="doctorId")Long doctorId){
	
		if(!drepo.existsById(doctorId)) {
			throw new ResourceNotFoundException("Not found Tutorial with id = " + doctorId, null, doctorId);
		}
		hrepo.deleteByDoctorId(doctorId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

	
}
