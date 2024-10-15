<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h2>Outer Page 1</h2>
	<% String str1 = "고구려 동명성왕"; %>
	<ul>
		<li>page 내장객체 영역 : <%=pageContext.getAttribute("attr1")%></li>
		<li>request 내장객체 영역 : <%=request.getAttribute("attr2")%></li>
	</ul>
</body>

</html>