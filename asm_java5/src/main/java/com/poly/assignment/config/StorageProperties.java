package com.poly.assignment.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")

public class StorageProperties {
    private String location;
    public StorageProperties() {
		// TODO Auto-generated constructor stub
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
