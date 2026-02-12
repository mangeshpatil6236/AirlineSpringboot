package com.example.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Flight;
import com.example.demo.model.Passenger;
import com.example.demo.model.Reservation;
import com.example.demo.repository.FlightRepository;
import com.example.demo.service.FlightBookingService;

@RestController
@RequestMapping("api/book")
@CrossOrigin

public class FlightBookingController {

	private final PassengerController passengerController;

	@Autowired
	private FlightBookingService flightBookSvc;

	@Autowired
	private FlightRepository flightRepo;

	FlightBookingController(PassengerController passengerController) {
		this.passengerController = passengerController;
	}

	// fetch passenger
	@GetMapping("passenger/{adhaar}")
	public Passenger getPassenger(@PathVariable String adhaar) {
		return flightBookSvc.fetchPassengerByAdhaar(adhaar);
	}

	// fetch flight
	@GetMapping("/flight")
	public Flight getFlight(@RequestParam String source, @RequestParam String destination) {
		return flightBookSvc.fetchFlight(source, destination);
	}

	// book flight
	@PostMapping("/reservation")
	public Reservation bookFlight(@RequestBody Reservation reservation) {
		reservation.setPnr("PNR-" + new Random().nextInt(1000000));
		reservation.setTicket("TIC-" + new Random().nextInt(10000));

		return flightBookSvc.bookFlight(reservation);
	}

	// fetch all flights
	@GetMapping
	public List<Flight> getAllFlights() {
		return flightRepo.findAll();
	}
}
