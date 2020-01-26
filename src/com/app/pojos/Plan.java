package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "plan")
public class Plan 
{
	private Integer id;
	private FunctionType fType;
	private Double charges;
	
	private Photographer photographer;
	
	public Plan() {
		System.out.println("in view plan constr");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "f_type")
	public FunctionType getfType() {
		return fType;
	}


	public void setfType(FunctionType fType) {
		this.fType = fType;
	}

	public Double getCharges() {
		return charges;
	}

	public void setCharges(Double charges) {
		this.charges = charges;
	}

	@Override
	public String toString() {
		return "Plan [planId=" + id + ", fType=" + fType + ", charges=" + charges + "]";
	}

	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="photogr_id")
	public Photographer getPhotographer() {
		return photographer;
	}

	public void setPhotographer(Photographer photographer) {
		this.photographer = photographer;
	}
	
	

}
