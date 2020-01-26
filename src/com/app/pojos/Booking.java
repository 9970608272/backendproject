package com.app.pojos;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "booking")
public class Booking {

	private Integer id;
	private Plan plan;
	private String time;
	private Customer customer;

	private Photographer photographer;
	private List<Image> images = new ArrayList<>();

	public Booking() {
		super();
	}

	public Booking(Integer id, Plan plan, String time, Customer customer, Photographer photographer,
			List<Image> images) {
		super();
		this.id = id;
		this.plan = plan;
		this.time = time;
		this.customer = customer;
		this.photographer = photographer;
		this.images = images;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "plan_id")
	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	@Column(length = 50)
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@ManyToOne
	@JoinColumn(name = "cust_id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne
	@JoinColumn(name = "photogr_id")
	public Photographer getPhotographer() {
		return photographer;
	}

	public void setPhotographer(Photographer photographer) {
		this.photographer = photographer;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", plan=" + plan + ", time=" + time + ", customer=" + customer + ", photographer="
				+ photographer + "]";
	}
	
	

}
