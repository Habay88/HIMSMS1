package com.habay.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.habay.model.Specialization;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization,Long>{

	

}
