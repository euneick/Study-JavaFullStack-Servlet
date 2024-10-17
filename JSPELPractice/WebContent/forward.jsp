<%@page import="sun.rmi.server.Dispatcher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	request.setAttribute("address", "조선");		// 현재 페이지가 닫히기 전까지 유지
	
	request.setAttribute("id", "ryu");
	request.setAttribute("pwd", "5555");
	
	session.setAttribute("name", "류성룡");	// 브라우저 창이 닫히기 전까지 유지
	
	application.setAttribute("email", "ryu@joseon.go.kr");	// 서버가 중지 되기 전까지 유지
	
	/* Dispatcher dispatcher = request.getRequestDispatcher("member.jsp");
	dispatcher.forward(request, response); */
%>

<%-- Dispatcher 방식으로 포워딩 (request 객체 공유) --%>
<jsp:forward page="member.jsp"></jsp:forward>