<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("UTF-8");
%>

<%--
	<c:redirect>
	 - response.sendRedirect() 메소드를 대체하는 코어태그
--%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<c:redirect url="member.jsp">
		<c:param name="id" value="${'gyeon'}" />
		<c:param name="pwd" value="${'6666'}" />
		<c:param name="name" value="${'견훤'}" />
		<c:param name="age" value="${24}" />
		<c:param name="address" value="${'후백제'}" />
	</c:redirect>
</body>

</html>