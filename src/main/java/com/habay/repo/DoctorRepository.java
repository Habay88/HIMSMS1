package com.habay.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.habay.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

	
}
