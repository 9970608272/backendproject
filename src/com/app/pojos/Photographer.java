package com.app.pojos;

import java.util.ArrayList;

import java.util.List;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "photographer")
public class Photographer {
	
	private Integer id;
	private String name;
	private String email;
	private String password;
	private String phone;
	
	private Role role;
	
	private Address address;
	
	private Gallary gallary;
	private User user;

	
	
	public Photographer() {
	
	}

	private List<Plan> plans = new ArrayList<>();
	private List<Booking> booking = new ArrayList<>();


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ph_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 20, unique = true, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length = 30, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 20)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="addr_id")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
     
	@JsonIgnore
	@OneToOne(mappedBy = "photographer",cascade=CascadeType.ALL,orphanRemoval=true)
	public Gallary getGallary() {
		return gallary;
	}

	public void setGallary(Gallary gallary) {
		this.gallary = gallary;
	}
	
	@OneToOne(orphanRemoval = true,cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "photographer",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "photographer",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	public void addPlan(Plan p)
	{
		this.plans.add(p);
		p.setPhotographer(this);
	}

	public void removePlan(Plan p)
	{
		this.plans.remove(p);
		p.setPhotographer(null);
	}

	@Override
	public String toString() {
		return "Photographer [pId=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phone=" + phone + ", role=" + role +  "]";
	}

	
	

	

}
