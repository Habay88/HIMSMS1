package com.habay.service;

import java.util.List;
import java.util.Optional;

import com.habay.model.Course;

public interface CourseService {

	Course saveCourse(Course course);

	void deleteCourse(Long courseId);

	List<Course> findAllCourses();

	Optional<Course> findOne(Long id);

	

}
