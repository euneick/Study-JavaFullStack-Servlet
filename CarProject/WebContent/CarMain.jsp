<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	request.setCharacterEncoding("UTF-8");
%>

<c:set var="center" value="${requestScope.center}"/>

<%-- 맨 처음 CarMain.jsp를 요청 했을 경우 --%>
<c:if test="${center == null}">
	<c:set var="center" value="Center.jsp"/>
</c:if>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<center>
		<table width="1000" height="700">
			<tr>
				<td><jsp:include page="Top.jsp"/></td>
			</tr>
			<tr>
				<td height="500"><jsp:include page="${center}"/></td>
			</tr>
			<tr>
				<td><jsp:include page="Bottom.jsp"/></td>
			</tr>
		</table>
	</center>
</body>

</html>