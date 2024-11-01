<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	request.setCharacterEncoding("UTF-8");

	String contextPath = request.getContextPath();
%>
<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}"/> --%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

	<style>
		/* 전체 폰트 크기 반응형으로  설정 */
		html {
    			font-size: 62.5%
		}		
		
		#login{
			float: right;
			margin: 20px 64px 0 0;
			font-family: Arial,Helvetico,sans-serif;
			font-size: 20px;
		}
		
		/* a태그의 하이퍼링크 없애기, 글자색 설정 */
		#login a{
			text-decoration: none;
			color: #333;
		}
		
		/* a태그에 마우스를 올리는 이벤트가 발생하면 글자색 설정 */
		
		#login a:hover{
			color: #f90;
		}
		
		/* 메인 로고 이미지 div영역 스타일 주기 */
		#logo{
			float: left;
			width: 265px;
			margin: 60px 0 0 40px;
		}
	
	</style>
</head>

<body>
	<%-- login | join --%>
	<table width="100%" height="5">
		<tr>
			<td>
				<div id="logo">
				<%-- 메인 로고 이미지  --%>
					<a href="<%=contextPath %>/Car/Main"><img src="<%=contextPath %>/img/RENT.jpg" width="300" height="80"/></a>
				</div>
			</td>
			<td>			
			</td>			
			<td align="right" colspan="5">
			<%
				//Session내장객체 메모리 영역에 session값 얻기
				String id = (String)session.getAttribute("id");
				//Session에 값이 저장되어 있지 않으면?
				if (id == null) {
				%>		
					<div id="login" align="center">
					
			          <button type="button" class="btn btn-warning" onclick="location.href='<%=contextPath%>/Member/login.me'">로그인</button>
			          <button type="button" class="btn btn-warning" onclick="location.href='<%=contextPath%>/Member/join.me?center=Members/join.jsp'">회원가입</button> 
					  <button id="joinBtn" class="btn btn-info" onclick="location.href='<%=contextPath%>/Guestbook/GuestbookListAction.gb'">방명록</button>
						<nav class="navbar navbar-light">
								<div class="container-fluid">
								<form class="d-flex" action="<%=contextPath%>/Car/NaverSearchAPI.do">
									<input class="form-control me-2" type="search"
										id="keyword" name="keyword" placeholder="Search" aria-label="Search">
									<input type="hidden" id="startNum" name="startNum" value="1">	
									<button id="searchBtn" class="btn btn-outline-success" type="submit">search</button>
								</form>
							</div>
						</nav>
					</div>
				<%
				}
				else{
				%>		
					<div id="login">
						<%=id%>&nbsp;&nbsp;
						<button type="button" class="btn btn-warning" onclick="location.href='<%=contextPath%>/Member/update.me'">정보수정</button>&nbsp;&nbsp;
						<button type="button" class="btn btn-warning" onclick="location.href='<%=contextPath%>/Member/logout.me'">로그아웃</button> 
						<button id="joinBtn" class="btn btn-info" onclick="location.href='<%=contextPath%>/Guestbook/GuestbookListAction.gb'">방명록</button>
						<nav class="navbar navbar-light">
								<div class="container-fluid">
								<form class="d-flex" action="<%=contextPath%>/Car/NaverSearchAPI.do">
									<input class="form-control me-2" type="search"
										id="keyword" name="keyword" placeholder="Search" aria-label="Search">
									<input type="hidden" id="startNum" name="startNum" value="1">	
									<button id="searchBtn" class="btn btn-outline-success" type="submit">search</button>
								</form>
							</div>
						</nav>
					</div>
				<%				
				}
			%>				
			</td>			
		</tr>
	</table>
	
	<table width="100%" background="<%=contextPath%>/img/aa.jpg" height="5">
		<tr>
			<!-- 예약하기 -->
			<td align="center" bgcolor="red" width="20%">
				<a href="<%=contextPath%>/Car/Reservation?center=CarReservation.jsp">
					<div style="font-size: 2.5rem; color: white;">예약하기</div>
				</a>
			</td>
			<!-- 예약확인 -->
			<td align="center" bgcolor="red" width="20%">
				<a href="<%=contextPath%>/Car/ReserveConfirm?center=CarReserveConfirm.jsp">
					<div style="font-size: 2.5rem; color: white;">예약확인</div>
				</a>
			</td>
			<!-- 자유게시판 -->
			<td align="center" bgcolor="red" width="20%">
				<a href="<%=contextPath %>/Board/list.bo">
					<div style="font-size: 2.5rem; color: white;">자유게시판</div>
				</a>
			</td>
			<!-- 이벤트 -->
			<td align="center" bgcolor="red" width="20%">
				<a href="<%=contextPath %>/EventBoard/list.bo">
					<div style="font-size: 2.5rem; color: white;">이벤트정보</div>
				</a>
			</td>
			<!-- 고객센터 -->
			<td align="center" bgcolor="red" width="20%">
				<a href="<%=contextPath %>/FileBoard/list.bo?currentBlock=0&currentPage=0">
					<div style="font-size: 2.5rem; color: white;">공지사항</div>
				</a>
			</td>
		</tr>
	</table>
	
	<!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    -->
</body>

</html>