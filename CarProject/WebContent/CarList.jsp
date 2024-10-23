<%@page import="VOs.CarListVO"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	request.setCharacterEncoding("UTF-8");	
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>차량 조회 결과</title>
</head>

<body>
	<center>
		<img src="${contextPath}/img/cis.jpg">
		
		<form action="${contextPath}/Car/CarCategory.do">
			<table width="1000" height="470">			
			<%
				Vector<CarListVO> carList = (Vector<CarListVO>)request.getAttribute("carVector");
			
				int index = 0;
				for (CarListVO car : carList) {
					
					if (index % 4 == 0) { %> <tr align="center"> <% }
				%>
					<td>
						<a href="${contextPath}/Car/CarInfo.do?carno=<%=car.getCarno()%>">
							<img src="${contextPath}/img/<%=car.getCarimg()%>" width="220" height="180"><br>
							차량명 : <%=car.getCarname()%><br>
							가격 : <%=car.getCarprice()%><br>
						</a>
					</td>
				<%
					index++;
				}
			%>
				</tr>
				<%--
				<c:set var="j" value="0"/>
				
				<c:forEach var="car" items="${requestScope.carVector}">
					<c:if test="${j % 4 == 0}">
						<tr align="center">
					</c:if>
					<td>
						<a href="${contextPath}/Car/CarInfo.do?carno=${car.carno}">
							<img src="${contextPath}/img/${car.carimg}" width="220" height="180"><br>
							차량명 : ${car.carname}<br>
							가격 : ${car.carprice}<br>
						</a>
					</td>
					
					<c:set var="j" value="${j + 1}"/>
				</c:forEach>
				</tr>
				--%>
				
				<tr height="70">
					<td colspan="4" align="center">
						차량검색 : 
						<select name="carcategory">
							<option value="Small">소형</option>
							<option value="Mid">중형</option>
							<option value="Big">대형</option>
						</select>
						&nbsp;&nbsp;&nbsp;
						<input type="submit" value="차량검색">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>

</html>