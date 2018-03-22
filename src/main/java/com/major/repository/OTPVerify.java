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
	private String bid;
	
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
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
		voter=query.sendDataThroughOtp(otp,ot.getBid());
		//Database Code to execute and return appropriate object
		System.out.println(otp+"\n"+ot.getBid());
		long adhar=voter.getId_aadhar();
		int res=query.checkLog(String.valueOf(adhar));
		if(res==-1)
		{
			voter.setId_voter("-1");
		}
		else if(res==0)
		{
			voter.setId_voter("0");
		}
		else
		{
			
		}
		return voter;
	}
}
