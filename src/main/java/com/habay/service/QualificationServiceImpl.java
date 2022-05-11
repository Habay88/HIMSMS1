package com.habay.service;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.habay.exception.ResourceNotFoundException;
import com.habay.model.Doctor;
import com.habay.model.Qualifications;
import com.habay.repo.DoctorRepository;
import com.habay.repo.QualificationsRepository;



@Service
public class QualificationServiceImpl implements QualificationService {

	@Autowired
	QualificationsRepository quarepo;
	
	DoctorRepository drepo;
	
	

	public QualificationServiceImpl(QualificationsRepository quarepo, DoctorRepository drepo) {
		this.quarepo = quarepo;
		this.drepo = drepo;
	}
//
//	@Override
//	@Transactional
//	public ResponseEntity<Object> saveDoctorQualification(Qualifications qualifications,Long doctorid) {
//	
//		Qualifications newQualification = new Qualifications();
//		newQualification.setQualificationName(qualifications.getQualificationName());
//		
//		newQualification.setDoctor(qualifications.getDoctor());
//		
//		Qualifications savedQualifications = quarepo.save(newQualification);
//		//if(quarepo.findBydoctorId(doctorid).isPresent()) {
//			return ResponseEntity.accepted().body("Suceesessfully added qualification to doctor");
//		} else
//			return ResponseEntity.unprocessableEntity().body("Failed to create a specialization");
//	}
		
		
		
				
		


	
//	@Override
//	public Qualifications saveDoctorQualification(Qualifications qualifications, Long id) {
//	
//		return quarepo.save(qualifications);
//	}



	@Override
	public ResponseEntity<Object> updateQualification(Qualifications qualifications, Long id) {
		// TODO Auto-generated method stub
		return null;
	}






	

//	@Override
//	public Qualifications saveQualification(Qualifications qualification, Long doctorid) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//@Transactional
//@Override
//public ResponseEntity<Object> updateQualification(Qualifications qualifications,Long id) {
//	
//	
//	if(quarepo.findById(id).isPresent()) {
//		Qualifications newQualifications = quarepo.findById(id).get();
//		newQualifications.setQualificationName(qualifications.getQualificationName());
//		newQualifications.setInstituteName(qualifications.getInstituteName());
//		newQualifications.setProcurement_year(qualifications.getProcurement_year());
//		return ResponseEntity.badRequest().body("Failed to update this Profile ");
//	}
//	Qualifications savedQualification = quarepo.save(newQualifications);
//	if(quarepo.findById(savedQualification.getId()).isPresent())
//		return ResponseEntity.ok("Qualification added successfully");
//	else return ResponseEntity.unprocessableEntity().body("Failed Creating Doctor Qualification as specified");
//}
//}
//	return null;}}
//
//Doctor savedDoctor = drepo.save(newDoctor);
//if(drepo.findById(savedDoctor.getId()).isPresent())
//return ResponseEntity.accepted().body("Doctor Updated Successfully");
//else return ResponseEntity.unprocessableEntity().body("Failed updating the doctor specified");
//
//
//} else return ResponseEntity.unprocessableEntity().body("Cannot find the doctor specified");
}
  
	

