package com.major.repository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.database.Queries;

@Path("logstatus")
public class ChangeLog {

	private String adhar;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String change(ChangeLog log)
	{
		Queries query=new Queries();
		
		//code to check status
		query.updateLog(log.getAdhar());
		return "true";
	}

	public String getAdhar() {
		return adhar;
	}

	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}
}
