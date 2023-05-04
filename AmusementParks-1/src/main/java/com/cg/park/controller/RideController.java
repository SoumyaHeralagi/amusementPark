package com.cg.park.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.park.dto.RidesDto;
import com.cg.park.exception.BookingNotFoundException;
import com.cg.park.exception.RideNotFoundException;
import com.cg.park.service.RideService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ride")
public class RideController {
	
	@Autowired
	private RideService rservice;
	
	@GetMapping("/getAllRides")
	public ResponseEntity<Object> getAllBooking() throws BookingNotFoundException {
		List<RidesDto> rideList = rservice.showAllRides();
		if (rideList != null) {
			return new ResponseEntity<>(rideList, HttpStatus.OK);
		} else {
			throw new BookingNotFoundException();
		}
	}
	
	@GetMapping("/rideById/{id}")
	public ResponseEntity<Object> getRide(@PathVariable("id") Integer rideId) throws RideNotFoundException {
		boolean isRideExist = rservice.isRideExist(rideId);
		if (isRideExist) {
			RidesDto ridedto = rservice.getRideById(rideId);
			return new ResponseEntity<>(ridedto, HttpStatus.OK);
		} else {
			throw new RideNotFoundException();
		}
	}
	
	@PostMapping("/addRide")
	public ResponseEntity<Object> createBooking(@RequestBody RidesDto ridedto) {
		rservice.addRide(ridedto);
		return new ResponseEntity<>("ride added successfully",HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateRide(@RequestBody RidesDto ridedto)
			 throws RideNotFoundException {
		RidesDto ride=rservice.updateRide(ridedto);
		if (ride != null) {
			return new ResponseEntity<>("ride updated successfully", HttpStatus.OK);
		}
		else {
			throw new RideNotFoundException();
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteRide(@PathVariable(value = "id") Integer rideId)
			throws RideNotFoundException {
		boolean isRideExist = rservice.isRideExist(rideId);
		if (isRideExist) {
			rservice.deleteRide(rideId);
			return new ResponseEntity<>("ride  deleted successfully", HttpStatus.OK);
		} else {
			throw new RideNotFoundException();
		}
	}


}
