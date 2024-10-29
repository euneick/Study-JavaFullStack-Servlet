<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<style type="text/css">
		a {
			text-decoration: none;
		}
		
		th {
			color: white;
			font-size: 120%;
		}
	</style>
</head>

<body>
	<div id="result">
	<%
		String jsonData = (String) request.getAttribute("responseBody");
	
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(jsonData);
		
		JSONArray items = (JSONArray) jsonObject.get("items");
		
	%>
		<hr width="100%" color="red">
		
		<table width="100%" border="1">
			<tr style="background-color: red;" align="center">
				<th width="10%">제목</th>
				<th width="66%">요약내용</th>
				<th width="10%">블로거 명</th>
				<th width="7%">작성 날짜</th>
				<th width="7%">링크</th>
			</tr>
		<%
			for (int i = 0; i < items.size(); i++) {
				JSONObject item = (JSONObject) items.get(i);
			%>
				<tr>
					<td align="center"><%=item.get("title")%></td>
					<td align="center"><%=item.get("description")%></td>
					<td align="center"><%=item.get("bloggername")%></td>
					<td align="center"><%=item.get("postdate")%></td>
					<td align="center"><a href='<%=item.get("link")%>'>바로가기</a></td>
				</tr>
			<%
			}
		%>
		</table>
	</div>
</body>

</html>