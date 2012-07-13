<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>HTML5 File Drag &amp; Drop API</title>
<link rel="stylesheet" type="text/css" media="all" href="./css/styles.css" />

</head>
<body>



<h1>Async</h1>

<p>This is a demonstration of the Async.</p>


<div id="messages" class="portlet">
<p>Status Messages</p>

</div>

<div id="portlet2" class="portlet">
<p>Status Messages</p>

</div>

<div id="portlet3" class="portlet">
<p>Status Messages</p>

</div>

</body>


<script src="<c:url value="/wro/yui2.js" />"></script>
<script>
YAHOO.widget.Logger.enableBrowserConsole();
var vcomponentArray = new Array(); // Create an empty array
function createVComp(targetObject){
	this.targetDiv = targetObject;
	solForward(this);
}
function callMe(comp){
	
	var vcomponent = new createVComp(comp);
	
}
function callMe2(){
	var arrayAreas = YAHOO.util.Dom.getElementsByClassName('portlet', 'div');
	for (i=0;i<arrayAreas.length;i++){
		YAHOO.log(arrayAreas[i].id);
		callMe(arrayAreas[i].id);
	}
}

function solForward(vcomponent){
	var width = 400;
	
	var postData = "portalWidth="+width+"&targetDiv="+vcomponent.targetDiv; 
	var sUrl = "<c:url value="getAsync.mvc" />";
	var callback4 =
	{
	  success:function(o){
			
			var messages;
			try{
				messages = YAHOO.lang.JSON.parse(o.responseText);
				YAHOO.log(vcomponent.targetDiv);
				if (messages.processCode=='COMPLETE'){
					document.getElementById(vcomponent.targetDiv).innerHTML=messages.content;
					YAHOO.lang.later(60000,null,callMe,vcomponent.targetDiv);
				}else{
					YAHOO.lang.later(5000,null,callMe,vcomponent.targetDiv);
				}
			}catch(x){
				YAHOO.log("Json Parse Failed");
				
				document.getElementById(vcomponent.targetDiv).innerHTML="Error on Field";
				return;
			}
	  },
	  failure:function(o){
			
		  document.getElementById(vcomponent.targetDiv).innerHTML="Error on Field";
			YAHOO.log("The error handler was called.  tId: " + o.tId + ".", "info", "example");
			<%-- setTimeout(callMe,5000);  --%>
			YAHOO.lang.later(5000,null,callMe,vcomponent.targetDiv);
		},
		timeout: 6000000
	};
	var cObj = YAHOO.util.Connect.asyncRequest('POST', sUrl, callback4,postData);

}


YAHOO.util.Event.onDOMReady(callMe2);
</script>
</html>