package com.app.pojos;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="address")
public class Address {
	
	private Integer id;
	private String streetAddress;
	private String city;
	private String pin;
	private String state;
	

	public Address() {
		System.out.println("in address constr");
	}

	public Address(String streetAddress, String landmark, String city, String pin, String state, String country) {
		this.streetAddress = streetAddress;
		
		this.city = city;
		this.pin = pin;
		this.state = state;
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="addr_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 100, name = "st_addr")
	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	@Column(length = 20)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(length = 20)
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Column(length = 20)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [ streetAddress=" + streetAddress + ", city="
				+ city + ", pin=" + pin + ", state=" + state + ",]";
	}

}
