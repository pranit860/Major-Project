var check = GetMFS100Info();
var finger1 = null;
var finger2 = null;
var finger3 = null;
//alert("No Scanner");
if (check.httpStaus) {
	if (check.data.ErrorCode == "0") {
		//alert("Scanner Connected  " + check.data.DeviceInfo.SerialNo);
	}
	else {
		alert("ERROR!!!!!  " + check.err);
	}
}

var btn=document.querySelector('#buttonsubmit');
btn.addEventListener('click',validate);

function validate()
{
	var error=true;
	var description=[];
  if( document.getElementById("adharno").value == "" ||
  isNaN( document.getElementById("adharno").value) ||
  document.getElementById("adharno").value.length != 12 )
{
description[0]=" Please provide a aadhar no in numeric with 12 digit.\n";
error=false;
//alert( "Please provide a pincode in the format ###### in numeric." );
document.StudentRegistration.aadharno.focus() ;

}
  if( document.getElementById("studentname").value == "" )
   {
	   description[1]="Please provide your FirstName!\n";
	   error=false;
     //alert( "Please provide your Name!" );
     document.StudentRegistration.studentname.focus() ;
     
   }
    if( !isNaN(document.getElementById("studentname").value) )
   {
	   description[2]=" Please provide your only text!\n";
	   error=false;
     //alert( "Please provide your only text!" );
     document.StudentRegistration.studentname.focus() ;
     
   }

   if( document.getElementById("middlename").value == "" )
   {
	   description[3]="Please provide your MiddleName!\n";
	   error=false;
     //alert( "Please provide your Name!" );
     document.StudentRegistration.middlename.focus() ;
     
   }
    if( !isNaN(document.getElementById("middlename").value) )
   {
	   description[4]=" Please provide your only text!\n";
	   error=false;
     //alert( "Please provide your only text!" );
     document.StudentRegistration.studentname.focus() ;
     
   }
 
   if( document.getElementById("lastname").value == "" )
   {
	    description[5]=" Please provide your lastname! \n";
	   error=false;
     //alert( "Please provide your lastname Name!" );
     document.StudentRegistration.lastname.focus() ;
    
   }
   
   if( !isNaN(document.getElementById("lastname").value) )
   {
	    description[6]=" Please provide your only text!\n";
	   error=false;
     //alert( "Please provide your only text!" );
     document.StudentRegistration.lastname.focus() ;
    
   }
 
   
 
   if( document.getElementById("personaladdress").value == "" )
   {
	    description[7]=" Please provide your Address!\n";
	   error=false;
     //alert( "Please provide your Personal Address!" );";
	   document.getElementById("personaladdress").focus() ;
    
   }
   if ( document.getElementById("radio1").checked==false)
   {
	    description[8]=" Please choose your Gender: Male or Female\n";
	   error=false;
   //alert ( "Please choose your Gender: Male or Female" );
   
   }   
  
   if( document.getElementById("pincode").value == "" ||
           isNaN( document.getElementById("pincode").value) ||
           document.getElementById("pincode").value.length != 6 )
   {
	    description[9]=" Please provide a pincode in the format ###### in numeric.\n";
	   error=false;
     //alert( "Please provide a pincode in the format ###### in numeric." );
     document.StudentRegistration.pincode.focus() ;
     
   }
 var email = document.getElementById("emailid").value;
  atpos = email.indexOf("@");
  dotpos = email.lastIndexOf(".");
 if (email == "" || atpos < 1 || ( dotpos - atpos < 2 )) 
 {
	  description[10]=" Please enter correct email ID. \n";
	 error=false;
     //alert("Please enter correct email ID")
     document.StudentRegistration.emailid.focus() ;
     
 }
  if( document.getElementById("dob").value == "" )
   {
	   description[11]="Please provide your DOB!\n";
	   error=false;
     //alert( "Please provide your DOB!" );
     document.StudentRegistration.dob.focus() ;
     
   }
  if( document.getElementById("mobileno").value == "" ||
           isNaN( document.getElementById("mobileno").value) ||
           document.getElementById("mobileno").value.length != 10 )
   {
	   description[12]="Please provide a Mobile No in the format 123.\n";
	   error=false;
     //alert( "Please provide a Mobile No in the format 123." );
     document.StudentRegistration.mobileno.focus() ;
     
   }
  if(finger1==null && finger2==null && finger3==null){
	  description[13]="Finger Not scanned properly!!\n";
	  error=false;
  }
   if(error==true)
   {
	var datatosend={};
	datatosend["adharno"]=document.getElementById("adharno").value;
	console.log(datatosend["adharno"])
	datatosend["fname"]=document.getElementById("studentname").value;
	datatosend["mname"]=document.getElementById("middlename").value;
	datatosend["lname"]=document.getElementById("lastname").value;
	datatosend["gender"]=document.getElementById("radio1").value;
	datatosend["email"]=document.getElementById("emailid").value;
	datatosend["dob"]=document.getElementById("dob").value;
	datatosend["mob"]=document.getElementById("mobileno").value;
	datatosend["address"]=document.getElementById("personaladdress").value;
	datatosend["pincode"]=document.getElementById("pincode").value;
	datatosend["finger_thumb"]=finger1;
	datatosend["finger_index"]=finger2;
	datatosend["finger_ring"]=finger3;
	alert(datatosend["adhar"]+"\n"+datatosend["fname"]+"\n"+datatosend["mname"]+"\n"+datatosend["lname"]+"\n"+datatosend["gender"]+"\n"+datatosend["email"]+"\n"+datatosend["dob"]+"\n"+datatosend["mob"]+"\n"+datatosend["address"]+"\n"+datatosend["pincode"]);
	 $.ajax({
	    type: "POST",
		url: "http://localhost:8080/finalproject/webapi/voterregistration",
	    data: JSON.stringify(datatosend),
	    contentType: "application/json; charset=utf-8",
        crossDomain: true,
		 success: function (data) {     
              if(data=="Success")
              {
                   // window.location.replace("project.html");
                 alert("Data sent successfully");
				 //window.location=" ";
				 
              }
			  else{
                    alert("Data not sent");
                    location.reload();
              }
              },
		error: function()
		{
			alert("error");
		}
	 });
	 
	 
//	 var url="http://localhost:8080/finalproject/webapi/voterregistration";
//	 
//		fetch(url, {
//			  method: 'POST', // or 'PUT'
//			  body: JSON.stringify(data), 
//			  headers: new Headers({
//			    'Content-Type': 'application/json'
//			  })
//			}).then(res => res.json())
//			.then(check)
//			.catch(error => console.error('Error:', error));
   }
	else
	{
		alert(description);
		//document.getElementById("errorgen").innerHTML=description;
		//return (false);
	}
}

