<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	<%--
		formatDate 태그의 속성
		 - value		포맷팅 할 날짜를 지정
		 - type			포맷틸 할 타입을 지정
	 		* date			날짜만 지정
	 		* time			시간만 지정
	 		* both			날짜, 시간 지정
		 - dateStyle	날짜의 출력 형식 지정
		 				full, long, medium, short, default의 값으로 설정
		 - timeStyle	시간의 출력 형식 지정
		 				full, long, medium, short, default의 값으로 설정
		 - pattern		직접 출력 형식을 지정
		 				자바 클래스 SimpleDateFormat에 지정된 패턴을 사용
		 
		timeZone 태그
		 	formatDate 태그를 timeZone 태그 사이에 작성하면 원하는 지역의 시간대로 설정이 가능함
	--%>
	
	<h1>formatDate 예제</h1>
	
	<c:set var="today" value="<%=new java.util.Date() %>" />
	<h2>today : <c:out value="${today}"/></h2>
	
	<h3>date 형식으로 full 출력 : <fmt:formatDate value="${today}" type="date" dateStyle="full" /></h3>
	<h3>date 형식으로 long 출력 : <fmt:formatDate value="${today}" type="date" dateStyle="long" /></h3>
	<h3>date 형식으로 medium 출력 : <fmt:formatDate value="${today}" type="date" dateStyle="medium" /></h3>
	<h3>date 형식으로 short 출력 : <fmt:formatDate value="${today}" type="date" dateStyle="short" /></h3>
	<h3>date 형식으로 default 출력 : <fmt:formatDate value="${today}" type="date" dateStyle="default" /></h3>
	<br>
	<h3>time 형식으로 full 출력 : <fmt:formatDate value="${today}" type="time" timeStyle="full" /></h3>
	<h3>time 형식으로 long 출력 : <fmt:formatDate value="${today}" type="time" timeStyle="long" /></h3>
	<h3>time 형식으로 medium 출력 : <fmt:formatDate value="${today}" type="time" timeStyle="medium" /></h3>
	<h3>time 형식으로 short 출력 : <fmt:formatDate value="${today}" type="time" timeStyle="short" /></h3>
	<h3>time 형식으로 default 출력 : <fmt:formatDate value="${today}" type="time" timeStyle="default" /></h3>
	<br>
	<h3>
		both 형식으로 dateStyle full, timeStyle full 출력 : 
		<fmt:formatDate value="${today}" type="both" dateStyle="full" timeStyle="full" />
	</h3>
	<h3>
		both 형식으로 dateStyle full, timeStyle short 출력 : 
		<fmt:formatDate value="${today}" type="both" dateStyle="full" timeStyle="short" />
	</h3>
	<h3>
		both 형식으로 dateStyle short, timeStyle short 출력 : 
		<fmt:formatDate value="${today}" type="both" dateStyle="short" timeStyle="short" />
	</h3>
	<br>
	<h3>
		pattern 속성을 사용하여 출력 : <fmt:formatDate value="${today}" type="both" pattern="yyyy/MM/dd - hh:mm:ss"/>
	</h3>
	<br>
	<h3><fmt:timeZone value="GMT">
		세계 협정시 기준으로 현재 시간을 full 출력 : <fmt:formatDate value="${today}" type="both" dateStyle="full" timeStyle="full" />
	</fmt:timeZone></h3>
	<h3><fmt:timeZone value="America/Chicago">
		시카고의 현재 시간을 full 출력 : <fmt:formatDate value="${today}" type="both" dateStyle="full" timeStyle="full" />
	</fmt:timeZone></h3>
	<h3><fmt:timeZone value="Europe/London">
		런던의 현재 시간을 full 출력 : <fmt:formatDate value="${today}" type="both" dateStyle="full" timeStyle="full" />
	</fmt:timeZone></h3>
</body>

</html>