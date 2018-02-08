package com.major.repository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.database.AadharTable;
import com.database.BiometricTable;
import com.database.Queries;



@Path("fingerdata")
public class FingerDataResource {
	private String data;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BiometricTable getFingerData(FingerDataResource f1) throws Exception
	{
		Queries query=new Queries();
		BiometricTable bio=new BiometricTable();
		bio=query.retrieveFingerData(f1.getData());
		
		System.out.println(f1.data);
		return bio;
	}

}
