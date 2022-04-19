package com.habay.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habay.model.Qualifications;

public interface QualificationsRepository extends JpaRepository<Qualifications, Long> {

 public	Optional findByDoctorId(Long doctorid);
}
