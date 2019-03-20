<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
<script src="https://ajax.googleapis.com/ajax/libs/dojo/1.6.0/dojo/dojo.xd.js"></script>

<title>SPR-9244</title>
</head>
<body>

  <div id="results"></div>

<script>

  function append(object) {

    $("#results").append(JSON.stringify(object) + "<br>");

    var encodedParams = jQuery.param(object);
    // $("#results").append(encodedParams + "<br>");
    $("#results").append("jQuery: " + decodeURIComponent(encodedParams) + "<br>");
    
    encodedParams = dojo.objectToQuery(object);
    // $("#results").append(encodedParams + "<br>");
    $("#results").append("Dojo: " + decodeURIComponent(encodedParams) + "<hr>");
  }

  append({ value1 : 1680, value2 : 1050 });

  append({
    nestedObject : {
      provider : 'facebook',
      user_id : 1256789,
      access_token : 'foo'
    }
  });

  append({
    nestOnce : {
      nestTwice : {
        value1 : 123,
        value2 : 456
      }
    }
  });
  
  append({
    arr : [ 1, 2, 3 ]
  });

  append({
    objArr : [ {
      firstName : "Werner",
      lastName : "Herzog"
    }, {
      firstName : "Wim",
      lastName : "Wenders"
    } ]
  });
 
  append({
    nestedNumArray : {
	  numArr : [ 1, 2, 3 ]
  	},
    nestedMixedArray : {
      numArr : [ 1, 2, { foo : "bar"}, 3, 4 ]
  	}
  });
  
  append({
    '1' : {
      value1 : 123,
      value2 : 456
    },
    '15' : {
      value1 : 123,
      value2 : 456
    }
  });

  append({
    nestedObject : {
      '1' : {
        value1 : 123,
        value2 : 456
      },
      '15' : {
        value1 : 123,
        value2 : 456
      }
    }
  });

  append({
    nestedObject : {b : 1, c : 2},
    nestedMixedArray : [ 3, 4, {e : 5} ]
  });
  
  
</script>

</body>
</html>
