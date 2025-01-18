package com.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.entity.Student;
import com.job.repo.StudentRepo;
import com.job.utils.EmailUtils;

@Service
public class StudentService {
	@Autowired
	private StudentRepo repo;
	@Autowired
	private EmailUtils utils;
	
	public String registerStudent(Student student)
	{
		Student save = repo.save(student);
		if(save.getId()!=null)
		{
		String subject="your account is created";
		String body="welcome to onboard";
		
		utils.sendEmail(save.getEmail(), subject, body);
		
		}
		return "mail send to your email check once";
		
		
	}

	public String loginStudent(Student student)
	{
		Student byEmailAndPwd = repo.findByEmailAndPwd(student.getEmail(), student.getPwd());
		
		return "welcome :" +byEmailAndPwd.getName();
	}
	
	//update password 
	//avoid duplicate email entry
	
	
}
