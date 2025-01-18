package com.job.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
	
	@Autowired
	private JavaMailSender sender;
	
	public Boolean sendEmail(String to ,String subject,String body)
	{
		//logic 
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setSubject(subject);
		msg.setText(body);
		msg.setTo(to);
		sender.send(msg);
		return true;
	}

}
