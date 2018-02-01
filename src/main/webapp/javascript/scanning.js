var check = GetMFS100Info();

// alert("No Scanner");
if (check.httpStaus) {
	if (check.data.ErrorCode == "0") {
		alert("Scanner Connected  " + check.data.DeviceInfo.SerialNo);
	} else {
		alert("ERROR!!!!!  " + check.err);
	}
} else {
	alert("No Scanner");
}

function Verify(isotemplate) {
	try {
		// var isotemplate = document.getElementById('txtIsoTemplate').value;
		var isotemplate2 = "Rk1SACAyMAAAAAGkAAABPAFiAMUAxQEAAAAoQUC0ALakZECWAMcnZECOAKIoZEDlALrDSUDVAIfMZECEAQGjZECgAGr1ZIBzAHyuZIBoAPosUEBOALQ2XYEHAPm9XYBdAQW6PIEJAQeyXUCGAFMXXUBZAGcwUECtADYqL0CWADk1NYBOAF6xPID+AEZCSUCbAVKcPEDaAU4VFEBxAVkLPEC/ALiqZEDZAL63SUCoAIypZIBxAL8wZEDpAJXLZED8AKzOXUEHAKbSZEB0AQEhUICFARMjV0CvASMfXYChAFb7ZEDfASQlZECrAE37PEC3ATgdV0CkADoWPEDEADj1PECHADw1NYEOASI1NYD1AT4ZUEEJATIoPEChACg9G0BbAVQJG4CoAKaqZEDLAOGoZECzAIu+ZEBzANEpZED5AMjHXUDEARKdZEDiAQykZIDvAQWqXUCaARogUIDaAGPgZEESAI3XZIBPAPUxL0A/AL23XYEaAPzNV0BmAFEiIUDNAUMbXYDnAEBxSUC9ADQYL0BwAUEQQ4DHAVING4DjACaKBwAA";
		var res = VerifyFinger(isotemplate, isotemplate2);

		if (res.httpStaus) {
			if (res.data.Status) {
				
				alert("Finger matched");
				
				return true;
			} else {
				if (res.data.ErrorCode != "0") {
					alert(res.data.ErrorDescription);
				} else {
					alert("Finger not matched");
				}
			}
		} else {
			alert(res.err);
		}
	} catch (e) {
		alert(e);
	}
	return false;

}

function clicked() {
	// alert("onclick");
	var quality = 60;
	var time = 20;
	var res = CaptureFinger(quality, time);
	var jsonData2 = {};
	// var jsonData1=null;
	if (res.httpStaus != null) {
		// alert("Successfully!!!");
		if (res.data.ErrorCode == "0") {

			console.log(res);
			document.getElementById('imgFinger').src = "data:image/bmp;base64,"+ res.data.BitmapData;
			var iso = res.data.IsoTemplate;
			var ret = Verify(iso);
			if (ret == true) {
				document.getElementById("i").innerHTML = "Finger Print Matched Successfully";
				window.location = "http://localhost:8080/finalproject/finalpage.html";
			} else {
				alert("Finger Print Doesnt Match");
				window.location = "http://localhost:8080/finalproject/project.html";
			}

		} else {
			document.getElementById("i").innerHTML = "ERROR!!!!";
		}
	} else {
		alert("ERROR");
	}
	// $.ajax({
	// type: "POST",
	// url: "http://localhost:8080/finalproject/webapi/fingerdata",
	// data: JSON.stringify(jsonData2),
	// contentType: "application/json; charset=utf-8",
	// crossDomain: true,
	// dataType: "json",
	// success: function (data) {
	// //alert(data);
	// localStorage.setItem("mname", data["middle_name"]);
	// localStorage.setItem("gender", data["gender"]);
	// localStorage.setItem("email", data["email_id"]);
	// localStorage.setItem("dob", data["dob"]);
	// window.location="http://localhost:8080/finalproject/finalpage.html";
	// },
	// error: function()
	// {
	// alert("error");
	// }
	// });
}
