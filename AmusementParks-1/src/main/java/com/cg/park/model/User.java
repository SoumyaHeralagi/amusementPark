package com.cg.park.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private Integer userId;

	@Column(name = "Name", nullable = false)
	private String name;

	@Column(name = "Age", nullable = false)
	private Integer age;

	@Column(name = "emailId", nullable = false)
	private String email;

	@Column(name = "Password", nullable = false)
	private String password;
	
	@Column(name = "Role", nullable = false)
	private String role;

	@JsonIgnore
	@ManyToMany(mappedBy = "user")
	private Set<Booking> bookings;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public User(Integer userId, String name, Integer age, String email, String password, String role,
			Set<Booking> bookings) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
		this.role = role;
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", age=" + age + ", email=" + email + ", password="
				+ password + ", role=" + role + ", bookings=" + bookings + "]";
	}
	

	
	
}
