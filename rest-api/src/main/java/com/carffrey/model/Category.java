package com.carffrey.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
@Access(value=AccessType.FIELD)
public class Category extends Model {

	@Column(unique=true)
	private String name;

	@OneToMany(cascade = CascadeType.PERSIST)
	@OrderBy(value = "name")
	private Set<Feature> features = new HashSet<Feature>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Category) {
			Category o = (Category) obj;
			return getName().equals(o.getName());
		}
		return false;
	}
	
}
