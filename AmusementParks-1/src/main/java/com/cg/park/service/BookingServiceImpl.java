package com.cg.park.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.park.converter.BookingConverter;
import com.cg.park.dto.Bookingdto;
import com.cg.park.model.Booking;
import com.cg.park.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRep;
	
	@Autowired
	private BookingConverter converter;
	
	@Override
	public List<Bookingdto> showAllBooking() {
		List<Booking> findAll = bookingRep.findAll();
		return converter.convertEntityToDto(findAll);
		}
	@Override
	public Bookingdto getBookById(Integer bookingId) {
		Booking booking = bookingRep.findById(bookingId).orElse(null);
		return converter.convertEntityToDto(booking);
		}

	@Override
	public Bookingdto addBooking(Bookingdto booking) {
		Booking bookings = converter.convertDtoToEntity(booking);
		bookings = bookingRep.save(bookings);
		return converter.convertEntityToDto(bookings);
	}
	
	@Override
	public Bookingdto updateBooking(Bookingdto booking) {
		Booking existingBooking =bookingRep.findById(booking.getBookingId()).get();
		existingBooking.setBookedDate(booking.getBookedDate());
	    existingBooking.setRideName(booking.getRideName());
		existingBooking.setPrice(booking.getPrice());
        Booking updatedBooking = bookingRep.save(existingBooking);
        return converter.convertEntityToDto(updatedBooking);
        }

	@Override
	 public void deleteBooking(Integer bookingId) {
       bookingRep.deleteById(bookingId);
	}

	@Override
	public boolean isBookingExist(Integer bookingid) {
		return bookingRep.existsById(bookingid);
}
	

}
