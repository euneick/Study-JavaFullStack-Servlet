<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");

	String userId = request.getParameter("userId");
	String passwd = request.getParameter("passwd");
	
	//String jsonData = "{ 'userId': '" + userId + "', 'passwd': '" + passwd + "' }";
	String jsonData = "{ \"userId\": \"" + userId + "\", \"passwd\": \"" + passwd + "\" }";
	
	//out.print(jsonData);
%>
<%=jsonData%>