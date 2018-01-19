package com.wh.demo.test.exception;

public class UserNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7230168145895950340L;

	public UserNotExistException(String ms) {
		super(ms);
	}
	
}
