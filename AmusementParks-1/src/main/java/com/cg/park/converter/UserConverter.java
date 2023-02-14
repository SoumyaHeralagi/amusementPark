package com.cg.park.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.park.dto.UserRequest;
import com.cg.park.model.User;

@Component
public class UserConverter {
	@Autowired
	private ModelMapper modelMapper;

	public UserRequest convertEntityToDto(User user) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		//UserRequest userReq = modelMapper.map(user, UserRequest.class);
		return modelMapper.map(user, UserRequest.class);
	}

	public List<UserRequest> convertEntityToDto(List<User> user) {
		return user.stream().map(x -> convertEntityToDto(x)).collect(Collectors.toList());

	}

	public User convertDtoToEntity(UserRequest userReq) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(userReq, User.class);
	
	}
	
	public List<User> convertDtoToEntity(List<UserRequest> dto)
	{
		return dto.stream().map(x -> convertDtoToEntity(x)).collect(Collectors.toList());
	}


}
