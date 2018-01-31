package com.database;


public class BoothTable {
	
	int id_constituency;
	String id_booth;
	String location_url;
	String booth_coordinator, booth_password;
	long pincode;
	
	public int getId_constituency() {
		return id_constituency;
	}
	public void setId_constituency(int id_constituency) {
		this.id_constituency = id_constituency;
	}
	public String getId_booth() {
		return id_booth;
	}
	public void setId_booth(String id_booth) {
		this.id_booth = id_booth;
	}
	public String getLocation_url() {
		return location_url;
	}
	public void setLocation_url(String location_url) {
		this.location_url = location_url;
	}
	public String getBooth_coordinator() {
		return booth_coordinator;
	}
	public void setBooth_coordinator(String booth_coordinator) {
		this.booth_coordinator = booth_coordinator;
	}
	public String getBooth_password() {
		return booth_password;
	}
	public void setBooth_password(String booth_password) {
		this.booth_password = booth_password;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	
	
	
	
}
