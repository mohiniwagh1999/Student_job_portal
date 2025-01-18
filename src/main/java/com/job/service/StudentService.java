package com.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.entity.Student;
import com.job.repo.StudentRepo;
import com.job.utils.EmailUtils;

@Service
public class StudentService {
	@Autowired
	private StudentRepo srepo;
	@Autowired
	private EmailUtils Email;
	
	public String registerStudent(Student student)
	{
		Student save = srepo.save(student);
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
		Student byEmailAndPwd = srepo.findByEmailAndPwd(student.getEmail(), student.getPwd());
		
		return "welcome :" +byEmailAndPwd.getName();
	}
	
	//update password 
	//avoid duplicate email entry
	
	
}
