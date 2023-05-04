package com.cg.park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.park.model.Rides;

@Repository
public interface RideRepository extends JpaRepository<Rides, Integer> {

}
