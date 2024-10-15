<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<form action="login.jsp" method="post">
		ID : <input type="text" name="user_id"><br>
		PW : <input type="password" name="user_pw"><br>
		<input type="submit" value="로그인">
		<input type="reset" value="취소">
	</form>
<%
	/*
		HttpServletRequest.getMethod() : String
			- 현재 페이지가 전송 받은 방식을 문자열로 반환하는 함수
			- 반환값은 반드시 대문자로 확인해야 함 (소문자 실험 결과 작동하지 않음)
	*/
	if (request.getMethod().equals("POST")) {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		if ("master".equals(id) && "1111".equals(pw)) {
			session.setAttribute("id", id);
			
			// index.jsp Redirect 포워딩(재요청)
			response.sendRedirect("index.jsp");
		}
		else {
		%>
			<script type="text/javascript">
				window.alert("아이디 또는 비밀번호가 일치하지 않습니다.");
				
				// 자바스크립트로 재요청하기
				// location.href = "login.jsp";
			</script>
		<%
		}
	}
%>
</body>

</html>