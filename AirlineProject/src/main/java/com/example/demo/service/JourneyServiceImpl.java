package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PnrNotFound;
import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;

@Service
public class JourneyServiceImpl implements JourneyService {

	@Autowired
	private ReservationRepository reservationRepo;

	@Override
	public Reservation getJourneyByPnr(String pnr) {
		// TODO Auto-generated method stub
		return reservationRepo.findByPnr(pnr).orElseThrow(() ->  new PnrNotFound("Inavalid PNR"));
	}
	
	
}
