package com.dhana.sprinboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class model {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return " [number=" + number + ", name=" + name + ", location=" + location + "]";
	}

	
	
	@Id
	private int number;
	private String name;
	private String location;

}
