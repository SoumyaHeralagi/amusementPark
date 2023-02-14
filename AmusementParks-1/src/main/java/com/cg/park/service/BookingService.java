package com.cg.park.service;

import java.util.List;

import com.cg.park.dto.Bookingdto;
import com.cg.park.model.Booking;

public interface BookingService {
	
	public List<Bookingdto> showAllBooking();

	public Bookingdto getBookById(Integer bookingid);

	public Bookingdto addBooking(Bookingdto booking);

	public Bookingdto updateBooking(Bookingdto booking);

	public void deleteBooking(Integer bookingid);

	public boolean isBookingExist(Integer id);
	
	

}
