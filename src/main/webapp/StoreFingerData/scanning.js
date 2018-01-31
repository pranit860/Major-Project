var check = GetMFS100Info();
var finger1 = null;
var finger2 = null;
var finger3 = null;
//alert("No Scanner");
if (check.httpStaus) {
	if (check.data.ErrorCode == "0") {
		alert("Scanner Connected  " + check.data.DeviceInfo.SerialNo);
	}
	else {
		alert("ERROR!!!!!  " + check.err);
	}
}
else {
	alert("No Scanner");
}

function clicked1() {
	alert("onclick");
	var quality = 60;
	var time = 20;
	var res = CaptureFinger(quality, time);
	var jsonData2 = {};
	//var jsonData1=null;
	if (res.httpStaus != null) {
		//alert("Successfully!!!");
		if (res.data.ErrorCode == "0") {
			document.getElementById("i").innerHTML = "Finger Prnt Scanned Successfully!!!";
			console.log(res);
			document.getElementById('imgFinger1').src = "data:image/bmp;base64," + res.data.BitmapData;
			finger1=res.data.IsoTemplate;
		}
		else {
			document.getElementById("i").innerHTML = "ERROR!!!!";
		}
	}
	else {
		alert("ERROR");
	}

}
function clicked2() {
	alert("onclick");
	var quality = 60;
	var time = 20;
	var res = CaptureFinger(quality, time);
	
	//var jsonData1=null;
	if (res.httpStaus != null) {
		//alert("Successfully!!!");
		if (res.data.ErrorCode == "0") {
			document.getElementById("i").innerHTML = "Finger Prnt Scanned Successfully!!!";
			console.log(res);
			document.getElementById('imgFinger2').src = "data:image/bmp;base64," + res.data.BitmapData;
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
function clicked3() {
	alert("onclick");
	var quality = 60;
	var time = 20;
	var res = CaptureFinger(quality, time);
	
	if (res.httpStaus != null) {
		//alert("Successfully!!!");
		if (res.data.ErrorCode == "0") {
			document.getElementById("i").innerHTML = "Finger Prnt Scanned Successfully!!!";
			console.log(res);
			document.getElementById('imgFinger3').src = "data:image/bmp;base64," + res.data.BitmapData;
			finger3=res.data.IsoTemplate;
		}
		else {
			document.getElementById("i").innerHTML = "ERROR!!!!";
		}
	}
	else {
		alert("ERROR");
	}

}
function savedata() {
	var jsonData2={};
	if (finger1 !== null && finger2 !== null && finger3 !== null) {
		jsonData2["finger1"]=finger1;
		jsonData2["finger2"]=finger2;
		jsonData2["finger3"]=finger3;
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/finalproject/webapi/fingerdata",
			data: JSON.stringify(jsonData2),
			contentType: "application/json; charset=utf-8",
			crossDomain: true,
			dataType: "json",
			success: function (data) {
				alert(data);
			},
			error: function () {
				alert("error");
			}
		});
	}
	else
	{
		alert("Scan All 3 Fingers Please!!!");
	}
}