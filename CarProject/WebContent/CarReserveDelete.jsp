<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	request.setCharacterEncoding("UTF-8");
	String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<div style="text-align: center; background-color: pink;">
		<h1>확인을 위해 비밀번호를 입력하세요.</h1>
		
		<br>
		
		<form action="<%=contextPath%>/Car/ReserveDelete.do" method="post">
			<input type="hidden" name="orderid" value="${param.orderid}">
			<input type="hidden" name="memberphone" value="${param.memberphone}">
		
			<table width="100%">
				<tr align="center">
					<td align="center">
						비밀번호 입력 :
						<input type="password" name="memberpass">
						<input type="submit" value="예약취소">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>