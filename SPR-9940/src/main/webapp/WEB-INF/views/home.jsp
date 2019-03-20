<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
  <h1>Home</h1>
  
  <form id="saveForm" action="url" method="post">
  	<button type="submit" name="save">Save</button>
  	<p></p>
  </form>

<script type="text/javascript" src="https://code.jquery.com/jquery-1.8.2.js"></script>
<script type="text/javascript">
$(document).ready(function() {
  
	$("#saveForm").submit(function() {
		var form = $(this);
		$.ajax({ type: "POST", url: 'url',
		  
		  contentType: "application/json",
 		  data : '{ "name" : "Joe" }',

//        contentType: "application/x-www-form-urlencoded",
//        data : 'foo=bar&fruit=apple',

          dataType: "text", 
		  success: function(text) { 
		    $("p").replaceWith('<p>' + text + '</p>');
		  },
		  error: function(xhr) {
		    $("p").replaceWith('<p>' + xhr.responseText + '</p>');
		  }
		});
		return false;
	});
  
  
});
</script>

</body>
</html>
