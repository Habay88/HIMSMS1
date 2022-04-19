package com.habay.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.habay.model.Doctor;
import com.habay.model.Specialization;

public interface DoctorService {



	List<Doctor> findAllDoctors();
	

public Optional<Doctor> findOne(Long id);
	
public 	Optional<Doctor> findByfirstNameandlastName(String firstName,String lastName);

public Optional<Doctor> findByfirstNameandlastNameandemail(String firstName,String lastName, String email, List<Specialization> list);

ResponseEntity<Object> createDoctor(Doctor model);



/** Update an Existing doctor */
ResponseEntity<Object> updateDoctor(Doctor doctor, Long id);


/** Delete an existing Doctor*/
ResponseEntity<Object> deleteDoctor(Long id);





}
