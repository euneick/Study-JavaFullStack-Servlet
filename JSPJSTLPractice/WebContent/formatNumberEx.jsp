<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	<h1>formatNumber 예제</h1>
	
	<c:set var="price" value="100000000" />
	<h3>문자열 price : ${price}</h3>
	
	<%-- groupingUsed 속성 값의 default는 true --%>
	<h3>숫자로 표현 : <fmt:formatNumber value="${price}" type="number" /></h3>
	<h3>원화로 표현 : <fmt:formatNumber value="${price}" type="currency" groupingUsed="true" /></h3>
	<h3>달러로 표현 : <fmt:formatNumber value="${price}" type="currency" currencySymbol="$" groupingUsed="true" /></h3>
	<h3>퍼센트로 표현 : <fmt:formatNumber value="${price}" type="percent" /></h3>
	<fmt:formatNumber value="${price}" type="number" var="priceNumber" />	<%-- var 속성 사용 시 화면에 출력하지 않고 변수에 저장 --%>
	<h3>변수에 담아 출력 : ${priceNumber}</h3>
</body>

</html>