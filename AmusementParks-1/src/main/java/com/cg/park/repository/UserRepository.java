package com.cg.park.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.park.dto.UserRequest;
import com.cg.park.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	List<UserRequest> findByPassword(String password);


	

	

	

	

}
