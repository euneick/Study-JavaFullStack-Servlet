<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("UTF-8");
%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:url var="memberURL" value="member.jsp">
	<c:param name="id" value="wang" />
	<c:param name="pwd" value="4444" />
	<c:param name="name" value="왕건" />
	<c:param name="age" value="${22}" />
	<c:param name="address" value="고려" />
</c:url>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<a href="${memberURL}">회원정보 출력</a>
</body>

</html>