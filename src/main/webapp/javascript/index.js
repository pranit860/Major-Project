
function execute()
{
    var dataToSend={};
    dataToSend["userId"]=document.getElementById("userid").value;
    dataToSend["password"]=document.getElementById("pass").value;
    if (typeof (Storage) !== "undefined") {
        var str=document.getElementById("userid").value;
        sessionStorage.setItem("username",str);
      }
      else {
        alert("Browser Doesnt support web storage");
      }
      $.ajax({
	    type: "POST",
	    url: "http://localhost:8080/finalproject/webapi/userverify",
	    data: JSON.stringify(dataToSend),
	    contentType: "application/json",
        crossDomain: true,
	   success: function (data) { 
		   		
              if(data["id_constituency"]==0)
              {
            	  alert("Id Password Doesnt Match!!!");
                    window.location="http://localhost:8080/finalproject/index.html";
              }   
              else{
                    
            	  window.location="http://localhost:8080/finalproject/project.html";
              }

	   },
		error: function()
		{
			alert("error");
		}
	  });
}