package com.habay.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.habay.model.Doctor;
import com.habay.model.Qualifications;
import com.habay.repo.DoctorRepository;
import com.habay.repo.QualificationsRepository;

@Service
public class QualificationServiceImpl implements QualificationService {
    @Autowired
	private QualificationsRepository qrepo;
	private DoctorRepository drepo;
	public QualificationServiceImpl(QualificationsRepository qrepo, DoctorRepository drepo) {
		
		this.qrepo = qrepo;
		this.drepo = drepo;
	}
	
	@Override
	public ResponseEntity<Object> createQualification(Qualifications model){
		Qualifications  qualifications = new Qualifications();
		if(qrepo.(model.getEmail()).isPresent()){
			return ResponseEntity.badRequest().body("The Email is already taken,Failed to create a new Profile ");
		}else {
			doctor.setFirstName(model.getFirstName());
			doctor.setLastName(model.getLastName());
			doctor.setPracticing_from(model.getPracticing_from());
			doctor.setProfessionalStatement(model.getProfessionalStatement());
			doctor.setEmail(model.getEmail());
			doctor.setSpecializations(model.getSpecializations());
			doctor.setCreateTime(LocalDateTime.now());
			
			Doctor savedDoctor = drepo.save(doctor);
			if(drepo.findById(savedDoctor.getId()).isPresent()) 
			return ResponseEntity.ok("Doctor Created Successfully");
			else return ResponseEntity.unprocessableEntity().body("Failed Creating Doctor as specified");
		}
	} 
	
}
