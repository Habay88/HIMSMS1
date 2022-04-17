package com.habay.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.habay.model.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
	
	 List<Doctor> findDoctorBySpecializations(Long SpecializationId);

	@Query(value = "SELECT * FROM doctor d WHERE d.firstName=:firstName AND d.lastName=:lastName", nativeQuery = true)
public Optional<Doctor> findByfirstNameandlastName(String firstName, String lastName);
	
	@Query(value = "SELECT * FROM doctor d WHERE d.firstName=:firstName AND d.lastName=:lastName AND d.email=:email", nativeQuery = true)
	public Optional<Doctor> findByfirstNameandlastNameandemail(String firstName,String lastName,String email);

	
}
