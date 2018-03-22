function pageexecute() {
    var dataToSend = {};
    dataToSend["adhar"] = document.getElementById("adharvoter").value;
    dataToSend["b_id"]=localStorage.getItem("b_id");
    //alert(dataToSend["voter"]);
//    $.ajax({
//		type : "POST",
//		url : "http://localhost:8080/finalproject/webapi/adharverify",
//		data : JSON.stringify(dataToSend),
//		contentType : "application/json; charset=utf-8",
//		crossDomain : true,
//		// datatype:"json",
//		success : function(data) {
//			//alert(data);
//			localStorage.setItem("voterid", data["id_voter"]);
//			localStorage.setItem("fname", data["first_name"]);
//			localStorage.setItem("lname", data["last_name"]);
//			localStorage.setItem("mob", data["contact_no"]);
//			localStorage.setItem("adhar", data["id_aadhar"]);
//			window.location="http://localhost:8080/finalproject/postotpverification.html";
//		},
//		error : function() {
//			alert("error");
//		}
//	});
//    
//    
    
    
    if(dataToSend["adhar"].length==10 || dataToSend["adhar"].length==12 ){
    var url="http://localhost:8080/finalproject/webapi/adharverify";
	fetch(url, {
		  method: 'POST', // or 'PUT'
		  body: JSON.stringify(dataToSend), 
		  headers: new Headers({
		    'Content-Type': 'application/json'
		  })
		}).then(res => res.json())
		.then(function(data) {
			//alert(data);
			localStorage.setItem("voterid", data["id_voter"]);
			localStorage.setItem("fname", data["first_name"]);
			localStorage.setItem("lname", data["last_name"]);
			localStorage.setItem("mob", data["contact_no"]);
			localStorage.setItem("adhar", data["id_aadhar"]);
			window.location="http://localhost:8080/finalproject/postotpverification.html";
		})
		.catch(error => console.error('Error:', error));
    }
    else{
    	alert("Enter Valid AdharId or VoterID");
    }
}