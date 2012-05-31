<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
  src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
<title>SPR-9244</title>
</head>
<body>

  <div id="results"></div>

<script>
  function append(params) {
    var encodedParams = jQuery.param(params);
    
    $("#results").append(JSON.stringify(params) + "<br>");
    $("#results").append(encodedParams + "<br>");
    $("#results").append(decodeURIComponent(encodedParams) + "<hr>");
  }

  append({ value1 : 1680, value2 : 1050 });

  append({
    numArr : [ 1, 2, 3 ]
  });

  append({
    objArr : [ {
      name : "o1",
      value : "v1"
    }, {
      name : "o2",
      value : "v2"
    } ]
  });

  append({
    nestedObj : {
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
    nested : {
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
    a : {
      b : 1,
      c : 2
    },
    d : [ 3, 4, {e : 5} ]
  });
  
  
</script>

</body>
</html>
