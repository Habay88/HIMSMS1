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
	QualificationsRepository qrepo;
	
	public QualificationServiceImpl(QualificationsRepository qrepo) {
		
		this.qrepo = qrepo;
	}

	@Override
	public ResponseEntity<Object> createQualification(Qualifications model) {
		// TODO Auto-generated method stub
		Qualifications qualifications = new Qualifications();
		if(qrepo.)
		return null;
	}
  
	
}
