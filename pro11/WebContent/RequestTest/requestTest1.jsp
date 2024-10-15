<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		session 객체			같은 브라우저에서 공유
		application 객체		같은 어플리케이션에서 공유
		requset 객체			같은 요청을 공유 (Dispatcher 방식으로 포워딩 시)
	*/
	request.setAttribute("name", "이순신");
	request.setAttribute("address", "부산시 부산진구");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<%
	RequestDispatcher dispatcher = request.getRequestDispatcher("requestTest2.jsp");
	dispatcher.forward(request, response);
%>
</body>

</html>