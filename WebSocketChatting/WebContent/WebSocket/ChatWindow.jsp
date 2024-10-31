<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<script type="text/javascript">
		let webSocket = new WebSocket("<%=application.getInitParameter("chatAddress")%>/ChatingServer");
		let chatWindow, chatMessage, chatId;
		
		window.onload = function() {
			
			chatWindow = document.getElementById("chatWindow");
			chatMessage = document.getElementById("chatMessage");
			chatId = document.getElementById("chatId").value;
		}
		
		function sendMesseage() {
			
			chatWindow.innerHTML += "<div class='myMsg'><span>" + chatMessage.value + "</span></div>";
			webSocket.send(chatId + '|' + chatMessage.value);
			chatMessage.value = "";
			chatWindow.scrollTop = chatWindow.scrollHeight;
		}
		
		function disconnect() {
			webSocket.close();
		}
		
		function onEnterKey() {
			if (window.event.keyCode == 13) { sendMesseage(); }
		}
		
		webSocket.onopen = function(event) {
			chatWindow.innerHTML += "웹 소켓 서버에 연결되었습니다.<br>";
		}
		
		webSocket.onclose = function(event) {
			chatWindow.innerHTML += "웹 소켓 서버가 종료되었습니다.<br>"; 
		}
		
		webSocket.onerror = function(event) {
			alert(event.data);
			chatWindow.innerHTML += "채팅 중 에러가 발생했습니다.<br>";
		}
		
		webSocket.onmessage = function(event) {			
			let message = event.data.split("|");
			let sender = message[0];
			let content = message[1];
			
			if (content != "") {
				if (content.match("/")) {
					if (content.match("/" + chatId)) {
						let temp = content.replace(("/" + chatId), "[귓속말] : ");
						chatWindow.innerHTML += "<div><span class='whisper'>" + sender + "" + temp + "</span></div>";
					}
				}
				else {
					chatWindow.innerHTML += "<div>" + sender + " : " + content + "</div>";
				}
			}
			
			chatWindow.scrollTop = chatWindow.scrollHeight;
		}
	</script>
	
	<style>
		/* 채팅 UI 요소 스타일 지정 */
		#chatWindow { 
		    border: 1px solid black;    /* 대화창 테두리를 검은색 실선으로 설정 */
		    width: 270px;               /* 대화창 너비 설정 */
		    height: 310px;              /* 대화창 높이 설정 */
		    overflow: scroll;           /* 내용이 넘칠 때 스크롤바 표시 */
		    padding: 5px;               /* 내부 여백 설정 */
		}
		
		#chatMessage { 
		    width: 236px;               /* 메시지 입력창 너비 설정 */
		    height: 30px;               /* 메시지 입력창 높이 설정 */
		}
		
		#sendBtn { 
		    height: 30px;               /* 전송 버튼 높이 설정 */
		    position: relative;         /* 전송 버튼 위치 조정을 위해 relative 포지션 설정 */
		    top: 2px;                   /* 버튼을 약간 아래로 이동 */
		    left: -2px;                 /* 버튼을 약간 왼쪽으로 이동 */
		}
		
		#closeBtn { 
		    margin-bottom: 3px;         /* 종료 버튼의 하단 여백 설정 */
		    position: relative;         /* 종료 버튼 위치 조정을 위해 relative 포지션 설정 */
		    top: 2px;                   /* 종료 버튼을 약간 아래로 이동 */
		    left: -2px;                 /* 종료 버튼을 약간 왼쪽으로 이동 */
		}
		
		#chatId { 
		    width: 158px;               /* 대화명 입력창 너비 설정 */
		    height: 24px;               /* 대화명 입력창 높이 설정 */
		    border: 1px solid #AAAAAA;  /* 대화명 입력창 테두리 설정 */
		    background-color: #EEEEEE;  /* 대화명 입력창 배경색 설정 */
		}
		
		.myMsg { 
		    text-align: right;          /* 내 메시지를 오른쪽 정렬로 설정 */
		}
		
		.myMsg span {			
		    background-color: aqua;
		}
		
		.whisper {
			background-color: pink;
		}
	</style>
</head>

<body>
	대화명 : <input type="text" id="chatId" value="${param.chatId}" readonly>
	<button id="closeBtn" onclick="disconnect();">채팅 종료</button>
	<div id="chatWindow"></div>
	<div>
		<input type="text" id="chatMessage" onkeyup="onEnterKey();">
		<button id="sendBtn" onclick="sendMesseage();">전송</button>
	</div>
</body>

</html>