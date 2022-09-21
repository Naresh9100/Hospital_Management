package com.hospital.management.entity;

import  java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Doctor {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Integer age;
	private String gender;
	private String Specilization;
	private Integer Patient_count=0;
	
	@OneToMany
	private List<Patient> patients;
	
	public List<Patient> getPatients(){
	return patients;
	}
	
	public void addPatients(Patient patient) {
		patients.add(patient);
	}
	
	public Doctor() {
		
	}

	public Doctor(String name, Integer age, String gender, String specilization) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		Specilization = specilization;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", Specilization="
				+ Specilization + "]";
	}

	public Integer getPatient_count() {
		return Patient_count;
	}

	public void setPatient_count() {
		this.Patient_count += 1;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecilization() {
		return Specilization;
	}

	public void setSpecilization(String specilization) {
		Specilization = specilization;
	}
	
	
	

}
