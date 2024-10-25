<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	String passwd = request.getParameter("passwd");
	
	out.print(userId + "\t" + passwd);
%>