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

function Verify(iso) {
	try {
		//var isotemplate = document.getElementById('txtIsoTemplate').value;
		var isotemplate2 = "Rk1SACAyMAAAAADYAAABPAFiAMUAxQEAAAAoH0CcAPvOZICAAQfCV4BzAQFwV0BcANcBZIB3ATmgZEDrALfdZEDDAUS4ZEDXATy/ZIA3ATMSZEDrAHjwZEDNAEP6ZECDAPXbV4C+AOfXZIBrAPXlV0CyAKHyZICgAT+zZICLAUutQ0D8ANnUZEAuARuUZEAlALMPL0EcALrcUICvAPTTZICGAML1ZEClALftZIBcAR+UZEBdATiXZIB9AUmgNUD8AM1cZEDCAHX4ZEASAOkoXYCbAEmJXQAA";
		var res = VerifyFinger(isotemplate2, iso);

		if (res.httpStaus) {
			if (res.data.Status) {
				
				//alert("Finger matched");
				return true;
			} else {
				if (res.data.ErrorCode != "0") {
					alert(res.data.ErrorDescription);
				} else {
					//alert("Finger not matched");
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

function match()
{
    var quality = 60;
	var time = 20;
	var res = CaptureFinger(quality, time);
	
	if (res.httpStaus != null) {
		// alert("Successfully!!!");
		if (res.data.ErrorCode == "0") {

			console.log(res);
			document.getElementById('imgFinger').src = "data:image/bmp;base64,"+ res.data.BitmapData;
            var iso = res.data.IsoTemplate;
            
            if(Verify(iso))
            {
                alert("Fingerprint Matched Successfully");

            }
            else{
                alert("Fingetprint Doesnot Match!!!!");
            }
        }
    }
}
