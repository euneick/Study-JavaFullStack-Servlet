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

		<div id="sub_img_member"></div>

		<nav id="sub_menu">
			<ul>
				<li><a href="#">Join us</a></li>
				<li><a href="#">Privacy policy</a></li>
			</ul>
		</nav>

		<article>
			<h1>Login</h1>
			<form action="loginPro.jsp" method="post" id="join">
				<fieldset>
					<legend>Login Info</legend>
					<label>User ID</label> <input type="text" name="id"><br>
					<label>Password</label> <input type="password" name="pwd"><br>
				</fieldset>
				<div class="clear"></div>
				<div id="buttons">
					<input type="submit" value="로그인" class="submit">
					<input type="reset" value="취소" class="cancel">
				</div>
			</form>
		</article>

		<div class="clear"></div>

		<!-- 푸터 영역 -->
		<jsp:include page="../includes/bottom.jsp"></jsp:include>
	</div>
</body>

</html>