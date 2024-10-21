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
	<%--
		formatNumber 태그의 속성
		 - value			출력될 숫자를 지정
		 - type				출력될 타입을 지정
		 	* number			숫자 타입
		 	* currency			통화 타입
		 	* percent			퍼센트 타입
		 - dateStyle		날짜 출력 형식 지정
		 					DateFormat 클래스의 full, long, medium, short 등의 값으로 사용
		 - groupingUsed		3자리 단위의 콤마 기호로 구분 여부를 지정 		(default : true)
		 - currencyCode		통화 코드를 지정		(한국 원화 : KRW)
		 - currentSimbol	통화를 표시할 때 사용할 기호 지정
		 - var				formatNumber 태그의 결과를 저장 할 변수의 이름
		 					설정 시 값을 출력하지 않고 변수에 값을 저장함
		 - scope			변수의 접근 범위 지정
		 - pattern			숫자가 출력 될 양식을 지정
		 					자바의 DecimalFormat 클래스에 정의된 형식을 사용
		 					
	--%>
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