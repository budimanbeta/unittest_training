package com.example.demo.exception;

public class UserNotFoundException  extends RuntimeException{

	private static final long serialVersionUID = -3204705332368137965L;
	
	private final Integer userId;
	
	public UserNotFoundException(String message, Integer userId) {
        super(message);
        this.userId = userId;
    }
 
    public Integer getUserId() {
        return userId;
    }
}
