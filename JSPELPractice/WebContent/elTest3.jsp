<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h1>표현식 (Expression Language) 비교 연산자</h1>
	<h3>
		\${10 == 10} : ${10 == 10} <br>
		\${10 eq 10} : ${10 eq 10} <br>
		<br>
		\${"hello" == "hello"} : ${"hello" == "hello"} <br>
		\${"hello" eq "hello"} : ${"hello" eq "hello"} <br>
		<br>
		\${"hello" != "hello"} : ${"hello" != "hello"} <br>
		\${"hello" ne "hello"} : ${"hello" ne "hello"} <br>
		<br>
		\${10 < 10} : ${10 < 10} <br>
		\${10 lt 10} : ${10 lt 10} <br>
		<br>
		\${100 > 10} : ${100 > 10} <br>
		\${100 gt 10} : ${100 gt 10} <br>
		<br>
		\${10 <= 10} : ${10 <= 10} <br>
		\${10 le 10} : ${10 le 10} <br>
		<br>
		\${100 >= 10} : ${100 >= 10} <br>
		\${100 ge 10} : ${100 ge 10} <br>
	</h3>
</body>

</html>