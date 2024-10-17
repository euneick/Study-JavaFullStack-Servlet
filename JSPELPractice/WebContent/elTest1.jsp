<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>	<%-- 표현식(Expression Language)을 무시하는 속성을 false로 설정해야 표현식 사용 가능 (default : false) --%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h1>표현식 (Expression Language) 으로 출력</h1>
	<h3>
		\${100} : ${100} <br>
		\${"안녕하세요"} : ${"안녕하세요"} <br>
		\${10 + 1} : ${10 + 1} <br>
		\${"10" + 1} : ${"10" + 1} <br>	<%-- 문자열을 숫자로 자동으로 변환 --%>
		\${null + 10} : ${null + 10} <br>
		<%-- \${"hello" + 10} : ${"hello" + 10} <br> --%> <%-- 문자열을 숫자로 변환하는 과정에서 에러 --%>
		<%-- \${"hello" + "world"} : ${"hello" + "world"} --%> <%-- 문자열 + 문자열 불가능 --%>
	</h3>
</body>

</html>