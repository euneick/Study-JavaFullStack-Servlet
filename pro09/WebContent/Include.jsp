<!--
	Include Directive Tag
	 - "공통"으로 사용하는 JSP를 다른 JSP에 추가 할 때 사용
	 - 코드의 재사용성이 높아 유지관리가 용이함
-->
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