package com.carffrey.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Access(value=AccessType.FIELD)
public class Venue extends Model {
	
	private String name;

	@OneToOne(cascade={CascadeType.REMOVE, CascadeType.PERSIST})	
	private Address address;
	
	private String phoneNumber;
	
	@OneToOne(cascade={CascadeType.REMOVE, CascadeType.PERSIST})
	private VenueDetail detail;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public VenueDetail getDetail() {
		return detail;
	}

	public void setDetail(VenueDetail detail) {
		this.detail = detail;
	}
}
