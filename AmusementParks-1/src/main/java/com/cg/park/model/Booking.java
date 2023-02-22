package com.cg.park.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Booking")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private Integer bookingId;

	@Column(name = "booked_date")
	private Date bookedDate;
	
	@Column(name = "ride_name")
	private String rideName;

	@Column(name = "ride_type")
	private String rideType;

	@Column(name = "cost")
	private Long price;
	
	@ManyToMany
	@JoinTable(name="booking_user",
	joinColumns=@JoinColumn(name="bookings_id",referencedColumnName = "booking_id"),
	inverseJoinColumns=@JoinColumn(name="users_id",referencedColumnName = "user_id"))
	private Set<User> user;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(Integer bookingId, Date bookedDate, String rideName, String rideType, Long price, Set<User> user) {
		super();
		this.bookingId = bookingId;
		this.bookedDate = bookedDate;
		this.rideName = rideName;
		this.rideType = rideType;
		this.price = price;
		this.user = user;
	}

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

	public String getRideType() {
		return rideType;
	}

	public void setRideType(String rideType) {
		this.rideType = rideType;
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

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookedDate=" + bookedDate + ", rideName=" + rideName
				+ ", rideType=" + rideType + ", price=" + price + ", user=" + user + "]";
	}
	

	
}
