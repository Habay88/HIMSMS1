package com.habay.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.habay.model.Doctor;
import com.habay.model.Specialization;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization,Long>{

	List<Specialization> findBydoctorId(Long doctorId);

	void deleteByDoctorId(Long doctorId);
	

}
