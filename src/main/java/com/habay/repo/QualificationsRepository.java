package com.habay.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.habay.model.Doctor;
import com.habay.model.Qualifications;
@Repository
public interface QualificationsRepository extends JpaRepository<Qualifications, Long> {
//
//	@Query(value = "SELECT * FROM qualifications q WHERE d.doctorId=:doctorId ", nativeQuery = true)
 List<Qualifications> findBydoctorId(Long doctorId);
//
//Qualifications saveAll(Qualifications qualification, Doctor doctorid);
//
//Qualifications save(Qualifications qualification, Doctor doctorid);

//List<Qualifications> saveDoctor(Qualifications qualification, Doctor doctorid);

//Qualifications save(Qualifications qualification, Doctor doctorid);
}
