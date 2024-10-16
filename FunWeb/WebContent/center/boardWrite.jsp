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
	<%
		String id = (String) session.getAttribute("id");
	
		if (id == null || id.length() == 0) {
			response.sendRedirect("../member/login.jsp");
		}
	%>
		<article>
			<h1>Notice Write</h1>
			<form action="boardWritePro.jsp" method="post">
				<table id="notice">
					<tr>
						<td>작성자</td>
						<td><input type="text" name="name" value="<%=id%>" readonly></td>
					</tr>
					<tr>
						<td>게시글 비밀번호</td>
						<td><input type="password" name="pwd"></td>
					</tr>
					<tr>
						<td>게시글 제목</td>
						<td><input type="text" name="subject"></td>
					</tr>
					<tr>
						<td>게시글 내용</td>
						<td><textarea rows="13" cols="40" name="content"></textarea></td>
					</tr>
				</table>
				
				<div id="table_search">
					<input type="submit" value="글 쓰기" class="btn">
					<input type="reset" value="다시 쓰기" class="btn">
					<input type="button" value="글 목록" class="btn" onclick="location.href = 'notice.jsp'">
				</div>
			</form>
		</article>

		<div class="clear"></div>
		<div id="page_control"></div>

		<!-- 푸터 영역 -->
		<jsp:include page="../includes/bottom.jsp"></jsp:include>
	</div>
</body>

</html>