<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String outerPath1 = "outerPage1.jsp";
	String outerPath2 = "outerPage2.jsp";
	
	pageContext.setAttribute("attr1", "동명성왕");
	request.setAttribute("attr2", "온조왕");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>Directive Include (지시어) 사용</h1>
	<%-- <%@ include file="<%=outerPath1%>" %> --%>
	<%@ include file="outerPage1.jsp" %>	
	<p>outerPage1.jsp 외부 페이지에 선언한 변수 : <%=str1%></p>
	
	<%--
		directive include 구문엔 표현식 사용 불가
	--%>
	
	<hr>
	
	<h1>Action Tag Include (액션태그) 사용</h1>
	<jsp:include page="<%=outerPath2%>"></jsp:include>
	<p>outerPage2.jsp 외부 페이지에 선언한 변수 : <%-- <%=str2%> --%></p>
	
	<%--
		액션태그로 include 시 외부 페이지가 현재 페이지에 포함되는 것이 아니므로 사용 불가
		<jsp:include> 태그는 page 영역은 공유하지 않음
	--%>
</body>

</html>