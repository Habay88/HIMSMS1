package com.habay.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habay.model.HospitalAffiliation;

public interface HospitalAffiliationRepository extends JpaRepository<HospitalAffiliation, Long> {

	 List<HospitalAffiliation> findBydoctorId(Long doctorId);
	 
	 void deleteByDoctorId(Long doctorId);
}
