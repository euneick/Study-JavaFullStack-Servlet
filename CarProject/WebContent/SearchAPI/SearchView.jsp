<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		$(function() {
			
			$("#searchButton").click(function() {
				
				$.ajax({
					url: "http://localhost:8090/CarProject/NaverSearchAPI.do",
					type: "get",
					async: true,
					data: {
						startNum: $("#startNum").val(),
						keyword: $("#keyword").val()
					},
					dataType: "json",
					success: callbackSearchSuccess,					
					error: callbackSearchError
				});
			});
		});
		
		function callbackSearchSuccess(responsedData) {
			
			console.log(responsedData);
			
			let str = "";
			
			$.each(responsedData.items, function(index, item) {
				str += "<ul>";
				str += "<li>" + (index + 1) + "</li>";
				str += "<li>" + item.title + "</li>";
				str += "<li>" + item.description + "</li>";
				str += "<li>" + item.bloggername + "</li>";
				str += "<li>" + item.bloggerlink + "</li>";
				str += "<li>" + item.postdate + "</li>";
				str += "<li><a href='" + item.link + "'>블로그로 이동</a></li>";
				str += "</ul>";
			});
			
			$("#searchResult").html(str);
		}
		
		function callbackSearchError() {
			
			alert("요청 실패");
		}
	</script>
	
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
	<div>
		<div>
			<form id="searchForm">
				한 페이지에 10개씩 출력 됨<br>
				<select id="startNum">
					<%-- 한 페이지에 10개 씩 출력 --%>
					<option value="1">1페이지</option>
					<option value="11">2페이지</option>
					<option value="21">3페이지</option>
					<option value="31">4페이지</option>
					<option value="41">5페이지</option>
				</select>
				
				<input type="text" id="keyword" placeholder="여기에 검색어를 입력">
				<button type="button" id="searchButton">검색 요청</button>
			</form>
		</div>
		
		<div class="row" id="searchResult">
			여기에 검색결과가 덮어 쓰여짐.
		</div>
	</div>
</body>

</html>