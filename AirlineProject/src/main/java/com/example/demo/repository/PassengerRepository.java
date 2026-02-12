package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>{

	 Optional<Passenger> findByAdhaar(String adhaar);
}
