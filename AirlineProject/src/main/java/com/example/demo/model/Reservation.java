package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")

public class Reservation {

	@Id
	@Column(nullable = false, unique = true, length = 20)
	private String pnr;

	@Column(nullable = false, unique = true, length = 20)
	@NotBlank(message = "Ticket number is required")
	private String ticket;

	@Column(unique = true)
	@NotBlank(message = "Aadhaar is required")
	@Pattern(regexp = "^[0-9]{12}$", message = "Aadhaar must be 12 digits")
	private String adhaar;

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Nationality is required")
	private String nationality;

	@NotBlank(message = "Address is required")
	private String address;

	@NotBlank(message = "Gender is required")
	@Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
	private String gender;

	@NotBlank(message = "Flight name is required")
	private String flightName;

	@NotBlank(message = "Flight code is required")
	private String flightCode;

	@NotBlank(message = "Source is required")
	private String source;

	@NotBlank(message = "Destination is required")
	private String destination;

	@NotBlank(message = "Travel date is required")
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Travel date must be in YYYY-MM-DD format")
	private String travelDate;

}
