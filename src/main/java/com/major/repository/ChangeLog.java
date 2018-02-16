package com.major.repository;

import javax.ws.rs.Path;

import com.database.Queries;

@Path("logstatus")
public class ChangeLog {

	private String adhar;
	
	public String change(ChangeLog log)
	{
		Queries query=new Queries();
		String retStatus="";
		//code to check status
		
		return retStatus;
	}

	public String getAdhar() {
		return adhar;
	}

	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}
}
