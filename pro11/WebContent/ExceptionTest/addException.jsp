<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"%>	<!-- isErrorPage 속성의 값을 true로 지정해야 exception 내장객체 사용 가능 -->
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>toString() 내용</h1>
	<h3><%=exception.toString()%></h3>
	<br>
	<h1>getMessage() 내용</h1>
	<h3><%=exception.getMessage()%></h3>
	<br>
	<h1>printStackTrace() 내용</h1>
	<h3><%exception.printStackTrace();%></h3>
	<br>
	<h3>
		숫자만 입력 가능
		<a href="add.html">다시하기</a>
	</h3>
</body>

</html>