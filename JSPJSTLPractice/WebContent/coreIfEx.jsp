<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<c:set var="val" value="${101}" />
	<c:set var="str" value="JSP" />
	
	<h1>val = ${val}</h1>
	
	<%--
		 * c:if 코어태그는 else 구문을 지원하지 않음
		 * test 속성에 EL 태그 조건식이 아닌 일반 값을 지정 할 경우 false를 반환.
		 	단, "true"를 지정하면 true를 반환 (대소문자 구분 하지 않음 ex. "true", "TRUE", "tRuE" 모두 true 반환)
	 	 * test 속성에 EL 태그 조건식 작성 시 EL 태그 외부에 공백이 있으면 false를 반환 (EL 태그 내부의 공백은 상관 없음)
	--%>
	<c:if test="${val eq 0}" var="result">
		<h3>변수 val은 0입니다.</h3>
	</c:if>
	<c:if test="${not result}">
		<c:if test="${val mod 2 eq 0}" var="result">
			<h3>변수 val은 짝수입니다.</h3>
		</c:if>
		<c:if test="${not result}">
			<h3>변수 val은 홀수입니다.</h3>
		</c:if>
	</c:if>
	
	<hr>
	
	<c:if test="true">
		<h4>test="true" 실행</h4>
	</c:if>
	
	<c:if test="100" var="result">
		<h4>test="100" 실행 됨</h4>
	</c:if>
	<c:if test="${not result}">
		<h4>test="100" 실행되지 않음</h4>
	</c:if>
	
	<hr>
	
	<c:if test=" ${true} " var="result">
		<h4>\${true} 실행 됨</h4>
	</c:if>
	<c:if test="${not result}">
		<h4>\${true} 실행 되지 않음</h4>
	</c:if>
</body>

</html>