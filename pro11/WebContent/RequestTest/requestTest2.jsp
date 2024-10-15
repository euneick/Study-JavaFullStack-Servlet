<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		session 객체			같은 브라우저에서 공유
		application 객체		같은 어플리케이션에서 공유
		requset 객체			같은 요청을 공유 (Dispatcher 방식으로 포워딩 시)
	*/
	String name = (String) request.getAttribute("name");
	String address = (String) request.getAttribute("address");
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