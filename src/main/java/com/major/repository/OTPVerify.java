package com.major.repository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.database.Queries;
import com.database.ValidVoter;

@Path("otpverify")
public class OTPVerify {
	private String otp;
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ValidVoter generateDataFromOTP(OTPVerify ot)
	{
		String otp=ot.getOtp();
		ValidVoter voter=new ValidVoter();
		Queries query=new Queries();
		voter=query.sendDataThroughOtp(otp);
		//Database Code to execute and return appropriate object
		System.out.println(otp+"\n"+ot.getUsername());
		return voter;
	}
}