function thumbfinger()
{//alert("onclick");
	var quality = 60;
	var time = 20;
	var res = CaptureFinger(quality, time);
	
	if (res.httpStaus != null) {
		//alert("Successfully!!!");
		if (res.data.ErrorCode == "0") {
			//document.getElementById("i").innerHTML = "Finger Prnt Scanned Successfully!!!";
			//console.log(res);
			document.getElementById('my_div1').src = "data:image/bmp;base64," + res.data.BitmapData;
			finger1=res.data.IsoTemplate;
		}
		else {
			
			//document.getElementById("i").innerHTML = "ERROR!!!!";
		}
	}
	else {
		alert("ERROR");
	}

	
}
function indexfinger()
{
	//alert("onclick");
	var quality = 60;
	var time = 20;
	var res = CaptureFinger(quality, time);
	
	if (res.httpStaus != null) {
		alert("Successfully!!!");
		if (res.data.ErrorCode == "0") {
			//document.getElementById("i").innerHTML = "Finger Prnt Scanned Successfully!!!";
			//console.log(res);
			document.getElementById('my_div2').src = "data:image/bmp;base64," + res.data.BitmapData;
			finger2=res.data.IsoTemplate;
		}
		else {
			document.getElementById("i").innerHTML = "ERROR!!!!";
		}
	}
	else {
		alert("ERROR");
	}

}
function ringfinger()
{
	
	var quality = 60;
	var time = 20;
	var res = CaptureFinger(quality, time);
	
	if (res.httpStaus != null) {
		//alert("Successfully!!!");
		if (res.data.ErrorCode == "0") {
			//document.getElementById("i").innerHTML = "Finger Prnt Scanned Successfully!!!";
			//console.log(res);
			document.getElementById('my_div3').src = "data:image/bmp;base64," + res.data.BitmapData;
			finger3=res.data.IsoTemplate;
		}
		else {
			//document.getElementById("i").innerHTML = "ERROR!!!!";
		}
	}
	else {
		alert("ERROR");
	}

}
function check(data){
	if(data=="Success")
    {
         // window.location.replace("project.html");
       alert("Data sent successfully");
		 window.location=" ";
		 
    }
	  else{
          alert("Data not sent");
         // location.reload();
    }
}

