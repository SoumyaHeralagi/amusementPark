package com.cg.park.dto;

import java.time.LocalDate;
import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class RidesDto {
	@NotNull
	private Integer rideId;

	@NotNull
	private LocalDate bookedDate;
	
	@NotNull
	private String rideName;

	@NotNull
	private Long price;
	
	@NotNull
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

	public RidesDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RidesDto(@NotNull Integer rideId, @NotNull LocalDate bookedDate, @NotNull String rideName,
			@NotNull Long price, @NotNull Long numOfPersons) {
		super();
		this.rideId = rideId;
		this.bookedDate = bookedDate;
		this.rideName = rideName;
		this.price = price;
		this.numOfPersons = numOfPersons;
	}

	@Override
	public String toString() {
		return "RidesDto [rideId=" + rideId + ", bookedDate=" + bookedDate + ", rideName=" + rideName + ", price="
				+ price + ", numOfPersons=" + numOfPersons + "]";
	}

	
}
