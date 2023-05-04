package com.cg.park.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.park.dto.RidesDto;
import com.cg.park.model.Rides;

@Component
public class RidesConverter {
	@Autowired
	private ModelMapper modelMapper;

	public RidesDto convertEntityToDto(Rides ride) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(ride,RidesDto.class);
	
	}

	public List<RidesDto > convertEntityToDto(List<Rides> ride) {
		return ride.stream().map(x -> convertEntityToDto(x)).collect(Collectors.toList());

	}

	public Rides convertDtoToEntity(RidesDto ridedto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(ridedto,Rides.class);
	}
	
	public List<Rides> convertDtoToEntity(List<RidesDto > ridedto)
	{
		return ridedto.stream().map(x -> convertDtoToEntity(x)).collect(Collectors.toList());
	}

}
