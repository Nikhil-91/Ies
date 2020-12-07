package com.ashokit.ies.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ashokit.ies.dc.domain.ApiError;

@Controller
@ControllerAdvice
public class CustomExceptionHandler {


	@ExceptionHandler(value=DataNotFoundException.class)
	public ResponseEntity<com.ashokit.ies.dc.domain.ApiError> handleDataNotFound(Exception e){
		ApiError err=new ApiError();
		err.setErrCode("400");
		err.setErrDesc(e.getMessage());
		err.setDate(new Date());
		return new ResponseEntity<ApiError>(err, HttpStatus.BAD_REQUEST);
	}
}
