package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import com.mysql.jdbc.Statement;

public class VoterRegistration {

	DBConnection dbconnection;
	Connection connection;
	public VoterRegistration() {
		dbconnection = new DBConnection();
		connection = dbconnection.connect();
	}
	public boolean registerVoter(AadharTable aadharTable,BiometricTable biometricTable,String pincode1) {
		long l = Long.parseLong(aadharTable.getContact_no());
		long aid=aadharTable.getId_aadhar();
		boolean status=true;
		try {
				
			String query1="insert into aadhar_table (id_aadhar,first_name,middle_name,last_name,contact_no,email_id,gender,dob) values (?,?,?,?,?,?,?,?)";
			String query2="insert into biometric_table (id_aadhar,thumb_print,index_finger_right,ring_finger_right) values(?,?,?,?)";
			String query3="insert into log_table (id_aadhar,log_status) values (?,?)";
			String query4="select id_booth, id_assembly_constituency from booth_table where pincode=?";
			String query5="insert into voter_table(id_voter,id_aadhar,id_booth,id_assembly_constituency) values(?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(query1);
			
			stmt.setLong(1, aid);
			stmt.setString(2, aadharTable.getFirst_name());
			stmt.setString(3, aadharTable.getMiddle_name());
			stmt.setString(4, aadharTable.getLast_name());
			stmt.setLong(5,l);
			stmt.setString(6,  aadharTable.getEmail_id());
			stmt.setString(7, aadharTable.getGender());
			stmt.setString(8, aadharTable.getDob());
		
			stmt.execute();
			
			PreparedStatement stmt2 = connection.prepareStatement(query2);
			
			stmt2.setLong(1, aid);
			stmt2.setString(2, biometricTable.getThumb_print());
			stmt2.setString(3, biometricTable.getIndex_finger_right());
			stmt2.setString(4, biometricTable.getRing_finger_right());
			
			stmt2.execute();
			//System.out.println("yes");
			
			PreparedStatement stmt3=connection.prepareStatement(query3);
			
			stmt3.setLong(1, aid);
			stmt3.setInt(2, 0);
			
			stmt3.execute();
			
			PreparedStatement stmt4=connection.prepareStatement(query4);
			
			stmt4.setString(1, pincode1);
			ResultSet rs=stmt4.executeQuery();
			String v1=aadharTable.getFirst_name().substring(0,1);
			String v2=aadharTable.getMiddle_name().substring(0, 1);
			String v3=aadharTable.getLast_name().substring(0, 1);
			String s=Long.toString(aadharTable.getId_aadhar());
			String v4=s.substring(1, 8);
			v1= v1.concat(v2).concat(v3).concat(v4);
			
			if(rs.next())
			{
				String bid=rs.getString(1);
				int acid=rs.getInt(2);
				PreparedStatement stmt5=connection.prepareStatement(query5);
				stmt5.setString(1, v1);
				stmt5.setLong(2, aid);
				stmt5.setString(3, bid);
				stmt5.setInt(4, acid);

				stmt5.execute();
				
			}	
			System.out.println("saved");
			
			
		}
		catch(Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;
	}
	
	
}
