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

	private String adhar,fname,mname,lname,gender,email,dob,mob,address,pincode,finger_thumb,finger_index,finger_ring;
	
	public String getAdhar() {
		return adhar;
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
	
	@POST
	//@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String resgiter(VoterReg reg)
	{
		String retStatus="";
		BiometricTable bio=new BiometricTable();
		AadharTable adhar=new AadharTable();
		VoterRegistration register=new VoterRegistration();
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
	
	
}
