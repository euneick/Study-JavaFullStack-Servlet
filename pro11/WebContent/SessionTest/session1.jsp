<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String) session.getAttribute("name");	// 내장객체 session에 name으로 바인딩 된 값 얻기
	session.setAttribute("address", "부산시 부산진구");			// 내장객체 session에 address로 값 바인딩 하기
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Session 내장 객체 테스트</title>
</head>

<body>
	이름은 <%=name%>입니다. <br>
	<a href="session2.jsp">두 번째 페이지로 이동</a>
</body>

</html>