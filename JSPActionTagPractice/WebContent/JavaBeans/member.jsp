<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, JavaBeans.*"
    pageEncoding="UTF-8"%>
<%!
	public boolean validateString(String str) { return (str != null && str.length() != 0); }
%>    
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");	

	MemberDAO memberDAO = new MemberDAO();
	
	if (validateString(id) && validateString(pwd) &&
			validateString(name) && validateString(email) ) {
		//MemberBean memberBean = new MemberBean(id, pwd, name, email);
	%>
		<jsp:useBean id="memberBean" class="JavaBeans.MemberBean" scope="page"></jsp:useBean>
	<%
		memberBean.setId(id);
		memberBean.setPwd(pwd);
		memberBean.setName(name);
		memberBean.setEmail(email);
		
		memberDAO.RegistMember(memberBean);
	}
	
	ArrayList<MemberBean> memberList = memberDAO.getMembersList();
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<table align='center' width='100%'>
		<tr align='center' bgcolor="#99ccff">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="5%">이름</td>
			<td width="11%">이메일</td>
			<td width="5%">가입시기</td>
		</tr>
	<%
		if (memberList.size() == 0) {
		%>
			<tr>
				<td colspan="5">
					<p align="center"><b>
						<span style="font-size: 9pt;">등록된 회원이 없습니다.</span>
					</b></p>
				</td>
			</tr>
		<%
		}
		else {
			for (int i = 0; i < memberList.size(); i++) {
				MemberBean bean = memberList.get(i);
			%>
				<tr align='center'>
					<td><%=bean.getId()%></td>
					<td><%=bean.getPwd()%></td>
					<td><%=bean.getName()%></td>
					<td><%=bean.getEmail()%></td>
					<td><%=bean.getJoinDate()%></td>
				</tr>
			<%
			}
		}
	%>
		<tr height="1" bgcolor="#99ccff">
			<td colspan="5"></td>
		</tr>
	</table>
</body>

</html>