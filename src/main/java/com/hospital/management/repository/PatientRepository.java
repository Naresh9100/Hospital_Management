package com.hospital.management.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospital.management.entity.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer>{

}
