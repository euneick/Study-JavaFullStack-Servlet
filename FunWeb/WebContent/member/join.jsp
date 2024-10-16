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

	<script type="text/javascript">
		function dupWinOpen() {
			if (document.frmJoin.id.value == "") {
				window.alert("아이디를 입력해주세요.");
				document.frmJoin.id.focus();
				
				return;
			}
			
			let inputID = document.frmJoin.id.value;
			
			window.open("joinIDCheck.jsp?userID=" + inputID,
					"아이디 중복 확인",
					"width=400, height=200");
		}
	</script>
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
			<h1>Join Us</h1>
			<form action="joinPro.jsp" id="join" method="post" name="frmJoin">
				<fieldset>
					<legend>Basic Info</legend>
					<label>User ID</label> <input type="text" name="id" class="id">
					<input type="button" value="중복확인" class="dup" onclick="dupWinOpen();"><br>
					<label>Password</label> <input type="password" name="pwd"><br>
					<label>Retype Password</label> <input type="password" name="pwd2"><br>
					<label>Name</label> <input type="text" name="name"><br>
					<label>E-Mail</label> <input type="email" name="email"><br>
					<label>Retype E-Mail</label> <input type="email" name="email2"><br>
				</fieldset>

				<fieldset>
					<legend>Optional</legend>
					<label>Address</label> <input type="text" name="address"><br>
					<label>Telephone Number</label> <input type="text" name="tel"><br>
					<label>Mobile Phone Number</label> <input type="text" name="mtel"><br>
				</fieldset>
				<div class="clear"></div>
				<div id="buttons">
					<input type="submit" value="회원가입" class="submit">
					<input type="reset" value="다시입력" class="cancel">
				</div>
			</form>
		</article>

		<div class="clear"></div>

		<!-- 푸터 영역 -->
		<jsp:include page="../includes/bottom.jsp"></jsp:include>
	</div>
</body>

</html>