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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.habay.exception.ResourceNotFoundException;
import com.habay.model.Doctor;
import com.habay.model.Qualifications;
import com.habay.repo.DoctorRepository;
import com.habay.repo.QualificationsRepository;
import com.habay.service.QualificationService;



@CrossOrigin(origins = "http://localhost:3333")
@RestController
@RequestMapping("/api")
public class QualificationsController {
	
	@Autowired
	DoctorRepository drepo;
	
	@Autowired
	QualificationsRepository qrepo;
	
	@GetMapping("/doctors/{doctorId}/qualifications")
	public ResponseEntity<List<Qualifications>> getAllQualificationsByDoctorId(@PathVariable(value = "doctorId")Long doctorId){
		
		if(!drepo.existsById(doctorId)) {
			throw new ResourceNotFoundException("Not found doctor with id ="+ doctorId, null, doctorId);
		}
		List<Qualifications> qual = qrepo.findBydoctorId(doctorId);
		return new ResponseEntity<>(qual, HttpStatus.OK);
	}
	
	@GetMapping("/qualifications/{id}")
	public ResponseEntity<Qualifications> getQualificationsByDoctorId(@PathVariable(value="id")Long id){
		Qualifications qualification = qrepo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Not found qualification with id =" + id, null, id));
	return new ResponseEntity<>(qualification, HttpStatus.OK);
	}
	
	@PostMapping("/doctors/{doctorId}/qualifications")
	public ResponseEntity<Qualifications> createQualification(@PathVariable(value="doctorId")Long doctorId,@RequestBody Qualifications qualificationRequest){
		Qualifications qualification = drepo.findById(doctorId).map(doctor ->{
			qualificationRequest.setDoctor(doctor);
			return qrepo.save(qualificationRequest);
		}).orElseThrow(() -> new ResourceNotFoundException("Not found doctor with id = " + doctorId, null, doctorId));
		return new ResponseEntity<>(qualification,HttpStatus.CREATED);
		
	}
	@PutMapping("/qualifications/{id}")
	public ResponseEntity<Qualifications> updateQualification(@PathVariable("id")long id,@RequestBody Qualifications qualificationRequest){
		Qualifications qualification = qrepo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Not found doctor with id = " + id, null, id));
	qualification.setQualificationName(qualificationRequest.getQualificationName());
	qualification.setInstituteName(qualificationRequest.getInstituteName());
	qualification.setProcurement_year(qualificationRequest.getProcurement_year());
		return new ResponseEntity<>(qrepo.save(qualification), HttpStatus.OK);
	}
	@DeleteMapping("/qualifications/{id}")
	public ResponseEntity<HttpStatus> deleteQualification(@PathVariable("id") long id){
	qrepo.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	@DeleteMapping("/doctors/{doctorId}/qualifications")
	public ResponseEntity<List<Qualifications>> deleteAllQualificationsOfDoctor(@PathVariable(value="doctorId")Long doctorId){
	
		if(!drepo.existsById(doctorId)) {
			throw new ResourceNotFoundException("Not found Tutorial with id = " + doctorId, null, doctorId);
		}
		qrepo.deleteByDoctorId(doctorId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
}
