package com.major.repository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.database.BoothTable;
import com.database.Queries;

@Path("userverify")
public class UserVerify {
	private String userId,password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BoothTable verifyBooth(UserVerify user)
	{
		BoothTable booth;
		Queries query=new Queries();
		//verification code
		booth=query.authentication(user.getUserId(), user.getPassword());
		System.out.println(user);
		return booth;
		
	}

	@Override
	public String toString() {
		return "UserVerify [userId=" + userId + ", password=" + password + "]";
	}
		
}
