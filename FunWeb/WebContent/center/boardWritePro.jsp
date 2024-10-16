<%@page import="java.sql.Timestamp"%>
<%@page import="board.BoardDAO"%>
<%@page import="board.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

%>
	<jsp:useBean id="boardBean" class="board.BoardBean"/>
	<jsp:setProperty name="boardBean" property="*" />
<%
	boardBean.setIp(request.getRemoteAddr());
	boardBean.setJoinDate(new Timestamp(System.currentTimeMillis()));
	boardBean.setId(request.getParameter("name"));
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.insertBoard(boardBean);
	
	response.sendRedirect("notice.jsp");
%>