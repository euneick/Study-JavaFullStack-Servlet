<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h1>setLocale 예제</h1>
	
	<c:set var="today" value="<%=new Date()%>" />
	
	<h3>한글로 설정</h3>
	<fmt:setLocale value="ko_KR"/>
	<fmt:formatNumber value="10000" type="currency" /><br>
	<fmt:formatDate value="${today}" type="both" dateStyle="full" timeStyle="full" />
	<hr>
	<h3>일어로 설정</h3>
	<fmt:setLocale value="ja_JP"/>
	<fmt:formatNumber value="10000" type="currency" /><br>
	<fmt:formatDate value="${today}" type="both" dateStyle="full" timeStyle="full" />
	<hr>
	<h3>영어로 설정</h3>
	<fmt:setLocale value="en_US"/>
	<fmt:formatNumber value="10000" type="currency" /><br>
	<fmt:formatDate value="${today}" type="both" dateStyle="full" timeStyle="full" />
</body>

</html>