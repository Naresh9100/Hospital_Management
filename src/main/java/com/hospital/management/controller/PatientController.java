package com.hospital.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.entity.Patient;
import com.hospital.management.exception.PatientNotFoundException;
import com.hospital.management.service.HospitalService;

@RestController

public class PatientController {
	
	@Autowired
	HospitalService service;
	
	@GetMapping("/Patients/Patient/{id}")
	public Patient showPatientInformation(@PathVariable Integer id) {
		Patient patient=service.showPatientInformation(id);
		if(patient== null) {
			throw new PatientNotFoundException(id+"is not in database");
		}
		return patient;
	}

	@PostMapping("patients/patient")
	public boolean createPatient(@RequestBody Patient patient) {
		service.savePatientInformation(patient);
		return true;
	}
}
