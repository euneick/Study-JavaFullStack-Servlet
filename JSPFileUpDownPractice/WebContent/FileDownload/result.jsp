<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	request.setCharacterEncoding("UTF-8");

	String contextPath = request.getContextPath();
	
	String file1 = URLEncoder.encode(request.getParameter("param1"), "utf-8");
	String file2 = URLEncoder.encode(request.getParameter("param2"), "utf-8");
%>

파일1 내려받기<br>
<a href="<%=contextPath%>/download.do?fileName=<%=file1%>">파일 내려받기</a>

<br><br>
파일2 내려받기<br>
<a href="<%=contextPath%>/download.do?fileName=<%=file2%>">파일 내려받기</a>