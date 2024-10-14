<%--
	JSP 스크립트 요소(Scripting Element)
	 - JSP에서 여러가지 동적인 기능을 제공하는 태그
	 - HTML 페이지에 자바 코드를 넣을 수 있음
	 
	 1. 선언문
	 	- JSP에 변수, 메소드를 작성하는 영역
	 	- <%! ... %>
	 	- 멤버 영역에 작성 됨 (멤버 변수, 멤버 메소드 작성)
	 	
	 2. 스크립틀릿(Scriptlet)
	 	- JSP에 자바 코드를 작성하는 영역
	 	- <% ... %>
	 	- 지역 영역에 작성 됨 (지역 변수 및 로직 작성)
	 
	 3. 표현식
	 	- JSP에 변수의 값을 출력하는 영역
	 	- <%= ... %>
	 	- JSPWriter.print() 메소드의 매개변수로 작성되기 때문에  표현식 안에는 세미콜론 ; 를 작성하면 에러가 발생
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String name = "듀크";
	public String getName() { return name; }
%>
<%
	String age = request.getParameter("age");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>JSP Scripting Element 연습</title>
</head>

<body>
	<h1>안녕하세요, <%= age %>살 <%= name %>님!</h1>
	<h1>나이 +10은 <%= Integer.parseInt(age) + 10 %>입니다.</h1>
</body>

</html>