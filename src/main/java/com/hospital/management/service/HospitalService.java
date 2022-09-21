package com.hospital.management.service;

import java.util.List;

import com.hospital.management.entity.Doctor;
import com.hospital.management.entity.Patient;



public interface HospitalService {

	public Doctor showdoctorInformation(String name);
	public Patient showPatientInformation(Integer Id);
	
	public boolean saveDoctorInformation(Doctor doctor);
	public boolean savePatientInformation(Patient patient);
	
	public List<Patient> getPatientListofDoctors(String name,Doctor doctor);
	public List<Doctor> getDoctor();
}
