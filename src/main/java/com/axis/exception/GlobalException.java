package com.axis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = IDNotFoundException.class)
	public ResponseEntity<Object> myEmployeeIdException(IDNotFoundException exception){
		return new ResponseEntity<Object>(exception.getMsg(),HttpStatus.NOT_FOUND);
	}
}
