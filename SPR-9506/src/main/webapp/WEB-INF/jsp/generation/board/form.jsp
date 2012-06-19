<%@ page language="java" errorPage="/sample/common/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/sample/common/top.jsp"%>
		
    </div>
    <hr />
<script type="text/javascript" src="<c:url value='/sample/javascript/InputCalendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/sample/javascript/CommonScript.js'/>"></script>   
<script type="text/javascript">
	function fncCreateBoard() {		    		    
        document.boardForm.action="<c:url value='/board.do?method=create'/>";
        document.boardForm.submit();
	}
	
	function fncUpdateBoard() {	    
        document.boardForm.action="<c:url value='/board.do?method=update'/>";
        document.boardForm.submit();
	}
	
	function fncRemoveBoard(){	
		if(confirmDelete('board')) {
		    document.boardForm.action="<c:url value='/board.do?method=remove'/>";
		    document.boardForm.submit();
		}	    
	}
</script>      
<!--************************** begin of contents *****************************-->
    <div id="container">

    	<div class="cont_top">
        	<h2>
				 	<c:if test="${empty board.map.postId}">
				 	Add Board Information
				 	<c:set var="readonly" value="false"/>
					</c:if>
			
				    <c:if test="${not empty board.map.postId}">	
					Update Board Information
					<c:set var="readonly" value="true"/>				 
					</c:if>					 				 
			</h2>
        </div>
        <div class="view">							
		<form:form modelAttribute="board" method="post" action="board.do" id="boardForm" name="boardForm">
	 	<table summary="This table shows detail information about the board">
    	<caption>Detail information</caption>
        <colgroup>
        	<col style="width:20%;" />
            <col style="width:80%;" />
        </colgroup>
        <tbody>
   		<tr>
        	<th><label for="postId"><spring:message code="board.postId" />&nbsp;*</label></th>
            <td><form:input path="map[postId]" id="postId" cssClass="w_normal" readonly="${readonly}"/><form:errors path="map[postId]" cssClass="errors" /></td>
        </tr>
    	<tr>
        	<th><label for="contents"><spring:message code="board.contents" /></label></th>
            <td>
		        <form:input path="map[contents]" id="contents" cssClass="w_normal"  maxlength="255"/>
		        <form:errors path="map[contents]" cssClass="errors" />
	        </td>
        </tr>         
    	<tr>
        	<th><label for="regDate"><spring:message code="board.regDate" /></label></th>
            <td>
		        <form:input path="map[regDate]" id="regDate" cssClass="w_normal"  maxlength="10"/>
		        <form:errors path="map[regDate]" cssClass="errors" />
	        </td>
        </tr>         
    	<tr>
        	<th><label for="regId"><spring:message code="board.regId" /></label></th>
            <td>
		        <form:input path="map[regId]" id="regId" cssClass="w_normal"  maxlength="50"/>
		        <form:errors path="map[regId]" cssClass="errors" />
	        </td>
        </tr>         
    	<tr>
        	<th><label for="title"><spring:message code="board.title" />&nbsp;*</label></th>
            <td>
		        <form:input path="map[title]" id="title" cssClass="w_normal"  maxlength="50"/>
		        <form:errors path="map[title]" cssClass="errors" />
	        </td>
        </tr>         
	</tbody>
    </table>
	<input type="hidden" name="rootPath" value="<c:url value='/'/>"/>	
</form:form>
</div>

<!--************************** begin of buttons *****************************-->
        <div class="btncontainer_center">
	    <a href="<c:url value='/board.do?method=list'/>">
	    <span class="button default icon">
	        <span class="list">&nbsp;</span>
	        <span class="none_a txt_num4"><spring:message code="movie.button.list" /></span>
	    </span>
	    </a>         
    	</div>
	</div>
    <hr />
<%@ include file="/sample/common/bottom.jsp"%>