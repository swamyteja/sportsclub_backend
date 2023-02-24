package com.stg.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(value = SportsClubException.class)
	public ResponseEntity<String> handleException(SportsClubException sportsClubException) {
		return new ResponseEntity<String>(sportsClubException.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
