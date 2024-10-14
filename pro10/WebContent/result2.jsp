<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");

	String userId = request.getParameter("user_id");
	String userPw = request.getParameter("user_pw");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<!-- Scriptlet을 여러문단으로 나누어 html코드와 java코드를 섞어 사용 할 수 있음 -->
	<%
		if (userId == null || userId.length() == 0) {
	%>
	아이디를 입력하세요.<br>
	<a href="login.html">로그인하기</a>
	<%
		}
		else {
	%>
	<h1>환영합니다. <%=userId%> 님!</h1>
	<%
		}
	%>
</body>

</html>