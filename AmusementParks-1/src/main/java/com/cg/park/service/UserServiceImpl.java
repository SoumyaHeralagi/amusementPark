package com.cg.park.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.park.converter.UserConverter;
import com.cg.park.dto.UserRequest;
import com.cg.park.model.User;
import com.cg.park.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository urep;

	@Autowired
	private UserConverter converter;
	
	 @Autowired
	 private PasswordEncoder passwordEncoder;
	 

	@Override
	public List<UserRequest> showAllUsers() {
		List<User> findAll = urep.findAll();
		return converter.convertEntityToDto(findAll);
		}
	
	@Override
	public UserRequest getUser(Integer userId) {
		User user = urep.findById(userId).orElse(null);
		return converter.convertEntityToDto(user);
		}
	
	@Override
	public UserRequest addUser(UserRequest userReq) {
		userReq.setPassword(passwordEncoder.encode(userReq.getPassword()));
		User user = converter.convertDtoToEntity(userReq);
		user = urep.save(user);
		return converter.convertEntityToDto(user);
		}

	@Override
	public UserRequest updateUser(UserRequest userReq) {
		User existingUser = urep.findById(userReq.getUserId()).get();
        existingUser.setName(userReq.getName());
        existingUser.setAge(userReq.getAge());
        existingUser.setEmail(userReq.getEmail());
        existingUser.setEmail(userReq.getPassword());
        User updatedUser = urep.save(existingUser);
        return converter.convertEntityToDto(updatedUser);
		}

	@Override
	 public void deleteUser(Integer userId) {
        urep.deleteById(userId);
	}

	
	@Override
	public boolean checkLogin(String name, String password) {
		boolean flag = false;
		List<UserRequest> users = urep.findByPassword(password);
		System.out.println(users.toString());
		for (UserRequest user : users) {
			if (user.getName().equals(name) && user.getPassword().equals(password)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public boolean isUserExist(Integer userId) {
		return urep.existsById(userId);
	}

}


	

