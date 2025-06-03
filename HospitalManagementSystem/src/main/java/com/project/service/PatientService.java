package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Patient;
import com.project.repo.PatientRepo;

@Service
public class PatientService {

	private PatientRepo repo;

	public PatientService(PatientRepo repo) {
		super();
		this.repo = repo;
	}

	public Patient savePatient(Patient patient) {
		return repo.save(patient);
	}

	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Patient findPatientById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(new Patient());
	}

	public void deletePatientById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}
	
}
