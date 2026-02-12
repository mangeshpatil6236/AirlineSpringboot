package com.example.demo.exception;

public class SourceDestinationNotFound extends RuntimeException{
 
	public SourceDestinationNotFound(String msg) {
		super(msg);
	}
}
