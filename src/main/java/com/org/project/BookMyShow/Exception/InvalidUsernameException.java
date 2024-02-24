package com.org.project.BookMyShow.Exception;

public class InvalidUsernameException extends RuntimeException
{
	private String message;

	public InvalidUsernameException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
