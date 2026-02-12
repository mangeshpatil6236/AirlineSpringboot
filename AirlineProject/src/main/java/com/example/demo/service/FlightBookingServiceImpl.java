package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.AdharNotFound;
import com.example.demo.exception.SourceDestinationNotFound;
import com.example.demo.model.Flight;
import com.example.demo.model.Passenger;
import com.example.demo.model.Reservation;
import com.example.demo.repository.FlightRepository;
import com.example.demo.repository.PassengerRepository;
import com.example.demo.repository.ReservationRepository;

@Service
public class FlightBookingServiceImpl implements FlightBookingService {

	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired 
	private FlightRepository flightRepo;
	
	@Autowired ReservationRepository reservationRepo;

	@Override
	public Passenger fetchPassengerByAdhaar(String adhaar) {
		// TODO Auto-generated method stub
		return passengerRepo.findByAdhaar(adhaar)
				.orElseThrow(() -> new AdharNotFound("Passenger not found"));
	}

	@Override
	public Flight fetchFlight(String source, String destination) {
		// TODO Auto-generated method stub
		return flightRepo.findBySourceAndDestination(source, destination)
				.orElseThrow(() -> new SourceDestinationNotFound("Flight Not Found"));
	}

	@Override
	public Reservation bookFlight(Reservation reservation) {
		// TODO Auto-generated method stub
		return reservationRepo.save(reservation);
	}
	
	
	
	
}
