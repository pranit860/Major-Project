function successGot(data)
{
	 if(data["id_constituency"]===0)
     {
   	  alert("Id Password Doesnt Match!!!");
   	  window.location="http://localhost:8080/finalproject/index.html";

     }   
     else{
           //alert("INSIDE Else");
           localStorage.setItem("b_id",data["id_booth"]);
           //alert(data["id_booth"]);
           window.location="http://localhost:8080/finalproject/project.html";
           //$('#mainarea').load("http://localhost:8080/finalproject/project.html");
     }
}
function failureGot()
{
	alert("error");
}


if(localStorage.getItem("username"))
{
	 window.location="http://localhost:8080/finalproject/project.html";
}
var btn=document.querySelector('#btn');
btn.addEventListener('click',checkLogin)

function checkLogin()
{
	var id=document.querySelector('#userid').value;
	var pass=document.querySelector('#pass').value;
	//console.log(id+" "+pass);
	
	if(id.length<12 && pass=="")
		{
			alert("Enter Proper User Id and password!!!");
			document.location.reload(true);
			//break;
		}
	else{
	console.log(id,pass);
	 if (typeof (Storage) !== "undefined") {
       localStorage.setItem("username",id);
     }
     else {
       alert("Browser Doesnt support web storage");
     }
	 alert(localStorage.getItem("username"));
	var data={};
	data["userId"]=id;
	data["password"]=pass;
	var url="http://localhost:8080/finalproject/webapi/userverify";
	fetch(url, {
		  method: 'POST', // or 'PUT'
		  body: JSON.stringify(data), 
		  headers: new Headers({
		    'Content-Type': 'application/json'
		  })
		}).then(res => res.json())
		.then(successGot)
		.catch(error => console.error('Error:', error));
	}
		
}
