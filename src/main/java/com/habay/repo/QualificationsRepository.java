package com.habay.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.habay.model.Qualifications;
@Repository
public interface QualificationsRepository extends JpaRepository<Qualifications, Long> {
//
//	@Query(value = "SELECT * FROM qualifications q WHERE d.doctorId=:doctorId ", nativeQuery = true)
 Optional<Qualifications> findBydoctorId(Long doctorId);
}
