<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, JavaBeans.*"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	/*
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	*/
	
	//MemberBean memberBean = new MemberBean(id, pwd, name, email);
%>
	<jsp:useBean id="memberBean" class="JavaBeans.MemberBean" scope="page"></jsp:useBean>
	
	<%-- 액션 태그를 사용하여 request.getParameter(), memberBean.setter 간소화
	<jsp:setProperty name="memberBean" property="id" value="<%=request.getParameter("id")%>"/>
	<jsp:setProperty name="memberBean" property="pwd" value="<%=request.getParameter("pwd")%>"/>
	<jsp:setProperty name="memberBean" property="name" value="<%=request.getParameter("name")%>"/>
	<jsp:setProperty name="memberBean" property="email" value="<%=request.getParameter("email")%>"/>
	--%>
	
	<%-- param속성을 사용하여 코드 간소화
	<jsp:setProperty name="memberBean" property="id" param="id"/>
	<jsp:setProperty name="memberBean" property="pwd" param="pwd"/>
	<jsp:setProperty name="memberBean" property="name" param="name"/>
	<jsp:setProperty name="memberBean" property="email" param="email"/>
	--%>
	
	<%-- input 태그의 name 속성 값과 멤버변수 명이 같은 점을 이용하여 코드 간소화
	<jsp:setProperty name="memberBean" property="id"/>
	<jsp:setProperty name="memberBean" property="pwd"/>
	<jsp:setProperty name="memberBean" property="name"/>
	<jsp:setProperty name="memberBean" property="email"/>
 	--%>
 	
 	<%-- 전달된 input 태그의 name 속성들의 개수와 값이 자바빈 객체의 멤버변수들의 개수와 변수명이 같은 점을 이용하여 코드 간소화 --%>
 	<jsp:setProperty name="memberBean" property="*" />
<%	/*
	memberBean.setId(id);
	memberBean.setPwd(pwd);
	memberBean.setName(name);
	memberBean.setEmail(email);
	*/
	MemberDAO memberDAO = new MemberDAO();
	
	memberDAO.RegistMember(memberBean);
	
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