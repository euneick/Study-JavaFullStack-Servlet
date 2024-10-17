<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>회원 가입창</title>
</head>

<body>
	<form action="forward.jsp" method="post">
		<h1 style="text-align:center">회원 가입창</h1>	
		<table align="center">
			<tr>
				<td width="200"><p align="right">아이디</p></td>
				<td width="400"><input type="text" name="id" value="lee"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">비밀번호</p></td>
				<td width="400"><input type="password" name="pwd" value="1234"></td>
			</tr>			
			<tr>
				<td width="200"><p align="right">이름</p></td>
				<td width="400"><input type="text" name="name" value="이순신"></td>
			</tr>			
			<tr>
				<td width="200"><p align="right">이메일</p></td>
				<td width="400"><input type="text" name="email" value="lee@joseon.go.kr"></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td width="400">
					<input type="submit" value="가입하기">
					<input type="reset" value="다시입력">
				</td>
			</tr>			
		</table>
	</form>	
</body>

</html>




    