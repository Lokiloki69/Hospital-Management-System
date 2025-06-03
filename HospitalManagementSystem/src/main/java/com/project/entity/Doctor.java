package com.project.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String specialization;
	private String gender;
	private double salary;
	private int age;
	private int exp;
	@OneToMany(mappedBy = "doctor",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Patient> patients;

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(int id, String name, String specialization, String gender, double salary, int age, int exp,
			List<Patient> patients) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.gender = gender;
		this.salary = salary;
		this.age = age;
		this.exp = exp;
		this.patients = patients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialization=" + specialization + ", gender=" + gender
				+ ", salary=" + salary + ", age=" + age + ", exp=" + exp + "]";
	}
	
}
