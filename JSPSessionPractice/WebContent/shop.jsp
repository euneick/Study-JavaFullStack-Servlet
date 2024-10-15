<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>Welcome to shop</h1>
<%
	String id = (String) session.getAttribute("id");

	if ("master".equals(id)) {
	%>
		<%=id%> 로그인 중 &nbsp;&nbsp;
		<a href="logout.jsp">로그아웃</a>
		<a href="index.jsp">메인화면</a>
	<%
	}
	else {
	%>
		<script type="text/javascript">
			window.alert("로그인이 필요합니다.");
			
			location.href = "login.jsp";
		</script>
	<%
	}
%>
</body>

</html>