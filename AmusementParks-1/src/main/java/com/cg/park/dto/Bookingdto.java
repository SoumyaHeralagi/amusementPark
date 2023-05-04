package com.cg.park.dto;

import java.util.Date;
import java.util.Set;

import com.cg.park.model.User;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Bookingdto {

	@NotNull
	private Integer bookingId;

	@NotNull
	private Date bookedDate;

	@NotNull
	private String rideName;

	@NotNull
	private Long price;

	@NotNull
	private Set<User> user;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date bookedDate) {
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

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public Bookingdto(@NotNull Integer bookingId, @NotNull Date bookedDate, @NotNull String rideName,
			@NotNull Long price, @NotNull Set<User> user) {
		super();
		this.bookingId = bookingId;
		this.bookedDate = bookedDate;
		this.rideName = rideName;
		this.price = price;
		this.user = user;
	}

	public Bookingdto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bookingdto [bookingId=" + bookingId + ", bookedDate=" + bookedDate + ", rideName=" + rideName
				+ ", price=" + price + ", user=" + user + "]";
	}

	
}