package com.cg.park.service;

import java.util.List;

import com.cg.park.dto.RidesDto;

public interface RideService {
	
	public List<RidesDto> showAllRides();

	public RidesDto getRideById(Integer rideId);

	public RidesDto addRide(RidesDto ridedto);

	public RidesDto updateRide(RidesDto ridedto);

	public void deleteRide(Integer rideId);

	public boolean isRideExist(Integer rideId);
	
}
