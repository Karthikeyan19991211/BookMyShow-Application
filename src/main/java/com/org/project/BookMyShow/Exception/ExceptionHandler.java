package com.org.project.BookMyShow.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.org.project.BookMyShow.Util.ResponseStructure;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;


@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler
{
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Object> handlerConstraintViolationException(ConstraintViolationException e)
	{
		ResponseStructure<Object> structure = new ResponseStructure<Object>();
		Map<String, String> map = new HashMap<String, String>();
		
		for(ConstraintViolation<?> violation:e.getConstraintViolations())
		{
			String fields = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			map.put(fields, message);
		}
		
		structure.setMessage("Enter the proper Details");
		structure.setStatus(HttpStatus.FORBIDDEN.value());
		structure.setData(map);
		
		return new ResponseEntity<Object>(structure,HttpStatus.FORBIDDEN);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> NotFoundException(NotFoundException ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Details Not Found...!!!");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> InvalidPasswordException(InvalidPasswordException ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage("Access Denied...Invalid Password...!!!!");
		structure.setStatus(HttpStatus.UNAUTHORIZED.value());
		structure.setData(ex.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.UNAUTHORIZED);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> InvalidUsernameException(InvalidUsernameException ex)
	{
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage("Access Denied...Invalid Email...!!!!");
		structure.setStatus(HttpStatus.UNAUTHORIZED.value());
		structure.setData(ex.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.UNAUTHORIZED);
	}
}
