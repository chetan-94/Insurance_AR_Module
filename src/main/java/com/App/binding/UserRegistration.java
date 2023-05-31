package com.App.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserRegistration {
	private Integer userId;
	private String userFullName;
	private String userEmail;
	private Integer userMobileNo;
	private String userGender;
	private Integer userSSN;
	private LocalDate userDOB;
	private String AppRegisterNo;
}
