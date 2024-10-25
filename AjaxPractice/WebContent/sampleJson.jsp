<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	String passwd = request.getParameter("passwd");
	
	//String jsonData = "{ 'userId': '" + userId + "', 'passwd': '" + passwd + "' }";
	String jsonData = "{ \"userId\": \"" + userId + "\", \"passwd\": \"" + passwd + "\" }";
	
	//out.print(jsonData);
%>
<%=jsonData%>