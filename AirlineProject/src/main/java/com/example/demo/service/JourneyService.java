package com.example.demo.service;

import com.example.demo.model.Reservation;

public interface JourneyService {

	Reservation getJourneyByPnr(String pnr);

}
