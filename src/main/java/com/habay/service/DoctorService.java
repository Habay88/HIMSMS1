package com.habay.service;

import java.util.List;
import java.util.Optional;

import com.habay.model.Doctor;
import com.habay.model.Specialization;

public interface DoctorService {

	Doctor saveDoctor(Doctor doctor);

	void deleteDoctor(Long doctorId);
	public Optional <Doctor> editDoctorInfo(Long id);

	List<Doctor> findAllDoctors();

public Optional<Doctor> findOne(Long id);
	
public 	Optional<Doctor> findByfirstNameandlastName(String firstName,String lastName);

public Optional<Doctor> findByfirstNameandlastNameandemail(String firstName,String lastName, String email);

	

}
