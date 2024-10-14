<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	
	int dan = Integer.parseInt(request.getParameter("dan"));
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<table border="1">
		<tr align="center" bgcolor="yellow">
			<th colspan="2"><%=dan%>단 출력</th>
		</tr>
<%
		for (int i = 1; i < 10; i++) {
%>
<%-- 방법 1.
<%
			if (i % 2 == 0) {
%>
				<tr align="center" bgcolor="green">
<%
			}
			else {
%>
				<tr align="center" bgcolor="pink">
<%
			}
%>
--%>
<%-- 방법 2.
			<tr align="center" bgcolor=<%
				if (i % 2 == 0) {
			%>
					"pink"
			<%
				}
				else {
			%>
					"green"
			<%
				}
			%>>
--%>
			<tr align="center" bgcolor=<%=(i % 2 == 0) ? "pink" : "green" %>>
				<td width="400">
					<%=dan%> * <%=i%>
				</td>
				<td width="400">
					<%=i*dan%>
				</td>
			</tr>
<%			
		}
%>
	</table>
</body>

</html>