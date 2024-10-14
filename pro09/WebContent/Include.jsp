<%--
	Include Directive Tag
	 - "공통"으로 사용하는 JSP를 다른 JSP에 추가 할 때 사용
	 - 코드의 재사용성이 높아 유지관리가 용이함
	 - jsp 파일을 java 파일로 변환 시 include 된 jsp가 하나의 파일 안에 적히게 됨
	 
	 	<%@ include file="포함시킬 JSP 경로" %>
--%>
<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>인클루드 디렉티브</title>
</head>

<body>
	<h1>Main JSP Start</h1><br>
	<%@ include file="DukeImage.jsp" %><br>
	<h1>Main JSP Finish</h1>
</body>

</html>