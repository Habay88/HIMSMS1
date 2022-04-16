package com.habay.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habay.exception.NotFoundException;
import com.habay.model.Course;
import com.habay.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository crepo;

	public CourseServiceImpl(CourseRepository crepo) {
		
		this.crepo = crepo;
	}
	@Override
	 public Course saveCourse(Course course) {
		 course.setCreateTime(LocalDateTime.now());
		 return crepo.save(course);
	 }
	@Override
	public void deleteCourse(Long courseId) {
		crepo.deleteById(courseId);
	}
	@Override
public List<Course> findAllCourses(){
	return (List<Course>) crepo.findAll();
}	
	
	@Override
	public Optional<Course> findOne(Long id){
		return  crepo.findById(id);
	}

}
	
	

