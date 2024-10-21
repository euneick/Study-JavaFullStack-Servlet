<%@page import="sec02.ex01.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sec02.ex01.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="memberBean" class="sec02.ex01.MemberBean" />
<jsp:setProperty name="memberBean" property="*" />

<%
	MemberDAO memberDAO = new MemberDAO();
	memberDAO.RegistMember(memberBean);
	
	ArrayList<MemberBean> membersList = new ArrayList<MemberBean>();	
	membersList = memberDAO.getMembersList();
	
	request.setAttribute("membersList", membersList);
%>

<%-- request의 바인딩 한 값을 공유해야 하므로 Dispatcher 방식으로 포워딩 --%>
<jsp:forward page="membersList.jsp" />