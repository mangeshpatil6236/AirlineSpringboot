package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PnrNotFound;
import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;

@Service
public class BoardingPassServiceImpl implements BoardingPassService {

	@Autowired
	private ReservationRepository reservationRepo;

	@Override
	public Reservation getBoardingPass(String pnr) {
		// TODO Auto-generated method stub
		return reservationRepo.findByPnr(pnr).orElseThrow(() -> new PnrNotFound("PNR NOT FOUND !"));
	}

}
