package com.clothkatta.sb.exception;

public class OrderIdNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public OrderIdNotFoundException(String message) {
		super(message);
		
	} 
}
