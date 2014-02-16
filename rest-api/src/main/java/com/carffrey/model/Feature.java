package com.carffrey.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(value=AccessType.FIELD)
public class Feature extends Model {
	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		return 37 * result * value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Feature) {
			Feature o = (Feature) obj;
			return getName().equals(o.getName())
					&& getValue().equals(o.getValue());
		}
		return false;
	}

	
}
