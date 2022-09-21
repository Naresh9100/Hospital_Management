package com.hospital.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.hospital.management.entity.Doctor;
import com.hospital.management.service.HospitalService;



@RestController
@CrossOrigin(origins="")
public class DoctorController {
	
	@Autowired
	HospitalService service;
	
	@PostMapping("/doctors/doctor")
	public boolean addUser(@RequestBody Doctor doctor) {
		service.saveDoctorInformation(doctor);
		return true;
	}
	
	@GetMapping("doctors/doctor/{name}")
	public MappingJacksonValue getDoctorInformation(@PathVariable String name) {
		Doctor doctor=service.showdoctorInformation(name);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("name","specilization","patient_count");
		
		FilterProvider filters=new SimpleFilterProvider().addFilter("DoctorFilter",filter);
		
		MappingJacksonValue mapping=new MappingJacksonValue(doctor);
		
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("doctors/doc/{name}")
	public Doctor getdoctorInfo(@PathVariable String name) {
		Doctor doctor =service.showdoctorInformation( name);;
		return doctor;
	}
	
	@GetMapping("doctors")
	public MappingJacksonValue getListofDoctor() {
		List<Doctor> doctors =service.getDoctor();
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("Id","name");
		
		FilterProvider filters= new SimpleFilterProvider().addFilter("DoctorFilter", filter);
		
		MappingJacksonValue mapping= new MappingJacksonValue(doctors);
		mapping.setFilters(filters);
		return mapping;
		
	}

}
