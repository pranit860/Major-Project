package com.message.send;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class MsgServiceImpl implements MsgService  {
	private String msgRecieved;
	public String getMsg() {
		return msgRecieved;
	}
	public void setMsg(String msg) {
		this.msgRecieved = msg;
	}
	public void sendsms(String numbermobiles)
	{
		//Your authentication key
        String authkey = "186929Arsvc83RZ5a278f97";
        //Multiple mobile numbers separated by comma
       // String mobiles = "9673326227";
        String mobiles=numbermobiles;
        //Sender ID,While using route4 sender id should be 6 characters long.
        String senderId = "777777";
        //Your message to send, Add URL encoding here.
        String message = "Test message"+"VoterId-23XXXXX"+"Booth location-xyzschool"+"OTP-123456"+"Slot-8to9";
        //define route
        String route="default";

        //Prepare Url
        URLConnection myURLConnection=null;
        URL myURL=null;
        BufferedReader reader=null;

        //encoding message
        String encoded_message=URLEncoder.encode(message);

        //Send SMS API
        String mainUrl="http://api.msg91.com/api/sendhttp.php?";

        //Prepare parameter string
        StringBuilder sbPostData= new StringBuilder(mainUrl);
        sbPostData.append("authkey="+authkey);
        sbPostData.append("&mobiles="+mobiles);
        sbPostData.append("&message="+encoded_message);
        sbPostData.append("&route="+route);
        sbPostData.append("&sender="+senderId);

        //final string
        mainUrl = sbPostData.toString();
        try
        {
            //prepare connection
            myURL = new URL(mainUrl);
            myURLConnection = myURL.openConnection();
            myURLConnection.connect();
            reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
            //reading response
            String response;
            while ((response = reader.readLine()) != null)
            //print response
            System.out.println(response);

            //finally close connection
            reader.close();
        }
        catch (IOException e)
        {
                e.printStackTrace();
        }
	}
	}
	


