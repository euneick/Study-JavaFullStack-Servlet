<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h1>표현식 (Expression Language) 논리 연산자</h1>
	<h3>
		\${(10 == 10) && (20 == 20)} : ${(10 == 10) && (20 == 20)} <br>
		\${(10 eq 10) and (20 eq 20)} : ${(10 eq 10) and (20 eq 20)} <br>
		<br>
		\${(10 == 10) || (20 != 30)} : ${(10 == 10) || (20 != 30)} <br>
		\${(10 eq 10) or (20 ne 30)} : ${(10 eq 10) or (20 ne 30)} <br>
		<br>
		\${!(20 == 10)} : ${!(20 == 10)} <br>
		\${not(20 eq 10)} : ${not(20 eq 10)} <br>
	</h3>
</body>

</html>