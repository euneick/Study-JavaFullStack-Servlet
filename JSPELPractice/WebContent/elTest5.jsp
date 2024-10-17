<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="memberBean" class="sec01.ex01.MemberBean"></jsp:useBean>
<jsp:setProperty name="memberBean" property="name" value="이순신" />

<jsp:useBean id="arrayList" class="java.util.ArrayList"></jsp:useBean>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h1>표현식 (Expression Language) 여러 가지 연산자들</h1>
	<h3>
		\${empty memberBean} : ${empty memberBean} <br>
		\${not empty memberBean} : ${not empty memberBean} <br>
		<br>
		\${empty arrayList} : ${empty arrayList} <br>
		\${not empty arrayList} : ${not empty arrayList} <br>
		<br>
		\${empty "hello"} : ${empty "hello"} <br>
		\${empty null} : ${empty null} <br>
		\${empty ""} : ${empty ""} 
	</h3>
</body>

</html>