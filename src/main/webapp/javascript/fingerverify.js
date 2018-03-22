var check = GetMFS100Info();

// alert("No Scanner");
if (check.httpStaus) {
	if (check.data.ErrorCode == "0") {
		alert("Scanner Connected " + check.data.DeviceInfo.SerialNo);
	} else {
		alert("ERROR!!!!!  " + check.err);
	}
} else {
	alert("No Scanner");
}

var btn=document.querySelector('#buttonscanning');
btn.addEventListener('click',initiate);
function Verify(isotemplate,iso) {
	try {
		//var isotemplate = document.getElementById('txtIsoTemplate').value;
		//var isotemplate2 = "Rk1SACAyMAAAAADYAAABPAFiAMUAxQEAAAAoH0CcAPvOZICAAQfCV4BzAQFwV0BcANcBZIB3ATmgZEDrALfdZEDDAUS4ZEDXATy/ZIA3ATMSZEDrAHjwZEDNAEP6ZECDAPXbV4C+AOfXZIBrAPXlV0CyAKHyZICgAT+zZICLAUutQ0D8ANnUZEAuARuUZEAlALMPL0EcALrcUICvAPTTZICGAML1ZEClALftZIBcAR+UZEBdATiXZIB9AUmgNUD8AM1cZEDCAHX4ZEASAOkoXYCbAEmJXQAA+ATqfXYDNAGjvZEDqASmwZIBXATUtXUCbAFGFZIDgAF90ZEAhAIlFSUBMAVOxKIAvAEi7Q0CUANyvV0B8AN4vV4DGAOXAZECBAJUIV0DVAOTHZEC3AI3qZEB1AIQNV4BbAI0cXYBqATQkZEDgAS+mXYAmAK+tV0CqAUkgSUEFAR27ZIDAAE30ZIDiAUYvV4BWAVUmKEBDAC+8IYChAOOtV0C2ALDWZECEAQArZEC/AQutZIB4AJAIV4BlAQosZEDrAMDbZEDyAKfgZIApAOGvUICTAUYjZED8ARW8ZEAfAOEySUEPARHRXUAzAHYcQ0A2AGNKQ0EGAUYwNUDHABf/SQAA";
		var res = VerifyFinger(isotemplate, iso);

		if (res.httpStaus) {
			if (res.data.Status) {
				return true;
			} else {
				if (res.data.ErrorCode != "0") {
					alert("Error Occured Here : "+res.data.ErrorDescription);
				} else {
					//alert("Finger not matched");
				}
			}
		} else {
			
			alert("Error in first Else"+res.err);
		}
	} catch (e) {
		alert("Exception Occurred"+e);
	}
	return false;

}
function retData()
{
	var jsonData2 = {};
	jsonData2["adharno"]=localStorage.getItem("adhar");

	
	var url="http://localhost:8080/finalproject/webapi/fulldata";
	fetch(url, {
		  method: 'POST', // or 'PUT'
		  body: JSON.stringify(jsonData2), 
		  headers: new Headers({
		    'Content-Type': 'application/json'
		  })
		}).then(res => res.json())
		.then(function(data){
			localStorage.setItem("fname", data["first_name"]);
			localStorage.setItem("lname", data["last_name"]);
			localStorage.setItem("mname", data["middle_name"]);
			localStorage.setItem("email", data["email_id"]);
			localStorage.setItem("mob", data["contact_no"]);
			localStorage.setItem("gender", data["gender"]);
			localStorage.setItem("dob", data["dob"]);
		})
		.catch(error => console.error('Error:', error));
	
	
}
function initiate() {
	var jsonData2 = {};
	jsonData2["data"]=localStorage.getItem("adhar");
	
	var url="http://localhost:8080/finalproject/webapi/fingerdata";
	fetch(url, {
		  method: 'POST', // or 'PUT'
		  body: JSON.stringify(jsonData2), 
		  headers: new Headers({
		    'Content-Type': 'application/json'
		  })
		}).then(res => res.json())
		.then(function(data){
			//alert(data["thumb_print"]);
			if(data["thumb_print"])
			{
			 localStorage.setItem("thumb_print", data["thumb_print"]);
			 localStorage.setItem("index_finger_right", data["index_finger_right"]);
			 localStorage.setItem("ring_finger_right", data["ring_finger_right"]);
			}
		})
		.catch(error => alert(error));
	
	var quality = 60;
	var time = 20;
	var res = CaptureFinger(quality, time);
	
	if (res.httpStaus != null) {
		// alert("Successfully!!!");
		if (res.data.ErrorCode == "0") {

			console.log(res);
			document.getElementById('imgFinger').src = "data:image/bmp;base64,"+ res.data.BitmapData;
			var iso = res.data.IsoTemplate;
			//console.log(localStorage.getItem("thumb_print"),iso);
			if (Verify(localStorage.getItem("thumb_print"),iso)||Verify(localStorage.getItem("index_finger_right"),iso)||Verify(localStorage.getItem("ring_finger_right"),iso)) {
				document.getElementById("i").innerHTML = "Finger Print Matched Successfully";
				alert("FingerPrint Matched Successfully");
				 localStorage.removeItem("thumb_print");
				 localStorage.removeItem("index_finger_right");
				 localStorage.removeItem("ring_finger_right");
				 retData();
				window.location = "http://localhost:8080/finalproject/finalpage.html";
			} else {
				alert("Finger Print Doesnt Match");
				 localStorage.removeItem("thumb_print");
				 localStorage.removeItem("index_finger_right");
				 localStorage.removeItem("ring_finger_right");
				window.location = "http://localhost:8080/finalproject/project.html";
			}

		} else {
			document.getElementById("i").innerHTML = "ERROR!!!!";
		}
	} else {
		alert("ERROR");
	}
	 
}
