package com.cg.park.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.park.dto.UserRequest;

import com.cg.park.exception.UserNotFoundException;
import com.cg.park.repository.UserRepository;
import com.cg.park.service.UserService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService uservice;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private UserRepository urep;

	@GetMapping("/getAllUser")
	public ResponseEntity<Object> getAllUser() throws UserNotFoundException {
		List<UserRequest> userList = uservice.showAllUsers();
		if (userList != null) {
			return new ResponseEntity<>(userList, HttpStatus.OK);
		} else {
			throw new UserNotFoundException();
		}
	}

	@GetMapping("/userById/{id}")
	public ResponseEntity<Object> getUser(@PathVariable("id") Integer userId) throws UserNotFoundException {
		boolean isUserExist = uservice.isUserExist(userId);
		if (isUserExist) {
			UserRequest user = uservice.getUser(userId);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			throw new UserNotFoundException();
		}
	}

	@PostMapping("/registration")
	public ResponseEntity<Object> createUser(@RequestBody UserRequest userReq) {
		boolean isexistsByEmail = uservice.existsByEmail(userReq.getEmail());
		if (isexistsByEmail) {
			return new ResponseEntity<>("user already exists", HttpStatus.BAD_REQUEST);
		} else {
			uservice.addUser(userReq);
			return new ResponseEntity<>("user created successfully", HttpStatus.OK);

		}
	}
	

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable(value = "id") Integer userId, @RequestBody UserRequest user)
			throws UserNotFoundException {
		boolean isUserExist = uservice.isUserExist(userId);
		if (isUserExist) {
			uservice.updateUser(user);
			return new ResponseEntity<>("user updated successfully", HttpStatus.OK);
		} else {
			throw new UserNotFoundException();
		}
	}
	@PostMapping("/Login1")
	public boolean checkLogin(@PathVariable String name, @PathVariable String password) {
		return uservice.checkLogin(name, password);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Integer userId) throws UserNotFoundException {
		boolean isUserExist = uservice.isUserExist(userId);
		if (isUserExist) {
			uservice.deleteUser(userId);
			return new ResponseEntity<>("user deleted successfully", HttpStatus.OK);
		} else {
			throw new UserNotFoundException();
		}
	}

	
	
	@PostMapping("/login")
	public ResponseEntity<String> authenticateUser(@RequestBody UserRequest userDto) {
	Authentication authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));
	 urep.findByEmail(userDto.getEmail());
	System.out.println(userDto.getEmail());
	System.out.println(userDto.getPassword());
	if (userDto.getEmail().equalsIgnoreCase(userDto.getEmail())) {
		return new ResponseEntity<>("User LogIn successful.", HttpStatus.OK); 
	}
	SecurityContextHolder.getContext().setAuthentication(authentication);
	return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
	}
}
