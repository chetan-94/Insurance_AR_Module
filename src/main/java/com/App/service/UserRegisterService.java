package com.App.service;

import java.util.List;

import com.App.binding.UserRegistration;

public interface UserRegisterService {
	public String saveUser(UserRegistration registration);
	public List<UserRegistration> listOfUser();
}
