<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>include2.jsp top area</h1>
	<br>
	<jsp:include page="dukeImage.jsp" flush="true">
		<jsp:param value="듀크2" name="name"/>
		<jsp:param value="duke2.png" name="imgName"/>
	</jsp:include>
	<br>
	<h1>include2.jsp bottom area</h1>
</body>

</html>