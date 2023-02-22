package com.cg.park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.park.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
}
