package com.habay.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.habay.model.Doctor;
import com.habay.model.Specialization;
import com.habay.repo.DoctorRepository;
import com.habay.repo.SpecializationRepository;

@Service
public class DoctorServiceImpl implements DoctorService{

	
	private DoctorRepository drepo;
	
	
	private SpecializationRepository sprepo;

	
	public DoctorServiceImpl(DoctorRepository drepo, SpecializationRepository sprepo) {
		
		this.drepo = drepo;
		this.sprepo = sprepo;
	}
	
//	if(dservice.findByfirstNameandlastNameandemail(doctor.getFirstName(),doctor.getLastName(),doctor.getEmail(),doctor.getSpecializations()).isPresent()){
//		return new ResponseEntity<>(HttpStatus.CONFLICT);	
//		}
//		return new ResponseEntity<>(dservice.createDoctor(doctor),HttpStatus.CREATED);
//		}
	@Override
	public ResponseEntity<Object> createDoctor(Doctor model){
		Doctor doctor = new Doctor();
		if(drepo.findByemail(model.getEmail()).isPresent()){
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
	   /** Update an Existing doctor */
	@Transactional
	@Override
	public ResponseEntity<Object> updateDoctor(Doctor doctor, Long id){
	if(drepo.findById(id).isPresent())	{
		Doctor newDoctor = drepo.findById(id).get();
		newDoctor.setFirstName(doctor.getFirstName());
		newDoctor.setLastName(doctor.getLastName());
		newDoctor.setEmail(doctor.getEmail());
		newDoctor.setPracticing_from(doctor.getPracticing_from());
		newDoctor.setProfessionalStatement(doctor.getProfessionalStatement());;
		newDoctor.setSpecializations(doctor.getSpecializations());
		Doctor savedDoctor = drepo.save(newDoctor);
		if(drepo.findById(savedDoctor.getId()).isPresent())
		return ResponseEntity.accepted().body("Doctor Updated Successfully");
		else return ResponseEntity.unprocessableEntity().body("Failed updating the doctor specified");
		
		
} else return ResponseEntity.unprocessableEntity().body("Cannot find the doctor specified");
	}

	/** Delete an existing Doctor*/
	@Override
	public ResponseEntity<Object> deleteDoctor(Long id){
	if(drepo.findById(id).isPresent()) {
		drepo.deleteById(id);
		if(drepo.findById(id).isPresent()) 
			return ResponseEntity.unprocessableEntity().body("Failed to delete the specified doctor");
			else return ResponseEntity.ok().body("Successfully deleted the specified doctor");
		} else return ResponseEntity.badRequest().body("Cannot find the user specified");
	}

	
	
	
//	@Override
//	 public Doctor saveDoctor(Doctor doctor) {
//		 doctor.setCreateTime(LocalDateTime.now());
//		 return drepo.save(doctor);
//	 }
//	@Override
//	public void deleteDoctor(Long doctorId) {
//		drepo.deleteById(doctorId);
//	}
	@Override
public List<Doctor> findAllDoctors(){
	return (List<Doctor>) drepo.findAll();
}	
	
	@Override
	public Optional<Doctor> findOne(Long id){
		return  drepo.findById(id);
	}
	@Override
	public Optional<Doctor> findByfirstNameandlastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return drepo.findByfirstNameandlastName(firstName,lastName);
	}
//	@Override
//	public Optional<Doctor> findByfirstNameandlastNameandemail(String firstName, String lastName, String email,List<Specialization> list) {
//		// TODO Auto-generated method stub
//		return drepo.findByfirstNameandlastNameandemail(firstName, lastName, email);
//	}
	
//	@Override
//	public Optional<Doctor> editDoctorInfo(Long id) {
//		// TODO Auto-generated method stub
//		return drepo.findById(id);
//	}
//	@Override
//	public List<Doctor> findDoctorBySpecializations(String firstName, String lastName, Long SpecializationId) {
//		// TODO Auto-generated method stub
//		return drepo.findDoctorBySpecializations(firstName, lastName, SpecializationId);
//	}
//	@Override
//	public Optional<Doctor> findByfirstNameandlastNameandemaileee(String firstName, String lastName, String email,
//			Set<Specialization> set) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public Doctor saveDoctor(Doctor doctor) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public Optional<Doctor> findByfirstNameandlastNameandemail(String firstName, String lastName, String email,
			List<Specialization> list) {
		// TODO Auto-generated method stub
		return null;
	}
}
	
	


	
	

