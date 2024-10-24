<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	request.setCharacterEncoding("UTF-8");

	String contextPath = request.getContextPath();
%>
<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}"/> --%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<a><img src="<%=contextPath%>/img/RENT.jpg" width="300" height="80"></a>
	
	<table width="1000" background="<%=contextPath%>/img/aa.jpg" height="5">
		<tr>
			<!-- 예약하기 -->
			<td align="center" bgcolor="red">
				<a href="<%=contextPath%>/Car/Reservation?center=CarReservation.jsp">
					<img src="<%=contextPath%>/img/bb.jpg" border="0">
				</a>
			</td>
			<!-- 예약확인 -->
			<td align="center" bgcolor="red">
				<a href="<%=contextPath%>/Car/ReserveConfirm?center=CarReserveConfirm.jsp">
					<img src="<%=contextPath%>/img/cc.jpg" border="0">
				</a>
			</td>
			<!-- 자유게시판 -->
			<td align="center" bgcolor="red">
				<a href="#"><img src="<%=contextPath%>/img/dd.jpg" border="0"></a>
			</td>
			<!-- 이벤트 -->
			<td align="center" bgcolor="red">
				<a href="#"><img src="<%=contextPath%>/img/even.jpg" border="0"></a>
			</td>
			<!-- 고객센터 -->
			<td align="center" bgcolor="red">
				<a href="#"><img src="<%=contextPath%>/img/ee.jpg" border="0"></a>
			</td>
		</tr>
	</table>
</body>

</html>