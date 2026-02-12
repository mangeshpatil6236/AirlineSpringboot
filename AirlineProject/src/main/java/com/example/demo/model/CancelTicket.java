package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class CancelTicket {

	@Id
	private String cancelNo;
	
	private String pnr;
	private String name;
	private String flightCode;
	private String date;
	
}
