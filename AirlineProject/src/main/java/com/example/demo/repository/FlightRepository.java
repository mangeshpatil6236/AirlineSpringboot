package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Flight;
import com.example.demo.model.Passenger;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{

	Optional<Flight> findBySourceAndDestination(String source, String destination);

}
