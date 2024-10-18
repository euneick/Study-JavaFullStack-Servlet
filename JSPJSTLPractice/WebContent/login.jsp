<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<% request.setCharacterEncoding("utf-8"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="#" method="post">
		아이디 : <input type="text" size="20" name="id"> <br>
		비밀번호 : <input type="password" size="20" name="pw"> <br>
		<input type="submit" value="로그인">
		<input type="reset" value="다시입력">
	</form>
	<br>
	<!-- <a href="http://localhost:8090/JSPELPractice/memberForm.jsp">회원가입</a> -->
	<%-- <a href="<%=request.getContextPath()%>/memberForm.jsp">회원가입</a> --%>
	<%-- <a href="${pageContext.request.contextPath}/memberForm.jsp">회원가입</a> --%>
	<a href="${contextPath}/memberForm.jsp">회원가입</a>
</body>
</html>