package com.App.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.App.entity.UserRegistrationEntity;

public interface UserRegisterRepository extends JpaRepository<UserRegistrationEntity, Serializable> {
	
}
