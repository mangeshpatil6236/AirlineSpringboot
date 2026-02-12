package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	 
	
	@ExceptionHandler({InvalidCredetainalsException.class})
	public ResponseEntity<?> invalidCredHandler(InvalidCredetainalsException e){
		return ResponseEntity.status(404).body(e.getMessage());
	}
	
	@ExceptionHandler({PnrNotFound.class})
	public ResponseEntity<?> PnrNotFoundHandler(PnrNotFound e){
		return ResponseEntity.status(404).body(e.getMessage());
	}
	
	@ExceptionHandler({AdharNotFound.class})
	public ResponseEntity<?> AdhaarNotFoundHandler(AdharNotFound e){
		return ResponseEntity.status(404).body(e.getMessage());
	}
	
	@ExceptionHandler({SourceDestinationNotFound.class})
	public ResponseEntity<?> SourceDestinationNotFoundHandler(SourceDestinationNotFound e){
		return ResponseEntity.status(404).body(e.getMessage());
	}
}
