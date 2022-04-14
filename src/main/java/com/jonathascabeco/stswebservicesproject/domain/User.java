package com.jonathascabeco.stswebservicesproject.domain;

import java.io.Serializable;
import java.util.Objects;


public class User implements Serializable {
	private static final long serialVersionUID = 1L;
		
	private String id;
	private String nameString;
	private String name;
	
	public User() {
		
	}

	public User(String id, String nameString, String name) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}	
}
