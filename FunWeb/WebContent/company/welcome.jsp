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
		<%@ include file="../includes/top.jsp" %>

		<div id="sub_img"></div>

		<nav id="sub_menu">
			<ul>
				<li><a href="#">Welcome</a></li>
				<li><a href="#">History</a></li>
				<li><a href="#">Newsroom</a></li>
				<li><a href="#">Public Policy</a></li>
			</ul>
		</nav>

		<article>
			<h1>Welcome</h1>
			<figure class="ceo">
				<img src="../images/company/CEO.jpg" width="196" height="226"
					alt="CEO">
				<figcaption>Fun Web CEO Michael</figcaption>
			</figure>
			<p>Lorem ipsum ipsum dolor... tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus Lorem ipsum ipsum
				dolor...tellus Lorem ipsum ipsum dolor...tellus</p>
		</article>

		<div class="clear"></div>

		<!-- 푸터 영역 -->
		<%@ include file="../includes/bottom.jsp" %>
	</div>
</body>

</html>