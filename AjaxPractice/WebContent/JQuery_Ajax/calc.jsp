<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int value1 = Integer.parseInt(request.getParameter("param1"));
	int value2 = Integer.parseInt(request.getParameter("param2"));
%>

<%=value1 + value2%>