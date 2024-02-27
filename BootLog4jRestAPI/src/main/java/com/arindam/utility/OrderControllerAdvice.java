package com.arindam.utility;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.arindam.exception.ErrorInfo;
import com.arindam.exception.OrderIdNotFoundException;

@RestControllerAdvice
public class OrderControllerAdvice {
	@Autowired
Environment env;
	@ExceptionHandler(OrderIdNotFoundException.class)
	public ResponseEntity<ErrorInfo> orderIdNotFoundExceptionHandeler(OrderIdNotFoundException oe)throws OrderIdNotFoundException
	{
		System.out.println("CUSTOM EXCEPTION");
		ErrorInfo error=new ErrorInfo();
		error.setErrorMessage(env.getProperty("orderid.exception.message"));
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> exceptionHandeler(MethodArgumentNotValidException exception)
	{
		System.out.println("VALIDATION");
		ErrorInfo error=new ErrorInfo();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(LocalDateTime.now());
		String errorMsg=exception.getBindingResult().getAllErrors().stream().map(x->x.getDefaultMessage())
				        .collect(Collectors.joining(", "));
		error.setErrorMessage(errorMsg);
		System.out.println("BINDRESULTERROR:"+exception.getBindingResult());
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.BAD_REQUEST);
	}
}
