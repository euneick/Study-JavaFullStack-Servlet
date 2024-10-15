<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>

<body>
<%
	String message = request.getParameter("message");

	if (message != null) {
	%>
		<h3><%=message%></h1>
	<%
	}
%>	
	<form action="forwardResult.jsp" method="post">
		아이디 : <input type="text" name="user_id"><br>
		비밀번호 : <input type="password" name="user_pw"><br>
		<input type="submit" value="로그인">
		<input type="reset" value="다시입력">
	</form>
</body>

</html>