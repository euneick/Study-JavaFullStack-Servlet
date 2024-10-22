<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<style>
		.cls1 {
			font-size: 40px;
			text-align: center;
		}
		
		.cls2 {
			font-size: 20px;
			text-align: center;
		}
	</style>
</head>

<body>
	<p class="cls1">회원 정보</p>
	
	<table align="center">
		<tr align="center" bgcolor="lightgreen">
			<th width="10%">아이디</th>
			<th width="10%">비밀번호</th>
			<th width="10%">이름</th>
			<th width="10%">이메일</th>
			<th width="10%">가입일</th>
			<th width="10%">수정</th>
			<th width="10%">삭제</th>
		</tr>
		
		<c:choose>
			<c:when test="${empty membersList}">
				<tr align="center">
					<td colspan="7">등록된 회원이 없습니다.</td>
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
						<td>
							<a href="${contextPath}/member/modifyMemberForm.do?id=${member.id}">수정</a>
						</td>
						<td>
							<a href="${contextPath}/member/deleteMember.do?id${member.id}">삭제</a>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
		<tr>
			<td colspan="7" bgcolor="lightgreen"></td>
		</tr>
	</table>
	
	<br>
	
	<a href="${contextPath}/member/memberForm.do"><p class="cls2">회원가입하기</p></a>
</body>

</html>