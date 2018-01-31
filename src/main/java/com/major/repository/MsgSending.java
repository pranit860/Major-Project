package com.major.repository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("msgsend")
public class MsgSending {
	String msgrec;
	@POST
	@Consumes("text/plain")
	@Produces("text/plain")
	public String sendmsg(String msg1) {
		//MsgServiceImpl service=new MsgServiceImpl();
		//service.sendsms(msg1);
		System.out.println(msg1);
		return msg1;
	}
}
