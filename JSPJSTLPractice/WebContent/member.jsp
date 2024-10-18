<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="sec01.ex01.MemberBean"%>
<%@page import="java.util.ArrayList"%>
    
<!-- core태그 라이브러리 사용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("utf-8"); %>

<%--
	<c:set var="변수 명" value="변수 초기화 값" scope="변수 유효 범위" />
--%>
<c:set var="id" value="lee" scope="page" />
<c:set var="pwd" value="1234" scope="page" />			<!-- String -->
<c:set var="name" value="${'이순신'}" scope="page" />
<c:set var="age" value="${30}" scope="page" />			<!-- Integer -->
<c:set var="address" value="${'조선'}" scope="page" />
    
<jsp:useBean id="membersList" class="java.util.ArrayList"></jsp:useBean>
<jsp:useBean id="membersMap" class="java.util.HashMap"></jsp:useBean>
<%
	membersList.add(new MemberBean("joo", "1111", "주몽", 19, "고구려"));
	membersList.add(new MemberBean("on", "2222", "온조", 20, "백제"));
	membersList.add(new MemberBean("park", "3333", "박혁거세", 21, "신라"));
	
	membersMap.put("memList", membersList);
%>
<c:set var="mList" value="${membersMap.memList}" />

<c:remove var="age"/>
<c:remove var="address"/>

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
		<tr align="center">
			<td>${id}</td>		<!-- pageScope.id -->
			<td>${pwd}</td>
			<td>${name}</td>
			<td>${age}</td>
			<td>${address}</td>
		</tr>
		<tr align="center">
			<td>${membersMap.memList[0].id}</td>
			<td>${membersMap.memList[0].pwd}</td>
			<td>${membersMap.memList[0].name}</td>
			<td>${membersMap.memList[0].age}</td>
			<td>${membersMap.memList[0].address}</td>
		</tr>
		<tr align="center">
			<td>${mList[1].id}</td>
			<td>${mList[1].pwd}</td>
			<td>${mList[1].name}</td>
			<td>${mList[1].age}</td>
			<td>${mList[1].address}</td>
		</tr>
		<tr align="center">
			<td>${mList[2].id}</td>
			<td>${mList[2].pwd}</td>
			<td>${mList[2].name}</td>
			<td>${mList[2].age}</td>
			<td>${mList[2].address}</td>
		</tr>
		<tr bgcolor="lightgreen">
			<td colspan="5"></td>
		</tr>
	</table>
</body>

</html>