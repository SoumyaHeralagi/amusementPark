package com.cg.park.model;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rides")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Rides {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ride_id")
	private Integer rideId;

	@Column(name = "booked_date")
	private LocalDate bookedDate;
	
	@Column(name = "ride_name")
	private String rideName;

	@Column(name = "cost")
	private Long price;
	
	@Column(name = "Num_Of_Persons")
	private Long numOfPersons;

	public Integer getRideId() {
		return rideId;
	}

	public void setRideId(Integer rideId) {
		this.rideId = rideId;
	}

	public LocalDate getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(LocalDate bookedDate) {
		this.bookedDate = bookedDate;
	}

	public String getRideName() {
		return rideName;
	}

	public void setRideName(String rideName) {
		this.rideName = rideName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getNumOfPersons() {
		return numOfPersons;
	}

	public void setNumOfPersons(Long numOfPersons) {
		this.numOfPersons = numOfPersons;
	}

	public Rides() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rides(Integer rideId, LocalDate bookedDate, String rideName, Long price, Long numOfPersons) {
		super();
		this.rideId = rideId;
		this.bookedDate = bookedDate;
		this.rideName = rideName;
		this.price = price;
		this.numOfPersons = numOfPersons;
	}

	@Override
	public String toString() {
		return "Rides [rideId=" + rideId + ", bookedDate=" + bookedDate + ", rideName=" + rideName + ", price=" + price
				+ ", numOfPersons=" + numOfPersons + "]";
	}

	

}
