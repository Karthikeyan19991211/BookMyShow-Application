package com.org.project.BookMyShow.Exception;

public class InvalidPasswordException extends RuntimeException
{
	private String message;

	public InvalidPasswordException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}