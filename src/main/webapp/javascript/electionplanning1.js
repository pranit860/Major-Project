function execute()
{
var assemblyconst=document.getElementById("assembly");
	var assemblyval= assemblyconst.options[assemblyconst.selectedIndex].value;
	 console.log("Selected Item " + assemblyval);
	 //alert("abc");
	 if(assemblyval==null)
		 alert("Select the proper assembly!!!");
	 else{
		var dataToSend={};
		dataToSend["id_assembly"]=assemblyval;
		console.log(dataToSend);
		//alert("abc");
		$(document).ready(function() {
			alert("inside click");
			$.ajax({
			    
				type: "POST",
			    url: "http://localhost:8080/finalproject/webapi/genotp",
			    //dataType: "json",
			    data:JSON.stringify(dataToSend), 
			    contentType: "application/json; charset=utf-8",
		        crossDomain: true,
		        async:false,
		        beforeSend: function() {
	                alert("above success");
		        }, 
				success: function (data) {     
		              if(data=="Success")
		              {
						   alert("OTP generated succesfully");
		              }   
		              else{
		                    alert("not generated");
		                   
		              }

			   },
				error: function()
				{
					alert("error");
				}
			  });
			
		
      
	});
	 }
}



function execute1()
{
var assemblyconst=document.getElementById("assembly");
	var assemblyval= assemblyconst.options[assemblyconst.selectedIndex].value;
	 console.log("Selected Item " + assemblyval);
	 //alert("abc");
	 if(assemblyval==null)
		 alert("Select the proper assembly!!!");
	 else{
		var dataToSend={};
		dataToSend["id_assembly"]=assemblyval;
		console.log(dataToSend);
		//alert("abc");
		$(document).ready(function() {
			alert("inside click");
			$.ajax({
			    
				type: "POST",
			    url: "http://localhost:8080/finalproject/webapi/sendsms",
			    //dataType: "json",
			    data:JSON.stringify(dataToSend), 
			    contentType: "application/json; charset=utf-8",
		        crossDomain: true,
		        async:false,
		        beforeSend: function() {
	                alert("above success");
		        }, 
				success: function (data) {     
		              if(data=="Success")
		              {
						   alert("Message sent succesfully");
		              }   
		              else{
		                    alert("not sent");
		                   
		              }

			   },
				error: function()
				{
					alert("error");
				}
			  });
			
		
      
	});
}
}