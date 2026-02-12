package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Reservation;
import com.example.demo.service.BoardingPassService;

@RestController
@RequestMapping("/api/boarding-pass")
@CrossOrigin
public class BoardingPassController {

	@Autowired
	private BoardingPassService boardingPassSvs;
	
	@GetMapping("/{pnr}")
	public ResponseEntity<?> getBoardingPass(@PathVariable String pnr){
		
		Reservation res = boardingPassSvs.getBoardingPass(pnr);
		
		if(res == null) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("INVALID PNR !");
		}
		
		return ResponseEntity.ok(res);
	}
}
