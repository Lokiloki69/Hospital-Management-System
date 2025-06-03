package com.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Patient;
import com.project.entity.Patient;
import com.project.entity.Patient;
import com.project.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	private PatientService service;

	public PatientController(PatientService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<?> savePatient(@RequestBody Patient patient){
		Patient patient2= service.savePatient(patient);
		if(patient2!=null) {
			return new ResponseEntity<>(patient2,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<>("Error in adding patient details",HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping
	public ResponseEntity<?> getAllPatients(){
		List<Patient> patients = service.getAllPatients();
		return new ResponseEntity<>(patients,HttpStatus.FOUND);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findPatientById(@PathVariable int id)
	{
		Patient patient=service.findPatientById(id);
		if(patient.getId()!=0) {
			return new ResponseEntity<>(patient,HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<>("Invalid Patient Id",HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping
	public ResponseEntity<?> editPatient(@RequestBody Patient patient){
		Patient res=service.findPatientById(patient.getId());
		if(res.getId() != 0) {
			Patient updatedPatient =service.savePatient(patient);
			return new ResponseEntity<>(updatedPatient,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Invalid Patient id",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePatientById(@PathVariable int id){
		Patient res=service.findPatientById(id);
		if(res.getId() !=0) {
			service.deletePatientById(id);
			return new ResponseEntity<>("deletion successful",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Invalid Patient id",HttpStatus.BAD_REQUEST);
		}
	}
}
