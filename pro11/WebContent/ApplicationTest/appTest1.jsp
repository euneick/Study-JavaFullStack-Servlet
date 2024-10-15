<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		session 객체			같은 브라우저에서 공유
		application 객체		같은 어플리케이션에서 공유
	*/
	session.setAttribute("name", "이순신");
	application.setAttribute("address", "부산시 부산진구");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>이름과 주소를 저장합니다.</h1>
	<a href="appTest2.jsp">두 번재 웹 페이지로 이동</a>
</body>

</html>