<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
	<table width="100%">
		<tr bgcolor="#99ccff">
			<th width="20%">아이디</th>
			<th width="20%">비밀번호</th>
			<th width="20%">이름</th>
			<th width="20%">이메일</th>
			<th width="20%">가입일</th>
		</tr>
		<c:choose>
			<c:when test="${empty membersList}">
				<tr>
					<td colspan="5"><b>등록된 회원이 없습니다.</b></td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="member" items="${membersList}">
					<tr align="center">
						<td>${member.id}</td>
						<td>${member.pwd}</td>
						<td>${member.name}</td>
						<td>${member.email}</td>
						<td>${member.joinDate}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr bgcolor="#99ccff">
			<td colspan="5"></td>
		</tr>
	</table>
</body>

</html>