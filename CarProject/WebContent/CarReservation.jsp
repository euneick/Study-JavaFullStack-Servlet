<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
	<center>
		<table width="1000" border="0">
			<tr>
				<td align="center" width="333">
					<a href="#">
						<img src="<%=contextPath%>/img/lfsonata.jpg" width="288" border="0">
					</a>
				</td>
				<td align="center" width="333">
					<a href="#">
						<img src="<%=contextPath%>/img/k5.jpg" width="288" border="0">
					</a>
				</td>
				<td align="center" width="333">
					<a href="#">
						<img src="<%=contextPath%>/img/avante.jpg" width="288" border="0">
					</a>
				</td>
			</tr>
		</table>

		<h1>
			<img src="<%=contextPath%>/img/ccs.jpg" height="50" border="0">
		</h1>

		<form action="<%=contextPath%>/Car/CarCategory.do" method="post">
			<table width="400" border="0" align="center">
				<tr align="center">
					<td width="100">차량 유형</td>
					<td width="100" height="50">
						<select name="carcategory">
							<option value="Small">소형</option>
							<option value="Mid">중형</option>
							<option value="Big">대형</option>
						</select>
					</td>
					<td align="center"><input type="submit" value="검색"></td>
					<td>
						<input type="button" value="전체 검색" onclick="location.href = '<%=contextPath%>/Car/CarList.do'">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>

</html>