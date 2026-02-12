package com.example.demo.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PnrNotFound;
import com.example.demo.model.CancelTicket;
import com.example.demo.model.Reservation;
import com.example.demo.repository.CancelRepository;
import com.example.demo.repository.ReservationRepository;

@Service
public class CancelServiceImpl implements CancelTicketService {
	
	@Autowired
	private ReservationRepository reservationRepo;

	@Autowired
	private CancelRepository cancelRepo;

	@Override
	public Reservation getReservation(String pnr) {
		// TODO Auto-generated method stub
		return reservationRepo.findById(pnr).orElseThrow(() -> new PnrNotFound("PNR NOT FOUND !"));
	}

	@Override
	public String cancelTicket(String pnr) {
		// TODO Auto-generated method stub
	
		Reservation res = reservationRepo.findById(pnr).orElseThrow(() -> new PnrNotFound("PNR NOT FOUND !"));
			
		CancelTicket ct = new CancelTicket();
		ct.setPnr(res.getPnr());
		ct.setName(res.getName());
		ct.setFlightCode(res.getFlightCode());
		ct.setDate(res.getTravelDate());
		ct.setCancelNo("CAN-"+new Random().nextInt(100000));
		
		cancelRepo.save(ct);
		reservationRepo.deleteById(pnr);
		
		return "Ticket Cancelled Successfully..";
	}
	
	
}
