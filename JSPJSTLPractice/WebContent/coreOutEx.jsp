<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		<c:out>
			- out.println(), <%= %> 표현식 들을 대신하여 사용
			- EL을 사용하여 계산식 대입 가능
	--%>
	
	<c:out value="hello world!" /> <br>
	
	<c:out value="${2 * 4}" /> <br>
	
	<%-- 존재하지 않는 null 값이지만, 공백으로 예외처리되어 출력 --%>
	<c:out value="${requestScope.memberBean.id}" /> <br>
	
	<%-- null 예외처리 되면 공백 대신 default 출력 --%>
	<c:out value="${requestScope.memberBean.id}" default="null 대신 출력 할 값" /> <br>
	
	<hello>는 hello 태그입니다. <br>
	&lt;hello>는 hello 태그입니다. <br>
	<c:out value="<hello>는 hello 태그입니다." /> <br>
</body>

</html>