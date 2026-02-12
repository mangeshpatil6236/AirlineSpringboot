package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Reservation;
import com.example.demo.service.CancelTicketService;

@RestController
@RequestMapping("api/cancel")
@CrossOrigin

public class CancelController {

	@Autowired
	private CancelTicketService cancelService;
	
	//fetch Ticket Details
	@GetMapping("/{pnr}")
	public ResponseEntity<?> fetchTicket(@PathVariable String pnr){
		
		Reservation res = cancelService.getReservation(pnr);
		
		if(res == null) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("INVALID PNR !");
		}
		
		return ResponseEntity.ok(res);
	}
	
	//Cancel Ticket
	@PostMapping("/{pnr}")
	public ResponseEntity<?> cancelTicket(@PathVariable String pnr){
		
		String result = cancelService.cancelTicket(pnr);
		
		if(result.equals("PNR NOT FOUND")) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(result);
		}
		
		return ResponseEntity.ok(result);
	}
	
	
	
}
