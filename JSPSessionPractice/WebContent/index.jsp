<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>Welcome to my home page main</h1>
<%
	String newID = (String) session.getAttribute("id");

	if (newID != null) {
%>
		<%=newID%> 로그인 중 &nbsp;&nbsp;
		<a href="logout.jsp">로그아웃</a>
		<a href="shop.jsp">쇼핑몰</a>
<%
	}
	else {
%>
		<a href="login.jsp">로그인</a>
		<a href="shop.jsp">쇼핑몰</a>
<%
	}
%>
</body>

</html>