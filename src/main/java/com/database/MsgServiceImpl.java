//package message;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class MsgServiceImpl implements MsgService  {
	public static void sendsms(SmsQuery smsq)
	{
		System.out.println("inside sendsms");
		System.out.println(smsq);
		//Your authentication key
        String authkey = "195242ATILkUrJf5a6b2072";
        //Multiple mobile numbers separated by comma
       // String mobiles = "9673326227";
        String mobiles=smsq.getContact_no();
        //Sender ID,While using route4 sender id should be 6 characters long.
        String senderId = "001081";
        //Your message to send, Add URL encoding here.
        String message =  smsq.getId_voter()+smsq.getId_booth()+smsq.getOtp()+smsq.getLocation_url()+"Preferred Slot-8to9";
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
	


