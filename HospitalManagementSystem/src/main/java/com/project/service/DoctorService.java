package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Doctor;
import com.project.repo.DoctorRepo;

@Service
public class DoctorService {

	
	private DoctorRepo repo;

	public DoctorService(DoctorRepo repo) {
		super();
		this.repo = repo;
	}

	public Doctor saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return repo.save(doctor);
	}

	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Doctor findDoctorById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(new Doctor());
	}

	public void deleteDoctorById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	
	
}
