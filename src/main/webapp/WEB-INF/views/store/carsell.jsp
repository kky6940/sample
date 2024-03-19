<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="p" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>placesellout.jsp</title>
</head>
<body>
<form action="carsell"  method="post">
	<select name="cname" onchange="this.form.submit()">
		<option value="">차량명</option>
		<option value="세단">세단</option>
		<option value="트럭">트럭</option>
		<option value="SUV">SUV</option>
		<option value="벤">벤</option>
	</select>
</form>

<table border="1" width="500px" align="center">
	
	<caption>상점자료출력</caption>
	<tr>
		<th>차량명</th>
		<th>판매액</th>
	</tr>
	<c:forEach items="${list }" var="aa">
		<tr>
			<td>${aa.carname }</td>
			<td><p:formatNumber value="${aa.totprice }" pattern="#,###"></p:formatNumber> </td>
		</tr>
	</c:forEach>
	<!-- 페이징처리 -->
	<tr style="border-left: none;border-right: none;border-bottom: none">
	   <td colspan="6" style="text-align: center;">
	   
	   <c:if test="${paging.startPage!=1 }"> <!-- 현재 페이지가 1페이지가 아니라면 -->
	      <a href="page?nowPage=${paging.startPage-1 }&cntPerPage=${paging.cntPerPage}">◀</a> <!--"page?nowPage=${paging.startPage-1 } = 시작 페이지에서 -1 빼서 넘김 -->
	      
	   </c:if>   
	   
	      <c:forEach begin="${paging.startPage }" end="${paging.endPage}" var="p"> 
	         <c:choose>
	            <c:when test="${p == paging.nowPage }"> <!-- 현재 페이지를 빨갛게 표시 -->
	               <b><span style="color: red;">${p}</span></b>
	            </c:when>   
	            <c:when test="${p != paging.nowPage }"> <!-- 현재 페이지가 아니면 페이지 정보를 넘김 -->
	               <a href="page?nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p}</a>
	            </c:when>   
	         </c:choose>
	      </c:forEach>
	     
	      <c:if test="${paging.endPage != paging.lastPage}">
	      <a href="page?nowPage=${paging.endPage+1}&cntPerPage=${paging.cntPerPage }">▶</a>
	   </c:if>
	   
	   </td>
	</tr>
<!-- 페이징처리 -->
</table>
</body>
</html>