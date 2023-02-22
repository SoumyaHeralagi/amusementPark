package com.cg.park.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cg.park.dto.UserRequest;
import com.cg.park.exception.UserNotFoundException;
import com.cg.park.model.User;

import jakarta.validation.Valid;

public interface UserService {

	public List<UserRequest>showAllUsers();
	public UserRequest getUser(Integer userid);
	UserRequest addUser(UserRequest userReq);
	public UserRequest updateUser(UserRequest userReq);
	 public void deleteUser(Integer userid);
	
	
	public boolean checkLogin(String username,String password);
	
	public boolean isUserExist(Integer id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
