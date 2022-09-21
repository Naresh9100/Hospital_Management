package com.hospital.management.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospital.management.entity.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer>{
	public Doctor findByName(String name);

}
