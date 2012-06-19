<%@ page language="java" errorPage="/sample/common/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ include file="/sample/common/top.jsp"%>
		
    </div>
    <hr />    
<script type="text/javascript" src="<c:url value='/sample/javascript/CommonScript.js'/>"></script>    
<script type="text/javascript">
	function fncCreateBoardView() {
		document.location.href="<c:url value='/board.do?method=createView'/>";
	}	
	function fncSearchBoard() {
	   	document.searchForm.action="<c:url value='/board.do?method=list'/>";
	   	document.searchForm.submit();						
	}			
</script>
  	<div id="container">
<!--************************** begin of contents *****************************-->
<form:form modelAttribute="search" method="post" name="searchForm">
    	<div class="cont_top">
        	<h2><spring:message code='boardList.title'/></h2>
      		<div class="search_list">
                <fieldset>
                    <legend>Search</legend>
                    <label for="searchCondition" class="float_left margin_right5">
					<form:select path="map['searchCondition']" id="searchCondition" cssClass="w_search">
						<form:option value="All">ALL</form:option>
              <form:option value="postId"><spring:message code="board.postId"/></form:option>     
              <form:option value="title"><spring:message code="board.title"/></form:option>
					</form:select>
					</label>
                    <label for="searchKeyword" class="float_left margin_right5">
                    	<form:input path="map['searchKeyword']" id="searchKeyword" cssClass="w_search" cssErrorClass="text medium error" maxlength="255"/></label>
                    <label for="btnSearch" class="float_left">
                    	<input type="image" id="btnSearch" name="searchBtn" alt="Search" onclick="javascript:fncSearchBoard();" src="<c:url value='/sample/images/btn_search_i.gif'/>"/>
                    </label>
                </fieldset>
            </div>
      	</div>
        <div class="list">
      		<table summary="This is list of <spring:message code="boardList.board"/>">
            	<caption><spring:message code="boardList.title"/></caption>
                <colgroup>
			<col style="width:15%;" />
			<col style="width:15%;" />
			<col style="width:15%;" />
			<col style="width:15%;" />
			<col style="width:15%;" />
                </colgroup>
                <thead>
                    <tr>



			<th><spring:message code="board.postId" /></th>
			<th><spring:message code="board.contents" /></th>
			<th><spring:message code="board.regDate" /></th>
			<th><spring:message code="board.regId" /></th>
			<th><spring:message code="board.title" /></th>
		</tr>
	</thead>		
	<tbody>
		<c:forEach var="board" items="${boardList}">
		<tr>			
		
          <td><a href="${ctx}/board.do?method=get&amp;map[postId]=${board.postId}">${board.postId}</a></td>
			<td>${board.contents}</td>
			<td>${board.regDate}</td>
			<td>${board.regId}</td>
			<td>${board.title}</td>
			</tr>
		</c:forEach>
	</tbody>
  </table>
</div>
        
<!--************************** begin of paging navigation/buttons *****************************-->     
        <div class="listunder_container">           
            
            <div class="list_underbtn_right">
                <a href="javascript:fncCreateBoardView();">
                <span class="button default icon">   
                    <span class="add">&nbsp;</span>
                    <span class="none_a txt_num3"><spring:message code="movie.button.add" /></span>
                </span>
                </a>                
            </div>            
        </div>
        </form:form>
	</div>
    <hr />
<%@ include file="/sample/common/bottom.jsp"%>
