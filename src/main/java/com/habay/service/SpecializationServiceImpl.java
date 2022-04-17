package com.habay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habay.model.Specialization;
import com.habay.repo.DoctorRepository;
import com.habay.repo.SpecializationRepository;

@Service
public class SpecializationServiceImpl implements SpecializationService{

	@Autowired
	private SpecializationRepository srepo;
	
	public SpecializationServiceImpl(SpecializationRepository srepo) {
		
		this.srepo = srepo;
	}

	@Override
	public Specialization saveSpecialization(Specialization specialization) {
		// TODO Auto-generated method stub
		return srepo.save(specialization);
	}

	@Override
	public List<Specialization> findAllSpecializations() {

		return (List<Specialization>) srepo.findAll();
	}

	@Override
	public Iterable<Specialization> findByTitleContaining(String title) {
		// TODO Auto-generated method stub
		return (Iterable<Specialization>) srepo.findAll();
	}
	

	@Override
	public void deleteSpecialization(Long specializationId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Specialization> editSpecialization(Long id) {
		// TODO Auto-generated method stub
		return srepo.findById(id);
	}

	

	@Override
	public Optional<Specialization> findOne(Long id) {
		// TODO Auto-generated method stub
		return srepo.findById(id);
	}


	

	
}
