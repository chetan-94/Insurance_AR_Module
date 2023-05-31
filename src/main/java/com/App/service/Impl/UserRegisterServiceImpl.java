package com.App.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.App.Utils.RandomNumber;
import com.App.binding.UserRegistration;
import com.App.constant.AppConstant;
import com.App.entity.UserRegistrationEntity;
import com.App.exception.RegistrationAppException;
import com.App.properties.AppProperties;
import com.App.repository.UserRegisterRepository;
import com.App.service.UserRegisterService;
@Service
public class UserRegisterServiceImpl implements UserRegisterService {
	@Autowired
	private UserRegisterRepository repo;
	
	@Autowired
	private AppProperties properties;
	
	@Autowired
	private RandomNumber number;

	@Override
	public String saveUser(UserRegistration registration) {
		Integer ssn = registration.getUserSSN();
		Map<String, String> message = properties.getMessages();
		String stringUrl = message.get(AppConstant.SSN_WEB_URL);
		//String url = properties.getMessage().get(AppConstant.SSNWebUrl);
		//String url = "http://localhost:9393/state/{ssn}";
		String url = stringUrl;
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.getForEntity(url, String.class,ssn);
		String stateName = response.getBody();
		
		try {
			if(stateName.equalsIgnoreCase("Kentucky"))
			{
				Integer num = number.randomNum();
				UserRegistrationEntity entity = new UserRegistrationEntity();
				BeanUtils.copyProperties(registration,entity);
				entity.setAppRegisterNo("AR"+num);
				UserRegistrationEntity save = repo.save(entity);
				return AppConstant.SUCCESS;
			}
			else {
				return AppConstant.FAIL;
			}
		} 
		catch (Exception e) {
			throw new RegistrationAppException("Somthing is wrong");
		}
		
	}

	@Override
	public List<UserRegistration> listOfUser() {
		List<UserRegistration> listUser1 = new ArrayList<>();
		List<UserRegistrationEntity> listUser2 = repo.findAll();
		for(UserRegistrationEntity entity : listUser2)
		{
			UserRegistration registration = new UserRegistration();
			BeanUtils.copyProperties(entity, registration);
			listUser1.add(registration);
		}
		return listUser1;
	}

}
