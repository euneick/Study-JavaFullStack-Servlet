<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="addException.jsp"%> <!-- 예외 발생 시 호출 할 페이지 지정 -->
<%
	int num = Integer.parseInt(request.getParameter("num"));
	int sum = 0;
	
	for (int i = 1; i <= num; i++) {
		sum += i;
	}
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>합계</h1>
	<h2>1부터 <%=num%>까지의 합 : <%=sum%></h2>
</body>

</html>