package com.major.repository;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.database.BiometricTable;
import com.database.Queries;

@Path("storedata")
public class StoreFingerData {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String getDataFinger(BiometricTable bio)
	{
		Queries query=new Queries();
		int res = 0;
		res = query.updateBiometricTable(bio);
		if(res==0)
		return "false";
		else
			return "true";
	}
}
