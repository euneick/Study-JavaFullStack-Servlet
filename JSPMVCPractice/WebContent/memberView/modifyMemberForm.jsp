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
	</style>
</head>

<body>
	<form action="${contextPath}/member/modifyMember.do?id=${selectedMember.id}" method="post">
		<h1 class="cls1">회원 정보 수정 창</h1>
		<table align="center">
			<tr> 
				<td width="200"> <p align="center">아이디</p> </td> 
				<td width="400"><input type="text" name="id" value="${selectedMember.id}" disabled></td> 
			</tr> 
			<tr> 
				<td width="200"><p align="center">이름</p></td> 
				<td width="400"><input type="text" name="name" value="${selectedMember.name}"></td> 
			</tr>
			<tr> 
				<td width="200"><p align="center">이메일</p></td> 
				<td width="400"><input type="email" name="email" value="${selectedMember.email}"></td> 
			</tr>
			<tr align="center"> 
				<td width="400" colspan="2">
					<input type="submit" value="수정하기">
					<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
	</form>
</body>

</html>