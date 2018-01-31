package com.database;


public class AadharTable {
	@Override
	public String toString() {
		return "AadharTable [id_aadhar=" + id_aadhar + ", first_name=" + first_name + ", middle_name=" + middle_name
				+ ", last_name=" + last_name + ", contact_no=" + contact_no + ", email_id=" + email_id + ", dob=" + dob
				+ ", gender=" + gender + "]";
	}
	private long id_aadhar;
	private String first_name, middle_name, last_name;
	private String contact_no, email_id;
	private String dob,gender;
	
	public long getId_aadhar() {
		return id_aadhar;
	}
	public void setId_aadhar(long id_aadhar) {
		this.id_aadhar = id_aadhar;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}



	
}
