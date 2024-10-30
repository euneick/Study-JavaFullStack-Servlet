<%@page import="VOs.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String contextPath = request.getContextPath();

	BoardVO board = (BoardVO) request.getAttribute("board");
	
	String name = board.getName();
	String email = board.getEmail();
	String title = board.getTitle();
	String content = board.getContent().replace("/r/n", "<br>");

	String idx = (String) request.getAttribute("idx");
	String currentPage = (String) request.getAttribute("currentPage");
	String currentBlock = (String) request.getAttribute("currentBlock");
	
	String loginedId = (String) session.getAttribute("id");
	
	if (loginedId == null) {
	%>
		<script>
			alert("로그인이 필요합니다.");
			history.back();
		</script>
	<%
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>글 수정 화면</title>
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
	<table width="80%" border="0" cellspacing="0" cellpadding="0">
		<tr height="40">
			<td width="41%" style="text-align: left">
				&nbsp;&nbsp;&nbsp;
				<img src="<%=contextPath%>/board/images/board02.gif" width="150" height="30">
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<div align="center">
					<img src="<%=contextPath%>/board/images/line_870.gif" width="870" height="4">
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<div align="center">
					<table width="95%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="20" colspan="3"></td>
						</tr>
						<tr>
							<td height="327" colspan="3" valign="top">
								<div align="center">
									<table width="95%" height="373" border="0" cellpadding="0"
										cellspacing="1" class="border1">
										<tr>
											<td width="13%" height="29" bgcolor="#e4e4e4" class="text2">
												<div align="center">작 성 자</div>
											</td>
											<td width="34%" bgcolor="#f5f5f5" style="text-align: left">
												&nbsp;&nbsp;
												<input type="text" name="writer" id="writer" value="<%=name%>" disabled>
											</td>
											<td width="13%" bgcolor="#e4e4e4">
												<div align="center">
													<p class="text2">이메일</p>
												</div>
											</td>
											<td width="40%" bgcolor="#f5f5f5" style="text-align: left">
												&nbsp;&nbsp;
												<input type="email" name="email" id="email" value="<%=email%>" disabled>
											</td>
										</tr>
										<tr>
											<td height="31" bgcolor="#e4e4e4" class="text2">
												<div align="center">제&nbsp;&nbsp;&nbsp; &nbsp; 목</div>
											</td>
											<td colspan="3" bgcolor="#f5f5f5" style="text-align: left">
												&nbsp;&nbsp; 
												<input type="text" name="title" id="title" value="<%=title%>" disabled>
											</td>
										</tr>
										<tr>
											<td height="245" bgcolor="#e4e4e4" class="text2">
												<div align="center">내 &nbsp;&nbsp; 용</div>
											</td>
											<td colspan="3" bgcolor="#f5f5f5"
												style="text-align: left; vertical-align: top;">
												&nbsp;
												<textarea rows="20" cols="100" name="content" id="content" disabled><%=content%></textarea>
											</td>
										</tr>
										<tr>
											<td bgcolor="#e4e4e4" class="text2">
												<div align="center">패스워드</div>
											</td>
											<td colspan="2" bgcolor="#f5f5f5" style="text-align: left">
												<input type="password" name="pass" id="pass" />
											</td>
											<td colspan="2" bgcolor="#f5f5f5" style="text-align: left">
												<p id="pwInput"></p>
											</td>
										</tr>
									</table>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3">&nbsp;</td>
						</tr>
						<tr>
							<td style="width: 48%">
								<div align="right" id="menuButton">
									<%--수정하기 --%>
									<input type="image"
										src="<%=contextPath%>/board/images/update.gif" id="update"
										style="visibility: hidden" />
									&nbsp;&nbsp;
									<%--삭제하기 --%>
									<input type="image"
										src="<%=contextPath%>/board/images/delete01.gif" id="delete"
										onclick="javascript:deletePro('<%=idx%>');"
										style="visibility: hidden" />
									&nbsp;&nbsp;
									<%--답변달기 --%>
									<input type="image"
										src="<%=contextPath%>/board/images/reply.gif" id="reply" />
									&nbsp;&nbsp;
								</div>
							</td>
							<td width="10%">
								<div align="center">
									<input type="image"
										src="<%=contextPath%>/board/images/list.gif" id="list"
										onclick="location.href='<%=contextPath%>/Board/list.bo?currentBlock=<%=currentBlock%>&currentPage=<%=currentPage%>'" />
									&nbsp;
								</div>
							</td>
							<td width="42%"></td>
						</tr>
						<tr>
							<td colspan="3" style="height: 19px">&nbsp;</td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
	
	<form>
		<input type="hidden" name="idx" value="<%=idx%>" id="idx">
	</form>

	<script type="text/javascript">
		$("#pass").on("focusout", function() {
			
			$.ajax({
				url: "<%=contextPath%>/Board/password.bo",
				type: "post",
				async: true,
				data: {
					idx: <%=idx%>,
					pass: $("#pass").val()
				},
				dataType: "text",
				success: function(responsedData) {

					let result = (responsedData === "true");
					
					$("#pwInput")
						.text(result ? "글의 비밀번호가 일치합니다." : "글의 비밀번호가 일치하지 않습니다.")
						.css("color", result? "blue" : "red");
					
					document.getElementById("email").disabled = !result;
					document.getElementById("title").disabled = !result;
					document.getElementById("content").disabled = !result;
					
					$("#update").css("visibility", result? "visible" : "hidden");
					$("#delete").css("visibility", result? "visible" : "hidden");
				},
				error: function() {
					alert("비동기 통신 장애");
				}
			});
		});
		
		$("#update").click(function() {
			
			$.ajax({
				url: "<%=contextPath%>/Board/update.bo",
				type: "post",
				async: true,
				data: {
					email: $("#email").val(),
					title: $("#title").val(),
					content: $("#content").val(),
					idx: <%=idx%>
				},
				dataType: "text",
				success: function(responsedData) {
					
					let result = (responsedData === "true");
					
					$("#pwInput")
						.html(result ? "<strong>게시글을 수정했습니다.</strong>" : "게시글 수정에 실패했습니다.")
						.css("color", result ? "green" : "red");
					
					document.getElementById("email").disabled = result;
					document.getElementById("title").disabled = result;
					document.getElementById("content").disabled = result;
				},
				error: function() {
					alert("비동기 통신 장애");
				}
			});
		});
	</script>
</body>

</html>