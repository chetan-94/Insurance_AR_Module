package com.App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.App.binding.UserRegistration;
import com.App.service.UserRegisterService;

@RestController
public class UserRestController {
	@Autowired
	private UserRegisterService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(
			@RequestBody UserRegistration registration
			)
	{
		String user = service.saveUser(registration);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/show")
	public ResponseEntity<List<UserRegistration>> showUserList()
	{
		List<UserRegistration> listOfUser = service.listOfUser();
		return ResponseEntity.ok(listOfUser);
	}
}
