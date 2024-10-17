<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	request.setAttribute("address", "조선");
%>

<%-- Dispatcher 방식으로 포워딩 (request 객체 공유) --%>
<jsp:forward page="member.jsp"></jsp:forward>