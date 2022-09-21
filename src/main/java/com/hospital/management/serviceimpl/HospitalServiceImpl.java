package com.hospital.management.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.management.entity.Doctor;
import com.hospital.management.entity.Patient;
import com.hospital.management.repository.DoctorRepository;
import com.hospital.management.repository.PatientRepository;
import com.hospital.management.service.HospitalService;

@Repository
@Transactional
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientrepository;
	
	@Override
	public Doctor showDoctorInformation(String name) {
		return doctorRepository.findByName(name);
		
	}
	
	@Override
	public Patient showPatientInformation(Integer id) {
		return patientRepository.findById(id).get();
	}
	
	@Override
	public boolean saveDoctorInformation(Doctor doctor) {
		doctorRepository.save(doctor);
		return true;
	}
	
	@Override
	public boolean savepatientInformation(Patient patient) {
		
		Doctor doctor =doctorRepository.findByName(patient.getDoctor_name());
		doctor.addPatients(patient);
		PatientRepository.save(patient);
		doctor.setPatient_count();
		return true;
	}
	
	@Override
	public List<Patient> getPatientListOfDoctors(String name,Doctor doctor){
		return doctor.getPatients();
	}
	
	@Override
	public List<Doctor> getDoctors(){
		return (List<Doctors>) doctorsRepository.findAll();
	}
}
		
	
