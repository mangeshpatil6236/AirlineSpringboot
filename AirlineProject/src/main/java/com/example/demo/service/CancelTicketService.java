package com.example.demo.service;

import com.example.demo.model.Reservation;

public interface CancelTicketService {

	Reservation getReservation(String pnr);

	String cancelTicket(String pnr);

}
