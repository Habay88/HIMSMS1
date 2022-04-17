package com.habay.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.habay.model.Specialization;
import com.habay.service.SpecializationService;

@RestController
@RequestMapping("api/specialization")
public class SpecializationController {
	@Autowired
	SpecializationService spservice;
	
	@PostMapping
	public ResponseEntity<Specialization> createSpecialization(@RequestBody Specialization specialization) {
	  try {
		  Specialization _specialization = spservice.saveSpecialization(specialization);

	    return new ResponseEntity<>(_specialization, HttpStatus.CREATED);
	  } catch (Exception e) {
	    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Specialization>> getAllSpecializations(@RequestParam(required = false) String title) {
		  try {
		    List<Specialization> specs = new ArrayList<Specialization>();
		    if (title == null)
		      spservice.findAllSpecializations().forEach(specs::add);
		    else
		      spservice.findByTitleContaining(title).forEach(specs::add);
		    if (specs.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		    return new ResponseEntity<>(specs, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
		}
	@GetMapping("/{id}")
		public ResponseEntity<Specialization> getSpecializationById(@PathVariable Long id){
		Optional<Specialization> specData = spservice.findOne(id);
		if(specData.isPresent()) {
			return new ResponseEntity<>(specData.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}
	@PutMapping("/{id}")
	public ResponseEntity<Specialization> updateSpecialization(@PathVariable Long id, @RequestBody Specialization spec){
	Optional<Specialization> specData = spservice.editSpecialization(id);
	if(specData.isPresent()) {
		Specialization _spec = specData.get();
		_spec.setSpecializationName(spec.getSpecializationName());
		return new ResponseEntity<>(spservice.saveSpecialization(_spec),HttpStatus.OK);
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	@DeleteMapping("/{id}")
	    public void deleteSpecialization(@PathVariable Long id) {
	        spservice.deleteSpecialization(id);
	    }

}
