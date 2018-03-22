var btn=document.querySelector('#verify1');
btn.addEventListener('click',execute);
if(!localstorsge.getItem("username"))
	{
	alert("Perform Booth Login First!!");
	window.location="http://localhost:8080/finalproject/page1.html";
	}
function execute() {
	var dataToSend = {};
	dataToSend["otp"] = document.getElementById("otp").value;
	dataToSend["bid"]=localStorage.getItem("b_id");
	//alert(localStorage.getItem("b_id"));	
	
	if(dataToSend["otp"].length==6){
	var url="http://localhost:8080/finalproject/webapi/otpverify";
	fetch(url, {
		  method: 'POST', // or 'PUT'
		  body: JSON.stringify(dataToSend), 
		  headers: new Headers({
		    'Content-Type': 'application/json'
		  })
		}).then(res => res.json())
		.then(successGot)
		.catch(error => console.error('Error:', error));
	}
	else
	{
		alert("Enter otp of format ###### ");
	}
}

function successGot(data){
	if(data["id_voter"]!="-1" || data["id_voter"]!="0"){
	localStorage.setItem("voterid", data["id_voter"]);
	localStorage.setItem("fname", data["first_name"]);
	localStorage.setItem("lname", data["last_name"]);
	localStorage.setItem("mob", data["contact_no"]);
	localStorage.setItem("adhar", data["id_aadhar"]);
	
	window.location="http://localhost:8080/finalproject/postotpverification.html";
	}
	if(data["id_voter"]=="0"){
		alert("You Have Already Voted!!");
		window.location="http://localhost:8080/finalproject/page2.html";
	}
	if(data["id_voter"]=="-1")
		{
			alert("You Are at Wrong Booth");
			window.location="http://localhost:8080/finalproject/project.html";
		}
}