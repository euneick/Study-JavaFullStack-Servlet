<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int value1 = Integer.parseInt(request.getParameter("param1"));
	int value2 = Integer.parseInt(request.getParameter("param2"));
%>
{
	"result1": <%=value1%>,
	"result2": <%=value2%>,
	"result3": <%=value1 + value2%>
}