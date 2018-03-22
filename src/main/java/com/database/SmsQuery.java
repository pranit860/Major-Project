package com.database;

//package message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SmsQuery {
	
	private String contact_no;
	String id_voter,id_booth;
	String otp;
	String location_name;
	String location_url;
	
	DBConnection dbconnection;
	Connection connection;
	SmsQuery smsquery;
	
	
	/*public SmsQuery() {
		dbconnection=new DBConnection();
		connection = dbconnection.connect();
	}*/
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getId_voter() {
		return id_voter;
	}
	public void setId_voter(String id_voter) {
		this.id_voter = id_voter;
	}
	public String getId_booth() {
		return id_booth;
	}
	public void setId_booth(String id_booth) {
		this.id_booth = id_booth;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	/*public String getLocation_name() {
		return location_name;
	}*/
	/*public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}*/
	public String getLocation_url() {
		return location_url;
	}
	public void setLocation_url(String location_url) {
		this.location_url = location_url;
	}
	@Override
	public String toString() {
		return "SmsQuery [contact_no=" + contact_no + ", id_voter=" + id_voter + ", id_booth=" + id_booth + ", otp="
				+ otp + /*", location_name=" + location_name +*/ ", location_url=" + location_url + "]";
	}
	
	
	public   void sendDataThroughSMS() {
		
		try {
			dbconnection=new DBConnection();
			connection = dbconnection.connect();
			 smsquery =new SmsQuery(); 
			String query="select a.contact_no, v.id_voter, v.id_booth, v.otp, b.location_url from "
					+ "voter_table v inner join aadhar_table a on v.id_aadhar=a.id_aadhar inner join booth_table b on b.id_booth=v.id_booth";
			PreparedStatement stmt = connection.prepareStatement(query);
			//stmt.setString(1);
			ResultSet rs = stmt.executeQuery();
//			rs.last();
//			System.out.println(rs.getRow());
			while(rs.next()) 
				{
				
				//System.out.println("inside rs.next");
				smsquery.setContact_no(rs.getString(1));
				smsquery.setId_voter(rs.getString(2));
				smsquery.setId_booth(rs.getString(3));
				smsquery.setOtp(rs.getString(4));
				//smsquery.setLocation_name(rs.getString(5));
				smsquery.setLocation_url(rs.getString(5));
				//System.out.println("outside rs.next");
				//return smsquery;
				System.out.println(smsquery);
				MsgServiceImpl.sendsms(smsquery);
				
				//SmsQuery s=new SmsQuery();
				//System.out.println("inside main");
				
				//MsgServiceImpl msg1=new MsgServiceImpl();
				//msg1.sendsms(s.sendDataThroughSMS());
				//return smsquery;
				
				}
			rs.close();
		}//try
		catch (Exception e) {
				e.printStackTrace();
		}
		
		
	}
	/*public static void main(String args[])
	{
		//SmsQuery s1;
		SmsQuery s=new SmsQuery();
		System.out.println("inside main");
		s.sendDataThroughSMS();
		
		//MsgServiceImpl.sendsms(s.sendDataThroughSMS());
		
		
		//System.out.println(s.sendDataThroughSMS());
		
	}*/
	
	
}
