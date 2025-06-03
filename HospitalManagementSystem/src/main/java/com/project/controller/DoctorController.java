package com.project.controller;

import java.util.List;
import com.project.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.project.entity.Doctor;
import com.project.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final PatientService patientService;
	
	private DoctorService service;

	
	//only in boot we can add dependency by constructor also instead of @autowired
	public DoctorController(DoctorService service, PatientService patientService) {
		super();
		this.service = service;
		this.patientService = patientService;
	}
	

	@PostMapping
	public ResponseEntity<?> saveDoctor(@RequestBody Doctor doctor){
		Doctor doctor2 = service.saveDoctor(doctor);
		if(doctor2!=null) {
			return new ResponseEntity<>(doctor2,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<>("Error in adding doctor details",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getAllDoctors(){
		List<Doctor> doctors= service.getAllDoctors();
		return new ResponseEntity<>(doctors,HttpStatus.FOUND);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findDoctorById(@PathVariable int id)
	{
		Doctor doctor=service.findDoctorById(id);
		if(doctor.getId()!=0) {
			return new ResponseEntity<>(doctor,HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<>("Invalid doctor Id",HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping
	public ResponseEntity<?> editDoctor(@RequestBody Doctor doctor){
		Doctor res=service.findDoctorById(doctor.getId());
		if(res.getId() != 0) {
			Doctor updatedDoctor =service.saveDoctor(doctor);
			return new ResponseEntity<>(updatedDoctor,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Invalid Doctor id",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDoctorById(@PathVariable int id){
		Doctor res=service.findDoctorById(id);
		if(res.getId() !=0) {
			service.deleteDoctorById(id);
			return new ResponseEntity<>("deletion successful",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Invalid doctor id",HttpStatus.BAD_REQUEST);
		}
	}
}
