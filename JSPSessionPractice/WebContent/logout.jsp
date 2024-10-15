<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();		// session 객체에 바인딩 된 모든 데이터 제거
	
	response.sendRedirect("index.jsp");
%>