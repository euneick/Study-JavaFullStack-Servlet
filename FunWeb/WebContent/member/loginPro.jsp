<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	if (new MemberDAO().checkUser(id, pwd) == 1) {
		session.setAttribute("id", id);
		response.sendRedirect("../index.jsp");
	}
	else {
	%>
		<script>
			window.alert("아이디 또는 비밀번호가 틀렸습니다.");
			location.href = "login.jsp";
			// history.back();
			// history.go(-1);
		</script>
	<%
	}
%>