document.getElementById("para1").innerHTML=localStorage.getItem("voterid");
document.getElementById("para2").innerHTML=localStorage.getItem("fname");
document.getElementById("para3").innerHTML=localStorage.getItem("lname");
document.getElementById("para8").innerHTML=localStorage.getItem("mname");
document.getElementById("para4").innerHTML=localStorage.getItem("gender");
document.getElementById("para5").innerHTML=localStorage.getItem("email");
document.getElementById("para6").innerHTML=localStorage.getItem("dob");
document.getElementById("para7").innerHTML=localStorage.getItem("mob");

function execute()
{
	localStorage.setItem("voterid","");
	localStorage.setItem("fname","");
	localStorage.setItem("lname","");
	localStorage.setItem("mname","");
	localStorage.setItem("gender","");
	localStorage.setItem("email","");
	localStorage.setItem("dob","");
	localStorage.setItem("mob","");
	localStorage.setItem("adhar","");
	
	$.ajax({
	    type: "POST",
	    url: "http://localhost:8080/finalproject/webapi/logstatus",
	    dataType: "json",
	    data: JSON.stringify(dataToSend),
	    contentType: "application/json; charset=utf-8",
        crossDomain: true,
        async: true,
	   success: function (data) { 

	   },
		error: function()
		{
			alert("error");
		},
		complete: function()
		{
			window.location="project.html";
		}
	  });
}