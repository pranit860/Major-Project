
function pageload(url)
{
	alert("INSIDE Pageload");
	window.location=url;
	return true;
}
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
	    dataType: "json",
	    data: JSON.stringify(dataToSend),
	    contentType: "application/json; charset=utf-8",
        crossDomain: true,
        //async: true,
	   success: function (data) { 
		   		//alert(data["id_constituency"]);
              if(data["id_constituency"]===0)
              {
            	  alert("Id Password Doesnt Match!!!");
                    location.assign("http://localhost:8080/finalproject/index.html");

              }   
              else{
                    alert("INSIDE Else");
                  
            	  
              }

	   },
		error: function()
		{
			alert("error");
		}
	  });
      pageload("http://localhost:8080/finalproject/project.html");
      return true;
}