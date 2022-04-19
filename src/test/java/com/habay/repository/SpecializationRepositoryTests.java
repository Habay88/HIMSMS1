package com.habay.repository;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.habay.model.Specialization;
import com.habay.repo.SpecializationRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SpecializationRepositoryTests {

	
	@Autowired
	private SpecializationRepository sprepo;
	
	@Test
	public void testCreateFirstSpec() {
		Specialization specialization = new Specialization((long) 1, "Optician");
        Specialization savedSpec= sprepo.save(specialization);  
        assertThat(savedSpec.getId()).isGreaterThan(0);
	}
	@Test
	public void testCreateRestSpecss() {
		Specialization roleDentist = new Specialization((long) 1, "Dentist");
		
		Specialization roleGynaecology = new Specialization((long) 2, "Gynaecologist");
		
		Specialization roleNurse = new Specialization((long) 3, "Nurse");
		Specialization roleDoctor = new Specialization((long) 4, "Doctor");
		Specialization rolePharmacy = new Specialization((long) 5, "Pharmacist");
		Specialization roleOncologist = new Specialization((long) 6, "Oncologist");
		
		sprepo.saveAll(List.of(roleDentist, roleGynaecology, roleNurse, roleDoctor,rolePharmacy,roleOncologist));
	}
}
