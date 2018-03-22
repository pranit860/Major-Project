package com.major.repository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.database.SmsQuery;

@Path("sendsms")
public class MSGSend {

	@POST
	@Produces("text/plain")
	@Consumes("text/plain")
	public String sendSms(String constituency) {
		//SmsQuery smsq=new SmsQuery();
		//smsq.sendDataThroughSMS();
		
		return null;
		
	}
}
