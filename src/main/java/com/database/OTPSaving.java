package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OTPSaving {
	DBConnection dbconnection;
	Connection connection;
	OTPGeneration otpgeneration;
	public OTPSaving() {
		dbconnection = new DBConnection();
		connection = dbconnection.connect();
		otpgeneration = new OTPGeneration();
		}//constructor
	public void savedata(int id_assembly_constituency) {
		try {
			String query="select id_aadhar from voter_table where id_assembly_constituency=?";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, id_assembly_constituency);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				try {
				String query2="update voter_table set otp=? where id_aadhar=?";
				PreparedStatement stmt2 = connection.prepareStatement(query2);
				String otp=otpgeneration.tryquery();
				stmt2.setString(1, otp);
				stmt2.setLong(2,rs.getLong(1));
				stmt2.executeUpdate();
				System.out.println("success");
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
