<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("utf-8"); %>

<c:set var="scopeVar" value="Page Value" scope="page"></c:set>
<c:set var="scopeVar" value="request Value" scope="request"></c:set>
<c:set var="scopeVar" value="session Value" scope="session"></c:set>
<c:set var="scopeVar" value="application Value" scope="application"></c:set>
    
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h1>각 Scope의 변수 출력하기</h1>
	<ul>
		<li><h3>pageScope.scopeVar : ${pageScope.scopeVar}</h3></li>
		<li><h3>requestScope.scopeVar : ${requestScope.scopeVar}</h3></li>
		<li><h3>sessionScope.scopeVar : ${sessionScope.scopeVar}</h3></li>
		<li><h3>applicationScope.scopeVar : ${applicationScope.scopeVar}</h3></li>
	</ul>
	<hr>
	<h1>c:remove 코어태그의 scope 속성을 session으로 지정하고 삭제</h1>
	<c:remove var="scopeVar" scope="session"/>
	<ul>
		<li><h3>pageScope.scopeVar : ${pageScope.scopeVar}</h3></li>
		<li><h3>requestScope.scopeVar : ${requestScope.scopeVar}</h3></li>
		<li><h3>sessionScope.scopeVar : ${sessionScope.scopeVar}</h3></li>
		<li><h3>applicationScope.scopeVar : ${applicationScope.scopeVar}</h3></li>
	</ul>
	<hr>
	<h1>c:remove 코어태그의 scope 속성 지정 없이 삭제</h1>
	<c:remove var="scopeVar"/>
	<ul>
		<li><h3>pageScope.scopeVar : ${pageScope.scopeVar}</h3></li>
		<li><h3>requestScope.scopeVar : ${requestScope.scopeVar}</h3></li>
		<li><h3>sessionScope.scopeVar : ${sessionScope.scopeVar}</h3></li>
		<li><h3>applicationScope.scopeVar : ${applicationScope.scopeVar}</h3></li>
	</ul>
	
	<%-- scope 속성 지정 없이 삭제하면 모든 영역에 해당 이름의 변수를 제거함 --%>
	
</body>

</html>