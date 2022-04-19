package com.habay.service;

import org.springframework.http.ResponseEntity;

import com.habay.model.Qualifications;

public interface QualificationService {

	ResponseEntity<Object> createQualification(Qualifications model);

}
