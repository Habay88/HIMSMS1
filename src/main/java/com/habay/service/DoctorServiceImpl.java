package com.habay.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habay.exception.NotFoundException;

import com.habay.model.Doctor;

import com.habay.repo.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepository drepo;

	
	public DoctorServiceImpl(DoctorRepository drepo) {
		
		this.drepo = drepo;
	}
	@Override
	 public Doctor saveDoctor(Doctor doctor) {
		 doctor.setCreateTime(LocalDateTime.now());
		 return drepo.save(doctor);
	 }
	@Override
	public void deleteDoctor(Long doctorId) {
		drepo.deleteById(doctorId);
	}
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
	@Override
	public Optional<Doctor> findByfirstNameandlastNameandemail(String firstName, String lastName, String email) {
		// TODO Auto-generated method stub
		return drepo.findByfirstNameandlastNameandemail(firstName, lastName, email);
	}
	

}
	
	

