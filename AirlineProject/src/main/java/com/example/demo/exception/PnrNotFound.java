package com.example.demo.exception;

public class PnrNotFound extends RuntimeException{
	
	public PnrNotFound (String msg) {
		super(msg);
	}

}
