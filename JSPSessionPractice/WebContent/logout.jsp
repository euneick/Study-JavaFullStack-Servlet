<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();		// session 객체에 바인딩 된 모든 데이터 제거
%>
<script>
	window.alert("로그아웃 되었습니다.");
	
	location.href = "index.jsp";
</script>