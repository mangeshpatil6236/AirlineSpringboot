package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Passenger;
import com.example.demo.repository.PassengerRepository;

@Service
public class PassengerServiceImpl implements PassengerService{

	@Autowired
	private PassengerRepository passengerRepo;

	@Override
	public Passenger addPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		return passengerRepo.save(passenger);
	}
	
}
