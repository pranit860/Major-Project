package com.major.repository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.database.AadharTable;
import com.database.BiometricTable;
import com.database.VoterRegistration;

@Path("voterregistration")
public class VoterReg {

	private String adharno,fname,mname,lname,gender,email,dob,mob,address,pincode,finger_thumb,finger_index,finger_ring;
	
	public String getAdhar() {
		return adharno;
	}
	public String getFname() {
		return fname;
	}
	public String getMname() {
		return mname;
	}
	public String getLname() {
		return lname;
	}
	public String getGender() {
		return gender;
	}
	public String getEmail() {
		return email;
	}
	public String getDob() {
		return dob;
	}
	public String getMob() {
		return mob;
	}
	public String getAddress() {
		return address;
	}
	public String getPincode() {
		return pincode;
	}
	public String getFinger_thumb() {
		return finger_thumb;
	}
	public String getFinger_index() {
		return finger_index;
	}
	public String getFinger_ring() {
		return finger_ring;
	}
	@Override
	public String toString() {
		System.out.println(this.getAdhar()+"\n"+this.getFname()+"\n"+this.getMname()+"\n"+this.getLname()+"\n"+this.getMob()+"\n"+this.getGender()+"\n");
		return this.getAdhar()+"\n"+this.getFname()+"\n"+this.getMname()+"\n"+this.getLname()+"\n"+this.getMob()+"\n"+this.getGender()+"\n";
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String resgiter(VoterReg reg)
	{
		String retStatus="";
		BiometricTable bio=new BiometricTable();
		AadharTable adhar=new AadharTable();
		VoterRegistration register=new VoterRegistration();
		System.out.println(reg);
		adhar.setFirst_name(reg.getFname());
		adhar.setLast_name(reg.getLname());
		adhar.setMiddle_name(reg.getMname());
		adhar.setContact_no(reg.getMob());
		adhar.setDob(reg.getDob());
		adhar.setEmail_id(reg.getEmail());
		adhar.setGender(reg.getGender());
		adhar.setId_aadhar(Long.parseLong(reg.getAdhar()));
		bio.setId_aadhar(Long.parseLong(reg.getAdhar()));
		bio.setIndex_finger_right(reg.getFinger_index());
		bio.setThumb_print(reg.getFinger_thumb());
		bio.setRing_finger_right(reg.getFinger_ring());
		// call the queries function
		boolean status=register.registerVoter(adhar, bio, reg.getPincode());
		if(status)
		retStatus="true";
		else
			retStatus="false";
		
		return retStatus;
	}
	public void setAdharno(String adharno) {
		this.adharno = adharno;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public void setFinger_thumb(String finger_thumb) {
		this.finger_thumb = finger_thumb;
	}
	public void setFinger_index(String finger_index) {
		this.finger_index = finger_index;
	}
	public void setFinger_ring(String finger_ring) {
		this.finger_ring = finger_ring;
	}
	
	
}
