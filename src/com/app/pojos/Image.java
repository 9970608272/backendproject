package com.app.pojos;

import javax.persistence.*;
import javax.persistence.Enumerated;

@Entity
@Table(name = "image")
public class Image {
	private Integer id;
	private byte[] image;
	private FunctionType ftype;
	
	//private Gallary gallary;
	
	private Photographer photographer;

	private Booking booking;
	
	public Image() {
	}

	public Image(byte[] image, FunctionType ftype) {
		this.image = image;
		this.ftype = ftype;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Lob
	public byte[] getImage() {
		return image;
	}

	

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "fuctiontype", length = 20)
	public FunctionType getFtype() {
		return ftype;
	}

	public void setFtype(FunctionType ftype) {
		this.ftype = ftype;
	}
	
	
	
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="gallary_id") public Gallary getGallary() { return gallary;
	 * }
	 * 
	 * public void setGallary(Gallary gallary) { this.gallary = gallary; }
	 */
	@Override
	public String toString() {
		return "Image [imageId=" + id + ", ftype=" + ftype + "]";
	}

	@ManyToOne
	@JoinColumn(name="booking_id")
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@ManyToOne
	@JoinColumn(name="ph_id")
	public Photographer getPhotographer() {
		return photographer;
	}

	public void setPhotographer(Photographer photographer) {
		this.photographer = photographer;
	}
	
	

}
