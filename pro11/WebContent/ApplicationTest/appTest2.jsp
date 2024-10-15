<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		session 객체			같은 브라우저에서 공유
		application 객체		같은 어플리케이션에서 공유
	*/
	String name = (String) session.getAttribute("name");
	String address = (String) application.getAttribute("address");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>이름 : <%=name%></h1>
	<h1>주소 : <%=address%></h1>
</body>

</html>