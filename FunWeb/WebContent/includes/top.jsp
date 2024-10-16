<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// index.jsp와 그 외 페이지의 경로가 달라 생기는 문제에 대응
	String contextPath = request.getContextPath();

	String id = (String) session.getAttribute("id");
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
		<%
			if (id == null || id.length() == 0) {
			%>
				<a href="<%=contextPath%>/member/login.jsp">login</a> |
				<a href="<%=contextPath%>/member/join.jsp">join</a>
			<%				
			}
			else {
			%>
				<span style="color: blue;"><%=id%>님 환영합니다!</span>&nbsp;&nbsp;
				<a href="<%=contextPath%>/member/logout.jsp">logout</a>
			<%
			}
		%>
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