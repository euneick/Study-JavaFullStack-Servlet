<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="id" value="lee" scope="page" />
<c:set var="pwd" value="1234" scope="page" />			<!-- String -->
<%-- <c:set var="name" value="${'이순신'}" scope="page" /> --%>
<c:set var="age" value="${30}" scope="page" />			<!-- Integer -->
<c:set var="address" value="${'조선'}" scope="page" />

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<table align="center" width="100%">
		<tr align="center" bgcolor="lightgreen">
			<th width="20%">아이디</th>
			<th width="20%">비밀번호</th>
			<th width="20%">이름</th>
			<th width="20%">나이</th>
			<th width="20%">주소</th>
		</tr>
		<%-- switch --%>
		<c:choose>
			<%-- case --%>
			<c:when test="${empty name}">
				<tr align="center">
					<td colspan="5">이름을 입력하세요</td>
				</tr>
			</c:when>
			<%-- default --%>
			<c:otherwise>
				<tr align="center">
					<td>${id}</td>
					<td>${pwd}</td>
					<td>${name}</td>
					<td>${age}</td>
					<td>${address}</td>
				</tr>
			</c:otherwise>
		</c:choose>
		<tr bgcolor="lightgreen">
			<td colspan="5"></td>
		</tr>
	</table>
</body>

</html>