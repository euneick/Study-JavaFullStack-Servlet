<%@page import="member.MemberDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
	<jsp:useBean id="memberBean" class="member.MemberBean"/>
	<jsp:setProperty name="memberBean" property="*" />
<%
	memberBean.setJoinDate(new Timestamp(System.currentTimeMillis()));

	MemberDAO memberDAO = new MemberDAO();
	memberDAO.insertMember(memberBean);
	
	response.sendRedirect("login.jsp");
%>