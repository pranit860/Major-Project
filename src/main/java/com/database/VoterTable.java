package com.database;

public class VoterTable {

	String id_voter, id_booth;
	private long id_aadhar;
	int id_constituency;
	String otp;

	public VoterTable() {
		this.id_aadhar=0;
		this.id_booth="";
		this.id_constituency=0;
		this.id_voter="";
		this.otp="";
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

	public int getId_constituency() {
		return id_constituency;
	}

	public void setId_constituency(int id_constituency) {
		this.id_constituency = id_constituency;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

}
