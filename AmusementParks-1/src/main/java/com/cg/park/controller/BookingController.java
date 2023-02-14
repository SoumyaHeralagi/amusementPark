package com.cg.park.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.park.dto.Bookingdto;
import com.cg.park.exception.BookingNotFoundException;
import com.cg.park.model.Booking;
import com.cg.park.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bservice;

	@GetMapping("/getAllBooking")
	public ResponseEntity<Object> getAllBooking() throws BookingNotFoundException {
		List<Bookingdto> bookingList = bservice.showAllBooking();
		if (bookingList != null) {
			return new ResponseEntity<>(bookingList, HttpStatus.OK);
		} else {
			throw new BookingNotFoundException();
		}
	}

	@GetMapping("/bookingbyid/{id}")
	public ResponseEntity<Object> getBooking(@PathVariable("id") Integer bookingId) throws BookingNotFoundException {
		boolean isBookingExist = bservice.isBookingExist(bookingId);
		if (isBookingExist) {
			Bookingdto bookings = bservice.getBookById(bookingId);
			return new ResponseEntity<>(bookings, HttpStatus.OK);
		} else {
			throw new BookingNotFoundException();
		}
	}

	@PostMapping("/addbooking")
	public ResponseEntity<Object> createBooking(@RequestBody Bookingdto booking) {
		bservice.addBooking(booking);
		return new ResponseEntity<>("booked successfully",HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateBooking(@PathVariable(value = "id") Integer bookingId,
			@RequestBody Bookingdto booking) throws BookingNotFoundException {
		boolean isBookingExist = bservice.isBookingExist(bookingId);
		if (isBookingExist) {
			bservice.updateBooking(booking);
			return new ResponseEntity<>("booking details updated successfully", HttpStatus.OK);
		} else {
			throw new BookingNotFoundException();
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteBooking(@PathVariable(value = "id") Integer bookingId)
			throws BookingNotFoundException {
		boolean isBookingExist = bservice.isBookingExist(bookingId);
		if (isBookingExist) {
			bservice.deleteBooking(bookingId);
			return new ResponseEntity<>("Booking details deleted successfully", HttpStatus.OK);
		} else {
			throw new BookingNotFoundException();
		}
	}
	
}
