package com.habay.repository;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import com.habay.model.Doctor;
import com.habay.model.Specialization;
import com.habay.repo.DoctorRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class DoctorRepositoryTests {

	@Autowired
	private DoctorRepository drepo;
	@Autowired
	private TestEntityManager entityManager;
	
//	@Test
//	public void testCreateNewDoctorWithOneRole() {
//		Specialization roleDoctor = entityManager.find(Specialization.class, 1);
//		Doctor userHabay = new Doctor((long) 1,"banjoko", "abiodun", "biodun.banjoko@yahoo.com", "i am not afraid to take a step", null, null);
//		userHabay
//		
//		Doctor savedUser = drepo.save(userHabay);
//		
//		assertThat(savedUser.getId()).isGreaterThan(0);
//	}
}
