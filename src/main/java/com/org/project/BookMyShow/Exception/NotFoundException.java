package com.org.project.BookMyShow.Exception;

public class NotFoundException extends RuntimeException
{
	private String message;

	public NotFoundException(String message) {
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}	
}
