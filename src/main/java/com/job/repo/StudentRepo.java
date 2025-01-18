package com.job.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.entity.Student;

public interface StudentRepo  extends JpaRepository<Student,Integer>{
	
	public Student findByEmailAndPwd(String email,String password);

}
