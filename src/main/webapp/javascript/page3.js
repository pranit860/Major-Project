function pageexecute() {
    var dataToSend = {};
    dataToSend["adhar"] = document.getElementById("adharvoter").value;
    //alert(dataToSend["voter"]);

    $.ajax({
		type : "POST",
		url : "http://localhost:8080/finalproject/webapi/adharverify",
		data : JSON.stringify(dataToSend),
		contentType : "application/json; charset=utf-8",
		crossDomain : true,
		// datatype:"json",
		success : function(data) {
			//alert(data);
			localStorage.setItem("voterid", data["id_voter"]);
			localStorage.setItem("fname", data["first_name"]);
			localStorage.setItem("lname", data["last_name"]);
			localStorage.setItem("mob", data["contact_no"]);
			localStorage.setItem("adhar", data["id_aadhar"]);
			
			// sessionStorage.get
			window.location="http://localhost:8080/finalproject/postotpverification.html";
		},
		error : function() {
			alert("error");
		}
	});
}