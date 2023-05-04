package com.cg.park.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.park.dto.Bookingdto;
import com.cg.park.model.Booking;

@Component
public class BookingConverter {
	@Autowired
	private ModelMapper modelMapper;

	public Bookingdto convertEntityToDto(Booking booking) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(booking, Bookingdto.class);
	
	}

	public List<Bookingdto> convertEntityToDto(List<Booking> booking) {
		return booking.stream().map(x -> convertEntityToDto(x)).collect(Collectors.toList());

	}

	public Booking convertDtoToEntity(Bookingdto bookingdto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(bookingdto, Booking.class);
	}
	
	public List<Booking> convertDtoToEntity(List<Bookingdto> bookingdto)
	{
		return bookingdto.stream().map(x -> convertDtoToEntity(x)).collect(Collectors.toList());
	}


}
