package com.App.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.aspectj.weaver.tools.Trace;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer userId;
	
	private String userFullName;
	
	@Column(unique = true , nullable = false)
	private String userEmail;
	
	@Column(unique = true)
	private Integer userMobileNo;
	
	private String userGender;
	
	private Integer userSSN;
	
	private LocalDate userDOB;
	
	private String AppRegisterNo;
}
