package com.carffrey.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
@Access(value=AccessType.FIELD)
public class VenueDetail extends Model {

	// TODO Test is here only because without it, 
	// inserts to VenueDetail fail
	// TODO do we need a VenueDetail object, 
	// Better way?
	private Integer test;
	public Integer getTest() {
		return test;
	}
	public void setTest(Integer test) {
		this.test = test;
	}

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@OrderBy(value="name")
	@MapKey(name="name")
	private Map<String, Category> categories = new HashMap<String, Category>();

	public Map<String, Category> getCategories() {
		return categories;
	}

	public void setCategories(Map<String, Category> categories) {
		this.categories = categories;
	}

}
