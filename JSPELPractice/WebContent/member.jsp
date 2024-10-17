<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	표현언어 (EL)에서 제공하는 내장 객체
	 * param
		- request.getParameter() 메소드와 같은 기능
	
	 * requestScope
	 	- request와 같은 기능을 하며, request에 바인딩 된 값 참조 가능
	
	 * pageScope
	 	- page와 같은 기능을 하며, page에 바인딩 된 값 참조 가능
	 
	 * sessionScope
	 	- session과 같은 기능을 하며, session에 바인딩 된 값 참조 가능
	 
	 * applicationScope
	 	- application과 같은 기능을 하며, application에 바인딩 된 값 참조 가능
	 
	 * pageContext
	 	- pageContext 객체를 참조
	 	
 	 * Bean 객체 사용 가능
 	 
 	 * 표현언어는 JAVA의 반복문과 같이 작성 할 수 없음
--%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="memberBean" class="sec01.ex01.MemberBean"></jsp:useBean>
<jsp:setProperty name="memberBean" property="*" />

<jsp:useBean id="membersList" class="java.util.ArrayList"></jsp:useBean>
<%
	MemberBean memberBean2 = new MemberBean("joo", "1111", "주몽", "joo@kokuryeo.go.kr");

	membersList.add(memberBean);
	membersList.add(memberBean2);
%>

<jsp:useBean id="membersMap" class="java.util.HashMap"></jsp:useBean>
<%
	membersMap.put("id", "wang");
	membersMap.put("pwd", "3333");
	membersMap.put("name", "왕건");
	membersMap.put("email", "wang@korea.go.kr");
	
	membersMap.put("list", membersList);
%>

<jsp:useBean id="addr" class="sec01.ex01.Address"></jsp:useBean>
<jsp:setProperty name="addr" property="city" value="한양"/>
<jsp:setProperty name="addr" property="zipcode" value="00001"/>
<jsp:setProperty name="memberBean" property="address" value="<%=addr%>"/>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<table align="center" width="100%">
		<tr align="center" bgcolor="#99ccff">
			<th width="14%">아이디</th>
			<th width="14%">비밀번호</th>
			<th width="14%">이름</th>
			<th width="16%">이메일</th>
			<th width="14%">주소</th>
			<th width="14%">도시</th>
			<th width="14%">우편번호</th>
		</tr>
		<tr align="center">
			<td><%=request.getParameter("id")%></td>
			<td><%=request.getParameter("pwd")%></td>
			<td><%=request.getParameter("name")%></td>
			<td><%=request.getParameter("email")%></td>
			<td><% out.print((String) request.getAttribute("address")); %></td>
		</tr>
		<tr align="center">
			<td>${param.id}</td>
			<td>${param.pwd}</td>
			<td>${param.name}</td>
			<td>${param.email}</td>
			<td>${requestScope.address}</td>
		</tr>
		<tr align="center">
			<td>${memberBean.id}</td>		<!-- Bean 객체에 작성된 getter 메소드 호출 -->
			<td>${memberBean.pwd}</td>
			<td>${memberBean.name}</td>
			<td>${memberBean.email}</td>
		</tr>
	<%--<%
		for (int i = 0; i < membersList.size(); i++) {
		%>
			<!-- 작동하지 않음 -->
			<tr align="center">
				<td>${membersList[i].id}</td>
				<td>${membersList[i].pwd}</td>
				<td>${membersList[i].name}</td>
				<td>${membersList[i].email}</td>
			</tr>
		<%
		}
	%>--%>
		<tr align="center">
			<td>${membersList[0].id}</td>
			<td>${membersList[0].pwd}</td>
			<td>${membersList[0].name}</td>
			<td>${membersList[0].email}</td>
		</tr>
		<tr align="center">
			<td>${membersList[1].id}</td>
			<td>${membersList[1].pwd}</td>
			<td>${membersList[1].name}</td>
			<td>${membersList[1].email}</td>
		</tr>
		<tr align="center">
			<td>${membersMap.id}</td>
			<td>${membersMap.pwd}</td>
			<td>${membersMap.name}</td>
			<td>${membersMap.email}</td>
		</tr>
		<tr align="center">
			<td>${membersMap.list[1].id}</td>
			<td>${membersMap.list[1].pwd}</td>
			<td>${membersMap.list[1].name}</td>
			<td>${membersMap.list[1].email}</td>
		</tr>
		<tr align="center">
			<td>${memberBean.id}</td>
			<td>${memberBean.pwd}</td>
			<td>${memberBean.name}</td>
			<td>${memberBean.email}</td>
			<td></td>
			<td>${memberBean.address.city}</td>
			<td>${memberBean.address.zipcode}</td>
		</tr>
		<tr bgcolor="#99ccff">
			<td colspan="7"></td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/memberForm.jsp">회원가입</a>
</body>

</html>