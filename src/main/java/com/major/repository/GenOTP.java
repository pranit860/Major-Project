package com.major.repository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.database.OTPSaving;

@Path("genotp")
public class GenOTP {
	private String id_assembly;
	public String getId_assembly() {
		return id_assembly;
	}
	public void setId_assembly(String id_assembly) {
		this.id_assembly = id_assembly;
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public String genOTP(GenOTP gen) {
		int assemblyid=Integer.parseInt(gen.getId_assembly());
		OTPSaving otpsaving=new OTPSaving();
		otpsaving.savedata(assemblyid);
		System.out.println(assemblyid);
		return ("Success");
	}
}
