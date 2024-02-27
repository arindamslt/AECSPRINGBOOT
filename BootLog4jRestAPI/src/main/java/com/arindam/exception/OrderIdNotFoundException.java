package com.arindam.exception;

public class OrderIdNotFoundException extends Exception {
	public OrderIdNotFoundException()
	{
		System.out.println("INVALID ORDER ID.PLEASE CHECK THE CORRECT ID");
	}

}
