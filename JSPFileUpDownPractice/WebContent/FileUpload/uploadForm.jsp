<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<%--
		서블릿에 파일을 업로드 요청을 위해 가상 경로 주소를 action 속성에 작성
		파일 업로드 구현 시 enctype="multipart/form-data" 속성을 반드시 작성 해야 함
	--%>
	<form action="${contextPath}/upload.do" method="post" enctype="multipart/form-data">
		첨부 파일 1 : <input type="file" name="file1"><br>
		첨부 파일 2 : <input type="file" name="file2"><br>
		파라미터 1 : <input type="text" name="param1" value="요청 데이터 1"><br>
		파라미터 2 : <input type="text" name="param2" value="요청 데이터 1"><br>
		파라미터 3 : <input type="text" name="param3" value="요청 데이터 1"><br>
		<br><input type="submit" value="업로드">
	</form>
</body>

</html>