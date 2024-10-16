<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
<%
	request.setCharacterEncoding("utf-8");

	String userID = request.getParameter("userID");
	
	MemberDAO memberDAO = new MemberDAO();
	
	if (memberDAO.validateID(userID) == 0){
		out.println("사용 가능한 아이디입니다.");
	%>
		<input type="button" value="사용함" onclick="onUseButton();">
	<%
	}
	else out.println("이미 존재하는 아이디입니다.");
%>
		
	<form action="joinIDCheck.jsp" method="post" name="frmIDCheck">
		아이디 : <input type="text" name="userID" value="<%=userID%>">
		<input type="submit" value="중복확인">
	</form>
	
	<script type="text/javascript">
		function onUseButton() {
			// opener : 현제 페이지를 open한 페이지
			opener.document.frmJoin.id.value = document.frmIDCheck.userID.value;
			
			window.close();
		}
	</script>
</body>

</html>