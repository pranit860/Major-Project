package com.database;
import java.sql.*;

public class Queries {

	DBConnection dbconnection;
	Connection connection;
	//VoterTable voter;
	BoothTable booth;
	ValidVoter validVoter;
	AadharTable aadhar;

	public Queries() {
		dbconnection = new DBConnection();
		connection = dbconnection.connect();
		//voter = new VoterTable();
		booth=new BoothTable();
		validVoter =new ValidVoter();
		aadhar=new AadharTable();
	}

	public ValidVoter sendDataThroughOtp(String otp_num, String b_id) {

		try {
			String query = "select v.id_voter, v.id_booth, a.id_aadhar, a.first_name,a.last_name, a.contact_no from voter_table v"
					+ " left join aadhar_table a on v.id_aadhar=a.id_aadhar where otp=? and id_booth=?";

			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, otp_num);
			stmt.setString(2,b_id);
			ResultSet rs = stmt.executeQuery();
			// System.out.println("try block");
			if (rs.next()) {
				validVoter.setId_voter(rs.getString(1));
				validVoter.setId_booth(rs.getString(2));
				validVoter.setId_aadhar(rs.getLong(3));
				validVoter.setFirst_name(rs.getString(4));
				validVoter.setLast_name(rs.getString(5));
				validVoter.setContact_no(rs.getString(6));
				
			}

			// System.out.println("success");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return validVoter;

	}

	public ValidVoter sendDataThroughAadharId(String aadhar_num, String b_id) {
		Long l = Long.parseLong(aadhar_num);

		try {
			String query = "select v.id_voter, v.id_booth, a.id_aadhar, a.first_name,a.last_name, "
					+ "a.contact_no from voter_table v natural join aadhar_table a  where id_aadhar=? and id_booth=?";

			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setLong(1, l);
			stmt.setString(2,b_id);
			ResultSet rs = stmt.executeQuery();
			// System.out.println("try block");
			if (rs.next()) {
				validVoter.setId_voter(rs.getString(1));
				validVoter.setId_booth(rs.getString(2));
				validVoter.setId_aadhar(rs.getLong(3));
				validVoter.setFirst_name(rs.getString(4));
				validVoter.setLast_name(rs.getString(5));
				validVoter.setContact_no(rs.getString(6));
			}

			// System.out.println("success");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return validVoter;

	}

	public ValidVoter sendDataThroughVoterId(String voter_num, String b_id) {

		try {
			String query = "select v.id_voter, v.id_booth, a.id_aadhar, a.first_name,a.last_name, "
					+ "a.contact_no from voter_table v left join aadhar_table a on v.id_aadhar=a.id_aadhar where id_voter=? and id_booth=? ";


			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, voter_num);
			stmt.setString(2,b_id);
			ResultSet rs = stmt.executeQuery();
			// System.out.println("try block");
			if (rs.next()) {
				validVoter.setId_voter(rs.getString(1));
				validVoter.setId_booth(rs.getString(2));
				validVoter.setId_aadhar(rs.getLong(3));
				validVoter.setFirst_name(rs.getString(4));
				validVoter.setLast_name(rs.getString(5));
				validVoter.setContact_no(rs.getString(6));
			}

			// System.out.println("success");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return validVoter;

	}

	public BoothTable authentication(String user, String pass) {
		
		
		try {
			String query = "select * from booth_table where booth_coordinator=? and booth_password=?";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, user);
			stmt.setString(2, pass);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()==true) {
				
				booth.setId_booth(rs.getString(1));
				booth.setId_constituency(rs.getInt(2));
				booth.setLocation_url(rs.getString(3));
				booth.setBooth_coordinator(rs.getString(4));
				booth.setBooth_password(rs.getString(5));
				booth.setPincode(rs.getLong(6));
				
			 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return false;
		return booth;

	}
	
	public AadharTable detailedinfo(String aadhar_num) {
		try {
			String query="Select * from aadhar_table where id_aadhar=?";
			long l = Long.parseLong(aadhar_num);
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setLong(1,l);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()==true) {
				aadhar.setId_aadhar(rs.getLong(1));
				aadhar.setFirst_name(rs.getString(2));
				aadhar.setMiddle_name(rs.getString(3));
				aadhar.setLast_name(rs.getString(4));
				aadhar.setContact_no(rs.getString(5));
				aadhar.setEmail_id(rs.getString(6));
				aadhar.setGender(rs.getString(7));
				aadhar.setDob(rs.getString(8));
			}
			
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
		return aadhar;
	}
	
	public int verifyLog(String aadhar_num) {
		int a=0;
		try {
			String query="Select log_status from log_table where id_aadhar=?";
			long l = Long.parseLong(aadhar_num);
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setLong(1,l);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
			a=rs.getInt(1);
			}
			else {
				a=2;
			}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	public void updateLog(String aadhar_num) {
		try 
		{
			String query="update log_table set log_status=? where id_aadhar=? ";
			long l = Long.parseLong(aadhar_num);
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1,1);
			stmt.setLong(2,l);
			stmt.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
