package com.habay.service;

import java.util.List;
import java.util.Optional;

import com.habay.model.Doctor;

public interface DoctorService {

	Doctor saveDoctor(Doctor doctor);

	void deleteDoctor(Long doctorId);

	List<Doctor> findAllDoctors();

public Optional<Doctor> findOne(Long id);
	
public 	Optional<Doctor> findByfirstNameandlastName(String firstName,String lastName);

public Optional<Doctor> findByfirstNameandlastNameandemail(String firstName,String lastName, String email);

	

}
