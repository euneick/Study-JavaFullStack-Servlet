<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<center>
		<img src="${contextPath}/img/naeyeok.jpg">
		<br><br>
		
		<table width="1000" border="1" align="center">
			<tr align="center">
				<th align="center" width="150">차량이미지</th>
				<th align="center" width="100">차량명</th>
				<th align="center" width="100">대여일</th>
				<th align="center" width="50">대여기간</th>
				<th align="center" width="100">한대 가격</th>
				<th align="center" width="70">보험</th>
				<th align="center" width="70">와이파이</th>
				<th align="center" width="70">네비게이션</th>
				<th align="center" width="70">베이비시트</th>
				<th align="center" width="100">예약수정</th>
				<th align="center" width="100">예약취소</th>
			</tr>
			<c:if test="${empty carConfirmList}">
				<tr align="center">
					<td align="center" colspan="11">예약된 정보가 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="carConfirm" items="${carConfirmList}">
				<tr>
					<td align="center" width="150">
						<img src="${contextPath}/img/${carConfirm.carimg}" width="140" height="90">
					</td>
					<td align="center" width="100">${carConfirm.carname}</td>
					<td align="center" width="100">${carConfirm.carbegindate}</td>
					<td align="center" width="50">${carConfirm.carreserveday}일</td>
					<td align="center" width="100">${carConfirm.carprice}원</td>
					<td align="center" width="70">
						<c:if test="${carConfirm.carins == 1}" var="result">적용</c:if>
						<c:if test="${not result}">미적용</c:if>
					</td>
					<td align="center" width="70">
						<c:if test="${carConfirm.carwifi == 1}" var="result">적용</c:if>
						<c:if test="${not result}">미적용</c:if>
					</td>
					<td align="center" width="70">
						<c:if test="${carConfirm.carnave == 1}" var="result">적용</c:if>
						<c:if test="${not result}">미적용</c:if>
					</td>
					<td align="center" width="70">
						<c:if test="${carConfirm.carbabyseat == 1}" var="result">적용</c:if>
						<c:if test="${not result}">미적용</c:if>
					</td>
					<td align="center" width="100">
						<a href="${contextPath}/Car/ReserveUpdate.do?orderid=${carConfirm.orderid}&
							carimg=${carConfirm.carimg}&memberphone=${memberphone}&memberpass=${memberpass}">
							예약수정
						</a>
					</td>
					<td align="center" width="100">
						<a href="${contextPath}/Car/ReserveDelete.do?orderid=${carConfirm.orderid}&
							memberphone=${memberphone}&center=CarReserveDelete.jsp">
							예약취소
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>

</html>