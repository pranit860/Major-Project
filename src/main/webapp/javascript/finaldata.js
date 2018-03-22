	//alert("inside Document ready");
	document.getElementById("para1").innerHTML=localStorage.getItem("voterid");
	document.getElementById("para2").innerHTML=localStorage.getItem("fname");
	document.getElementById("para3").innerHTML=localStorage.getItem("lname");
	document.getElementById("para8").innerHTML=localStorage.getItem("mname");
	document.getElementById("para4").innerHTML=localStorage.getItem("gender");
	document.getElementById("para5").innerHTML=localStorage.getItem("email");
	document.getElementById("para6").innerHTML=localStorage.getItem("dob");
	document.getElementById("para7").innerHTML=localStorage.getItem("mob");
	
//	 $("button").click(function(){
//		 alert("inside onclick");
//		 var dataToSend={};
//			dataToSend["adhar"]=localStorage.getItem("adhar");
//			localStorage.setItem("voterid","");
//			localStorage.setItem("fname","");
//			localStorage.setItem("lname","");
//			localStorage.setItem("mname","");
//			localStorage.setItem("gender","");
//			localStorage.setItem("email","");
//			localStorage.setItem("dob","");
//			localStorage.setItem("mob","");
//			localStorage.setItem("adhar","");
//			
//			
//			$.ajax({
//			    type: "POST",
//			    url: "http://localhost:8080/finalproject/webapi/logstatus",
//			    data: JSON.stringify(dataToSend),
//			    contentType: "application/json; charset=utf-8",
//		        crossDomain: true,
//		        async: true,
//			   success: function (data) { 
//				   	window.location="http://localhost:8080/finalproject/project.html";
//			   },
//				error: function()
//				{
//					alert("error");
//				}
//			  });
//	    });


var btn=document.querySelector('#btn1');
btn.addEventListener('click',execute);

function execute()
{
	//alert("Inside Execute!!!");
	 var dataToSend={};
	dataToSend["adhar"]=localStorage.getItem("adhar");
	alert(dataToSend["adhar"]);
	localStorage.removeItem("voterid");
	localStorage.removeItem("fname");
	localStorage.removeItem("lname");
	localStorage.removeItem("mname");
	localStorage.removeItem("gender");
	localStorage.removeItem("email");
	localStorage.removeItem("dob");
	localStorage.removeItem("mob");
	localStorage.removeItem("adhar");
	//console.log(localStorage.getItem("adhar"));
	
	
	var url="http://localhost:8080/finalproject/webapi/logstatus";
	fetch(url, {
		  method: 'POST', // or 'PUT'
		  body: JSON.stringify(dataToSend), 
		  headers: new Headers({
		    'Content-Type': 'application/json'
		  })
		}).then(res => res.json())
		.then(function(data){
			console.log(data);
			window.location="http://localhost:8080/finalproject/project.html";
		})
		.catch(error => console.error('Error:', error));
}
