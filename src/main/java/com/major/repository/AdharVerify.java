package com.major.repository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.database.Queries;
import com.database.ValidVoter;

@Path("adharverify")
public class AdharVerify {
	String adhar;

	public String getAdhar() {
		return adhar;
	}

	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ValidVoter generateDataFromAdhar(AdharVerify verify) {
		String adhar = verify.getAdhar();
		ValidVoter voter = new ValidVoter();
		Queries query = new Queries();
		System.out.println(adhar);
		if (adhar.length() == 10) {
			voter = query.sendDataThroughVoterId(verify.getAdhar());
			System.out.println("inside voter");
		}
		if (adhar.length() == 12) {
			voter = query.sendDataThroughAadharId(adhar);
			System.out.println("inside adhar");
			System.out.println(voter.getFirst_name());
		}
		return voter;

	}
}
