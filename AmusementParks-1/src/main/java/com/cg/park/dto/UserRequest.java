package com.cg.park.dto;

import java.util.Set;

import com.cg.park.model.Booking;
import com.cg.park.password.Password;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class UserRequest {
	
	@NotNull
	private Integer userId;
	
	@NotNull
	private String name;
	
	@NotNull
	private Integer age;
	
	@NotNull
	private String email;
	
	@Password
	private String password;

	private Set<Booking> booking;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Booking> getBooking() {
		return booking;
	}

	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}

	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRequest(@NotNull Integer userId, @NotNull String name, @NotNull Integer age, @NotNull String email,
			String password, Set<Booking> booking) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "UserRequest [userId=" + userId + ", name=" + name + ", age=" + age + ", email=" + email + ", password="
				+ password + ", booking=" + booking + "]";
	}
	
	
}
