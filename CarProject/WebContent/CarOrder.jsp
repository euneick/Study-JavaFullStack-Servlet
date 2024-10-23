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
	<title>차량 예약 하기</title>
</head>

<body>
	<form action="<%=contextPath%>/Car/CarOrder.do" method="post">
		<input type="hidden" name="carno" value="${carOrder.carno}">
		<input type="hidden" name="carqty" value="${carOrder.carqty}">
		<input type="hidden" name="carreserveday" value="${carOrder.carreserveday}">
		<input type="hidden" name="carbegindate" value="${carOrder.carbegindate}">
		<input type="hidden" name="carins" value="${carOrder.carins}">
		<input type="hidden" name="carwifi" value="${carOrder.carwifi}">
		<input type="hidden" name="carnave" value="${carOrder.carnave}">
		<input type="hidden" name="carbabyseat" value="${carOrder.carbabyseat}">
	
		<div align="center">
			<img src="<%=contextPath%>/img/haki.jpg">
			
			<p>
				<font size="13" color="blue">
					차량 기본 금액 비용 : 
					<fmt:formatNumber value="${totalReserve}" type="currency" groupingUsed="true" />원
				</font>
			</p>
			<p>
				<font size="13" color="blue">
					차량 옵션 금액 비용 : 
					<fmt:formatNumber value="${totalOption}" type="currency" groupingUsed="true" />원	
				</font>
			</p>
			<p>
				<font size="13" color="blue">
					차량 총 금액 비용 : 
					<fmt:formatNumber value="${totalReserve + totalOption}" type="currency" groupingUsed="true" />원	
				</font>
			</p>
			<p>
				비회원 전화번호 입력 : <input type="text" name="memberphone">
				&nbsp;&nbsp;&nbsp;
				비회원 비밀번호 입력 : <input type="password" name="memberpass">
				<input type="submit" value="예약요청">
			</p>
		</div>
	</form>
</body>

</html>