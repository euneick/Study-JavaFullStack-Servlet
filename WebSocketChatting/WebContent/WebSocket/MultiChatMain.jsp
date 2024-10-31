<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>웹 소켓 채팅</title>
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
	<h2>웹 소켓 채팅 - 대화명 적용해서 채팅창 띄워주기</h2>
	대화명 : <input type="text" id="chatId">
	<button onclick="openChatWindow();">채팅 참여</button>
	
	
	<script type="text/javascript">
		function openChatWindow() {
			
			let chatId = $("#chatId");
			
			if (chatId.val() == "") {
				alert("대화명을 입력 후 채팅창을 열어주세요.");
				chatId.focus();
				
				return;
			}
			
			window.open("ChatWindow.jsp?chatId=" + chatId.val(), "", "width=320, height=400");
			chatId.val() = "";
		}
	</script>
</body>

</html>