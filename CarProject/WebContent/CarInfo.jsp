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
	<title>차량 정보 보기</title>
</head>

<body>
	<center>
		<img src="<%=contextPath%>/img/cis.jpg">
		
		<form action="<%=contextPath%>/Car/CarOption.do" method="post">
			<input type="hidden" name="carno" value="${carInfo.carno}">
			<input type="hidden" name="carimg" value="${carInfo.carimg}">
			<input type="hidden" name="carprice" value="${carInfo.carprice}">
		
			<table width="1000">
				<tr align="center">
					<td rowspan="6" width="600">
						<img src="<%=contextPath%>/img/${carInfo.carimg}" width="500">
					</td>
					<td align="center" width="200">차량이름</td>
					<td align="center" width="200">${carInfo.carname}</td>
				</tr>
				<tr>
					<td align="center" width="200">대여수량</td>
					<td align="center" width="200">
						<select name="carqty">
							<option value="1">1 대</option>
							<option value="2">2 대</option>
							<option value="3">3 대</option>
							<option value="4">4 대</option>
							<option value="5">5 대</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="center" width="200">차량분류</td>
					<td align="center" width="200">${carInfo.carcategory}</td>
				</tr>				
				<tr>
					<td align="center" width="200">대여금액</td>
					<td align="center" width="200">${carInfo.carprice}</td>
				</tr>				
				<tr>
					<td align="center" width="200">제조회사</td>
					<td align="center" width="200">${carInfo.carcompany}</td>
				</tr>
				<tr>
					<td align="center" width="200">
						<input type="button" value="이전화면" onclick="location.href = '<%=contextPath%>/Car/CarList.do'">
					</td>					
					<td align="center" width="200">
						<input type="submit" value="옵션선택">
					</td>
				</tr>
			</table>
		</form>
		<p>
			<b>차량 정보 상세 내용</b>
			<br><br>
			${carInfo.carinfo}
		</p>
	</center>
</body>

</html>