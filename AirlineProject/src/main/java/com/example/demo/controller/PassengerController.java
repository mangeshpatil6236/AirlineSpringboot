package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Passenger;
import com.example.demo.service.PassengerService;

@RestController
@CrossOrigin
public class PassengerController {

	@Autowired
	private PassengerService passengerService;
	
	@PostMapping("/addPassenger")
	public ResponseEntity<?> addPassenger(@RequestBody Passenger passenger){
		Passenger savePassenger = passengerService.addPassenger(passenger);
		return ResponseEntity.ok(savePassenger);
	}
}
