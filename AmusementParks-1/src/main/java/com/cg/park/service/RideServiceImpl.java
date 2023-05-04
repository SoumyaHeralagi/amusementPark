package com.cg.park.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.park.converter.RidesConverter;
import com.cg.park.dto.RidesDto;
import com.cg.park.model.Rides;
import com.cg.park.repository.RideRepository;

@Service
public class RideServiceImpl implements RideService {

	@Autowired
	private RideRepository rideRep;
	
	@Autowired
	private RidesConverter converter;
	
	@Override
	public List<RidesDto> showAllRides() {
		List<Rides> findAll = rideRep.findAll();
		return converter.convertEntityToDto(findAll);
	}

	@Override
	public RidesDto getRideById(Integer rideId) {
		Rides ride = rideRep.findById(rideId).orElse(null);
		return converter.convertEntityToDto(ride);
	}

	@Override
	public RidesDto addRide(RidesDto ridedto) {
		Rides rides = converter.convertDtoToEntity(ridedto);
		rides = rideRep.save(rides);
		return converter.convertEntityToDto(rides);
	}

	@Override
	public RidesDto updateRide(RidesDto ridedto) {
		Rides existingRide =rideRep.findById(ridedto.getRideId()).get();
		existingRide.setBookedDate(ridedto.getBookedDate());
	    existingRide.setRideName(ridedto.getRideName());
		existingRide.setPrice(ridedto.getPrice());
		existingRide.setNumOfPersons(ridedto.getNumOfPersons());
        Rides updatedRide =rideRep.save(existingRide);
        return converter.convertEntityToDto(updatedRide);
	}

	@Override
	public void deleteRide(Integer rideId) {
		rideRep.deleteById(rideId);

	}

	@Override
	public boolean isRideExist(Integer rideId) {
		return rideRep.existsById(rideId);
	}

}
