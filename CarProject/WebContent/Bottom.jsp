<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<hr width="1000" color="red" size="3">
	
	<!-- 로고 부분 -->
	<a href="#">
		<img src="${contextPath}/img/bo.jpg" width="500" height="50">
	</a>
	
	<font size="2">
		<b>
			<!-- 회사 소개 -->
			<a href="#">
				<img src="${contextPath}/img/sodog.jpg" border="0">
			</a>
			<a href="#">
				<img src="${contextPath}/img/info.jpg"> | 사이버 신문고 | 이용약관 | 인재채용
			</a>
		</b>
	</font>
	
	<br><br>
	
	<small>
		(주) SM렌탈 사업자 등록번호 214-98754-9874 통신 판매업신고 번호 : 제 2010-충남-05호<br>
		서울시 강남구 역삼동 역삼빌딩 2층 21호<br><br>
		대표전화 : 02-000-0000<br>
		FAX : 01-0000-0000
	</small>
</body>

</html>