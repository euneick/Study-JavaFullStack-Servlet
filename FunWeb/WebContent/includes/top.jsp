<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<header>
		<div id="login">
			<a href="<%=contextPath%>/member/login.jsp">login</a> |
			<a href="<%=contextPath%>/member/join.jsp">join</a>
		</div>
		<div class="clear"></div>

		<div id="logo">
			<img src="<%=contextPath%>/images/logo.gif" width="265" height="62" alt="Fun Web">
		</div>

		<nav id="top_menu">
			<ul>
				<li><a href="<%=contextPath%>/index.jsp">HOME</a></li>
				<li><a href="<%=contextPath%>/company/welcome.jsp">COMPANY</a></li>
				<li><a href="#">SOLUTIONS</a></li>
				<li><a href="<%=contextPath%>/center/notice.jsp">CUSTOMER CENTER</a></li>
				<li><a href="#">CONTACT US</a></li>
			</ul>
		</nav>
	</header>
</body>

</html>