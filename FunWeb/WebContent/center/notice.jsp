<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/default.css" rel="stylesheet" type="text/css">
	<link href="../css/subpage.css" rel="stylesheet" type="text/css">
	<!--[if lt IE 9]>
	<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js" type="text/javascript"></script>
	<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/ie7-squish.js" type="text/javascript"></script>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
	<![endif]-->
	<!--[if IE 6]>
	 <script src="../script/DD_belatedPNG_0.0.8a.js"></script>
	 <script>
	   /* EXAMPLE */
	   DD_belatedPNG.fix('#wrap');
	   DD_belatedPNG.fix('#main_img');   
	
	 </script>
	 <![endif]-->
</head>

<body>
	<div id="wrap">
		<!-- 헤더 영역 -->
		<jsp:include page="../includes/top.jsp"></jsp:include>

		<div id="sub_img_center"></div>

		<nav id="sub_menu">
			<ul>
				<li><a href="#">Notice</a></li>
				<li><a href="#">Public News</a></li>
				<li><a href="#">Driver Download</a></li>
				<li><a href="#">Service Policy</a></li>
			</ul>
		</nav>

		<article>
			<h1>Notice</h1>
			<table id="notice">
				<tr>
					<th class="tno">No.</th>
					<th class="ttitle">Title</th>
					<th class="twrite">Writer</th>
					<th class="tdate">Date</th>
					<th class="tread">Read</th>
				</tr>
			</table>
			
			<div id="table_search">
				<input type="text" name="search" class="input_box">
				<input type="button" value="검색" class="btn">
			<%
				String id = (String) session.getAttribute("id");
			
				if (id != null && id.length() != 0) {
				%>
					<input type="button" value="글쓰기" class="btn" onclick="location.href = 'boardWrite.jsp'">
				<%
				}
			%>
			</div>
			
			<div class="clear"></div>
			
			<div id="page_control">
				<a href="#">Prev</a> <a href="#">1</a> <a href="#">2</a> <a href="#">3</a>
				<a href="#">4</a> <a href="#">5</a> <a href="#">6</a> <a href="#">7</a>
				<a href="#">8</a> <a href="#">9</a> <a href="#">10</a> <a href="#">Next</a>
			</div>
		</article>

		<div class="clear"></div>

		<!-- 푸터 영역 -->
		<jsp:include page="../includes/bottom.jsp"></jsp:include>
	</div>
</body>

</html>