<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<form action="${contextPath}/member/insertMember.do" method="post">
		<h1 style="text-align:center" >회원 등록창</h1>
		<table align="center">
			<tr> 
				<td width="200"> <p align="center">아이디</p> </td> 
				<td width="400"><input type="text" name="id"></td> 
			</tr>  
			<tr> 
				<td width="200"><p align="center">비밀번호</p></td> 
				<td width="400"><input type="password" name="pwd"></td> 
			</tr> 
			<tr> 
				<td width="200"><p align="center">이름</p></td> 
				<td width="400"><input type="text" name="name"></td> 
			</tr> 
			<tr> 
				<td width="200"><p align="center">이메일</p></td> 
				<td width="400"><input type="email" name="email"></td> 
			</tr>  
			<tr> 
				<td width="200"><p align="center">&nbsp;</p></td> 
				<td width="400">
					<input type="submit" value="회원가입">
					<input type="reset" value="다시입력">
				</td> 
			</tr>					
		</table>	
	</form>
</body>

</html>