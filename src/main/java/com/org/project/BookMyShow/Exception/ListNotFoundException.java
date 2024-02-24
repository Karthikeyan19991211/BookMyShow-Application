package com.org.project.BookMyShow.Exception;

public class ListNotFoundException extends RuntimeException
{
	private String message;

	public ListNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}	
}
