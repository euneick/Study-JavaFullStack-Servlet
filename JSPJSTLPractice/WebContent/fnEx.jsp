<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h1>여러가지 문자열 처리 관련 함수들</h1>

	<c:set var="string1" value="hello world!" />
	<c:set var="string2" value="This is main JSP" />
	<c:set var="string3" value="main" />
	<c:set var="string4" value="     HI     " />
	
	<h3>fn:length("${string1}") : ${fn:length(string1)}</h3>
	<h3>fn:toUpperCase("${string1}") : ${fn:toUpperCase(string1)}</h3>
	<h3>fn:toLowerCase("${string2}") : ${fn:toLowerCase(string2)}</h3>
	<h3>fn:substring("${string1}", 3, 8) : ${fn:substring(string1, 3, 8)}</h3>
	<h3>fn:trim("${string4}") : ${fn:trim(string4)}</h3>
	<h3>fn:replace("${string2}", " ", "/") : ${fn:replace(string2, " ", "/")}</h3>
	<h3>fn:indexOf("${string2}", "${string3}") : ${fn:indexOf(string2, string3)}</h3>
	<h3>fn:contains("${string1}", "${string3}") : ${fn:contains(string1, string3)}</h3>
	<h3>fn:contains("${string2}", "${string3}") : ${fn:contains(string2, string3)}</h3>
</body>

</html>