<!--
	Page Directive Tag
	 - JSP 페이지의 전반적인 정보를 설정
	 
	 * 페이지 디렉티브 태그에서 사용하는 속성
	 	- info 			페이지를 설명해주는 문자열을 지정
	 	- ★language		JSP페이지에서 사용 할 언어를 지정 						(기본값 : java)
	 	- ★contentType 	JSP 페이지 출력 형식 지정 							(기본값 : text/html)
	 	- ★pageEncoding 	사용할 문자열 인코딩 지정 							(기본값 : ISO-8859-1)
	 	- import 		JSP 페이지에서 다른 패키지의 클래스를 임포트 할 때 지정
	 	- session 		HttpSession 객체의 사용 여부 지정 					(기본값 : true)
	 	- buffer 		JSP 페이지 출력 시 사용 할 버퍼 크기 지정					(기본값 : 8kb)
	 	- autoFlush		JSP 페이지의 내용이 출력되기 전 버퍼가 다 채워질 경우 동작을 지정	(기본값 : true)
	 	- errorPage		페이지 처리 도중 예외가 발생할 경우 처리를 담당할 JSP 지정		(기본값 : false)
	 	- isErrorPage	현재 페이지의 예외처리 담당 여부 지정						(기본값 : false)
	 	- isELIgnored 	EL 사용 유무 지정(JSP 2.0 버전 이상) 				(기본값 : true)
	 	- isThreadSafe 	JSP페이지의 스레드 안정성 여부 지정 						(기본값 : true)
	 					동시 엑세스의 문제가 예상 될 경우 false로 지정하고 올바른 동기화코드를 작성
	 					
	 ※ 속성 입력시 대소문자 구분 반드시, JSP 작성 시 반드시 Page Directive Tag를 한 쌍 이상 작성 해야 함
-->

<%@ page
	info="JSP 메인 화면"
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.Date"
	import="java.lang.*"
	session="true"
	buffer="8kb"
	autoFlush="true"
	isThreadSafe="true"
	isErrorPage="false"
	errorPage="false"
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>hello JSP</h1>
	<h1>JSP 실습</h1>
	
	<!-- 자바 코드 작성 -->
	<%		
		double randValue = Math.random();
		Date date = new Date();
		
		System.out.println(randValue);
		System.out.println(date);
	%>
</body>

</html>