package com.major.repository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.database.AadharTable;
import com.database.Queries;

@Path("fulldata")
public class FullDataExtract {

	private String adharno;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AadharTable dataExtract(FullDataExtract obj)
	{
		AadharTable table=new AadharTable();
		Queries queries=new Queries();
		table=queries.detailedinfo(obj.getAdharno());
		System.out.println(table);
		return table;
	}

	public String getAdharno() {
		return adharno;
	}

	public void setAdharno(String adharno) {
		this.adharno = adharno;
	}
}
