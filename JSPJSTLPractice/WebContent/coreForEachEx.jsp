<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("UTF-8");

	ArrayList<String> dataList = new ArrayList<String>();
	dataList.add("hello");
	dataList.add("world");
	dataList.add("JSP");
%>
<%-- EL에서 사용 할 수 있게 변수에 할당 --%>
<c:set var="list" value="<%=dataList%>" />

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<table>
		<tr align="center" bgcolor="lightgreen">
			<th width="10%">i</th>
			<th width="10%">loop.count</th>
			<th width="10%">loop.index</th>
			<th width="10%">loop.current</th>
			<th width="10%">loop.first</th>
			<th width="10%">loop.last</th>
		</tr>
		<c:forEach var="i" begin="1" end="20" step="2" varStatus="loop">
			<tr align="center">
				<td>${i}</td>
				<td>${loop.count}</td>
				<td>${loop.index}</td>
				<td>${loop.current}</td>
				<td>${loop.first}</td>
				<td>${loop.last}</td>
			</tr>
		</c:forEach>
		<tr bgcolor="lightgreen">
			<td colspan="6"></td>
		</tr>
		<tr align="center" bgcolor="lightgreen">
			<th width="10%">data</th>
			<th width="10%">loop.count</th>
			<th width="10%">loop.index</th>
			<th width="10%">loop.current</th>
			<th width="10%">loop.first</th>
			<th width="10%">loop.last</th>
		</tr>
		<c:forEach var="data" items="${list}" varStatus="loop">
			<tr align="center">
				<td>${data}</td>
				<td>${loop.count}</td>
				<td>${loop.index}</td>
				<td>${loop.current}</td>
				<td>${loop.first}</td>
				<td>${loop.last}</td>
			</tr>
		</c:forEach>
		<tr bgcolor="lightgreen">
			<td colspan="6"></td>
		</tr>
	</table>
	
	<br><hr><br>
	
	<c:set var="fruits" value="사과, 파인애플, 바나나, 망고, 귤, 두리안" />
	<c:forTokens var="token" items="${fruits}" delims=", ">
		${token} <br>
	</c:forTokens>
</body>

</html>