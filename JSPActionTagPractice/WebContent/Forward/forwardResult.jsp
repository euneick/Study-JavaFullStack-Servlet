<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<%
	request.setCharacterEncoding("utf-8");	

	String userID = request.getParameter("user_id");

	if (userID == null || userID.length() == 0) {
	/*
		RequestDispatcher dispatcher = request.getRequestDispatcher("forwardLogin.jsp");
		dispatcher.forward(request, response);
	*/
	%>
		<jsp:forward page="forwardLogin.jsp"></jsp:forward>
	<%	
	}
%>
	<h1>Welcome!! <%=userID%></h1>
</body>

</html>