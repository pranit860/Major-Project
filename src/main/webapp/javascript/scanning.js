var check=GetMFS100Info();

//alert("No Scanner");
if(check.httpStaus)
{
	if(check.data.ErrorCode == "0")
	{
		alert("Scanner Connected  "+check.data.DeviceInfo.SerialNo);
	}
	else{
		alert("ERROR!!!!!  "+check.err);
	}
}
else{
	alert("No Scanner");
}

function clicked(){
	//alert("onclick");
	var quality=60;
	var time= 20;
	var res=CaptureFinger(quality,time);
	var jsonData2={};
	//var jsonData1=null;
	if(res.httpStaus !=null)
	{
		//alert("Successfully!!!");
		if(res.data.ErrorCode=="0")
		{
			document.getElementById("i").innerHTML="Finger Prnt Scanned Successfully!!!";
			console.log(res);
			 document.getElementById('imgFinger').src = "data:image/bmp;base64," + res.data.BitmapData;
			//jsonData1="\"adharNumber\"=\"14010278\",";
			 jsonData2["finger"]="data:image/bmp;base64," + res.data.BitmapData;
			 jsonData2["adharNumber"]=localStorage.getItem("adhar");
		}
		else{
			document.getElementById("i").innerHTML="ERROR!!!!";
		}
	}
	else{
		alert("ERROR");
	}
	$.ajax({
	    type: "POST",
	    url: "http://localhost:8080/finalproject/webapi/fingerdata",
	    data: JSON.stringify(jsonData2),
	    contentType: "application/json; charset=utf-8",
        crossDomain: true,
	    dataType: "json",
	   success: function (data) {     
	          //alert(data);
		   localStorage.setItem("mname", data["middle_name"]);
		   localStorage.setItem("gender", data["gender"]);
		   localStorage.setItem("email", data["email_id"]);
		   localStorage.setItem("dob", data["dob"]);
		   window.location="http://localhost:8080/finalproject/finalpage.html";
	   },
		error: function()
		{
			alert("error");
		}
	  });
}
