package com.App.Utils;

import java.util.Random;

import org.springframework.stereotype.Component;
@Component
public class RandomNumber {
	public Integer randomNum()
	{
		Random random = new Random();
		int rand_int1 = random.nextInt(10000);
		return rand_int1;
	}
	
}
