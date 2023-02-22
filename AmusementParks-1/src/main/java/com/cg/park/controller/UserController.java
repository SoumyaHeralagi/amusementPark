package com.cg.park.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.cg.park.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService uservice;

	@GetMapping("/getAllUser")
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<Object> getAllUser() throws UserNotFoundException {
		List<UserRequest> userList = uservice.showAllUsers();
		if (userList != null) {
			return new ResponseEntity<>(userList, HttpStatus.OK);
		} else {
			throw new UserNotFoundException();
		}
	}

	@GetMapping("/userbyid/{id}")
	@PreAuthorize("hasAuthority('user')")
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
		uservice.addUser(userReq);
		return new ResponseEntity<>("user created successfully", HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	@PreAuthorize("hasAuthority('user')")
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

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Integer userId) throws UserNotFoundException {
		boolean isUserExist = uservice.isUserExist(userId);
		if (isUserExist) {
			uservice.deleteUser(userId);
			return new ResponseEntity<>("user deleted successfully", HttpStatus.OK);
		} else {
			throw new UserNotFoundException();
		}
	}

	@PostMapping("/Login/{name}/{password}")
	public boolean checkLogin(@PathVariable String name, @PathVariable String password) {
		return uservice.checkLogin(name, password);
	}

}
