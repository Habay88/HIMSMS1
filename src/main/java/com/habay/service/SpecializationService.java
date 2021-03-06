package com.habay.service;

import java.util.List;
import java.util.Optional;

import com.habay.model.Doctor;
import com.habay.model.Specialization;

public interface SpecializationService {
	
	Specialization saveSpecialization(Specialization specialization);
	
	public Optional <Specialization> editSpecialization(Long id);

	void deleteSpecialization(Long id);

	List<Specialization> findAllSpecializations();

public Optional<Specialization> findOne(Long specid);

Iterable<Specialization> findByTitleContaining(String title);

}
