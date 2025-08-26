package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Doctor;
import com.project.repo.DoctorRepo;

//this is Doctor service file with multiple services: save, getALl, findBy, deleteBy

@Service
public class DoctorService {

	
	private DoctorRepo repo;

	public DoctorService(DoctorRepo repo) {
		super();
		this.repo = repo;
	}

	public Doctor saveDoctor(Doctor doctor) {

		return repo.save(doctor);
	}

	public List<Doctor> getAllDoctors() {

		return repo.findAll();
	}

	public Doctor findDoctorById(int id) {

		return repo.findById(id).orElse(new Doctor());
	}

	public void deleteDoctorById(int id) {

		repo.deleteById(id);
	}
	
	
}
