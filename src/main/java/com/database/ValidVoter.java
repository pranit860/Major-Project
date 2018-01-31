package com.database;


public class ValidVoter {
	
	
	private String first_name, last_name;
	private String contact_no;
	String id_voter,id_booth;
	private long id_aadhar;
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
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
	public String getId_voter() {
		return id_voter;
	}
	public void setId_voter(String id_voter) {
		this.id_voter = id_voter;
	}
	public String getId_booth() {
		return id_booth;
	}
	public void setId_booth(String id_booth) {
		this.id_booth = id_booth;
	}
	public long getId_aadhar() {
		return id_aadhar;
	}
	public void setId_aadhar(long id_aadhar) {
		this.id_aadhar = id_aadhar;
	}
	@Override
	public String toString() {
		return "ValidVoter [first_name=" + first_name + ", last_name=" + last_name + ", contact_no=" + contact_no
				+ ", id_voter=" + id_voter + ", id_booth=" + id_booth + ", id_aadhar=" + id_aadhar + "]";
	}

	
		
}
