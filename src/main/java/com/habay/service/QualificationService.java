package com.habay.service;

import org.springframework.http.ResponseEntity;

import com.habay.model.Doctor;
import com.habay.model.Qualifications;


public interface QualificationService {



	ResponseEntity<Object> updateQualification(Qualifications qualifications, Long id);

	

	ResponseEntity<Object> saveDoctorQualification(Qualifications qualifications, Long doctorid);

}
