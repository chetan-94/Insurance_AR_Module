package com.App.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RegiAppExceptionHandler {
	@ExceptionHandler(RegistrationAppException.class)
	public ResponseEntity<AppError> handleAppException(RegistrationAppException exception)
	{
		AppError appError = new AppError();
		appError.setErrorCode("ER297");
		appError.setErrorMsg(exception.getMessage());
		ResponseEntity<AppError> response = new ResponseEntity<AppError>(appError,HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}
}
