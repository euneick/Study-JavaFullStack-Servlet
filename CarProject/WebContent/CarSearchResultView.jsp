<%@page import="java.util.ArrayList"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<style type="text/css">
		a {
			text-decoration: none;
		}
		
		ul {
			border: 2px #ccc solid;
		}
	</style>
</head>

<body>
	<div id="result">
	<%
		String jsonData = (String) request.getAttribute("responseBody");
	
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(jsonData);
		
		ArrayList<JSONObject> items = (ArrayList<JSONObject>) jsonObject.get("items");
		
		for(JSONObject item : items) {
		%>
			<ul>
				<li><%=item.get("title")%></li>
				<li><%=item.get("description")%></li>
				<li><%=item.get("bloggername")%></li>
				<li><%=item.get("bloggerlink")%></li>
				<li><%=item.get("postdate")%></li>
				<li><a href='<%=item.get("link")%>'>블로그로 이동</a></li>
			</ul>
		<%
		}
	%>
	</div>
</body>

</html>