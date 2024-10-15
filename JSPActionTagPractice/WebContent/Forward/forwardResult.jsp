<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String message = "아이디를 입력하지 않았습니다. <br> 아이디를 입력해 주세요.";
%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<%
	String userID = request.getParameter("user_id");

	if (userID == null || userID.length() == 0) {
	/*
		RequestDispatcher dispatcher = request.getRequestDispatcher("forwardLogin.jsp");
		dispatcher.forward(request, response);
	*/
	%>
		<jsp:forward page="forwardLogin.jsp">
			<jsp:param value="<%=message%>" name="message"/>
		</jsp:forward>
	<%	
	}
%>
	<h1>Welcome!! <%=userID%></h1>
</body>

</html>