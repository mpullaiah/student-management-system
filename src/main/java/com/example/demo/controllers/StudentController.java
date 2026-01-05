package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Student;
import com.example.demo.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	@GetMapping
	public List<Student> getStudents(){
		return service.getAllStudents();
	}
	@GetMapping("/{id}")
			public Student updateEmployee(@PathVariable Long id) {
		return service.getstudentById(id);
	}
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return service.updateStudent(id, student);
		
	}
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
	    service.deleteStudent(id);
	    return "Student deleted successfully";
	}

}
