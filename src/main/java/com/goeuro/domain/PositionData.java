package com.goeuro.domain;

import java.util.HashMap;

public class PositionData {
	
	private String type;
	private String fullName;
	private String name;
	private String iata_airport_code;
	private String country; 
	private String latitude;
	private String longitude;
	private String location_id;
	private boolean inEurope;
	private String countryCode;
	private boolean coreCountry;
	private HashMap<String,String> geo_position;
	private String distance;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getIata_airport_code() {
		return iata_airport_code;
	}
	public void setIata_airport_code(String iata_airport_code) {
		this.iata_airport_code = iata_airport_code;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLocation_id() {
		return location_id;
	}
	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}
	public boolean isInEurope() {
		return inEurope;
	}
	public void setInEurope(boolean inEurope) {
		this.inEurope = inEurope;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public boolean isCoreCountry() {
		return coreCountry;
	}
	public void setCoreCountry(boolean coreCountry) {
		this.coreCountry = coreCountry;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public HashMap<String,String> getGeo_position() {
		return geo_position;
	}
	public void setGeo_position(HashMap<String,String> geo_position) {
		this.geo_position = geo_position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
