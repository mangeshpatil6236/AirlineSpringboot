package com.example.demo.service;

import com.example.demo.model.Flight;
import com.example.demo.model.Passenger;
import com.example.demo.model.Reservation;

public interface FlightBookingService {

	Passenger fetchPassengerByAdhaar(String adhaar);

	Flight fetchFlight(String source, String destination);

	Reservation bookFlight(Reservation reservation);
}
