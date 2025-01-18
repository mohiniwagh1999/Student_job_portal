package com.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.job.entity.Student;
import com.job.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("register")
	public ResponseEntity<String> saveUser(@RequestBody Student student)
	{
		String registerStudent = studentService.registerStudent(student);
		return new ResponseEntity<>(registerStudent,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Student s)
	{
		String loginStudent = studentService.loginStudent(s);
		return new ResponseEntity<>(loginStudent,HttpStatus.OK);
	}

}
