package com.major.repository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.database.AadharTable;
import com.database.Queries;



@Path("fingerdata")
public class FingerDataResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AadharTable getFingerData(FingerData f1) throws Exception
	{
		Queries query=new Queries();
		AadharTable table;
		table=query.detailedinfo(String.valueOf(f1.getAdharNumber()));
		//System.out.print("INSIDE REST");
//		long retStatus;
//		MatchingFinger finger=new MatchingFinger();
//		finger.setFingerRecievedInString(f1.getFinger());
//		finger.convertFinger();
//		retStatus=finger.matchFinger();
		
		System.out.println(table);
		return table;
	}

}
