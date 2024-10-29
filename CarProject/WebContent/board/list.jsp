<%@page import="VOs.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String contextPath = request.getContextPath(); 
%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	
	<link rel="stylesheet" type="text/css" href="/MVCBoard/style.css"/>
	<script type="text/javascript">
		function fnSearch() {
			var word = document.getElementById("word").value;
			
			if (word == null || word == "") {
				alert("검색어를 입력하세요.");
				document.getElementById("word").focus();
				
				return false;
			}
			else {
				document.frmSearch.submit();
			}
		}		
	</script>
</head>

<body>
<%
	String id = (String) session.getAttribute("id");

	ArrayList<BoardVO> boardsList = (ArrayList<BoardVO>) request.getAttribute("boardsList");
	int totalListCount = boardsList.size();
%>
	<table width="97%" border="0" cellspacing="0" cellpadding="0">
		<tr height="40"> 
			<td width="46%" style="text-align: left"> 
				&nbsp;&nbsp;&nbsp; <img src="<%=contextPath%>/board/images/board02.gif" width="150" height="30">
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
			<td colspan="3" valign="top">
				<div align="center"> 
		    	<table width="95%" border="0" cellspacing="0" cellpadding="0">
		        	<tr> 
		        		<td colspan="4" style="height: 19px">&nbsp;</td> 
		        	</tr>
		        	<tr>
		        		<td colspan="4" style="height: 19px">
		        			<img src="<%=contextPath%>/board/images/ink.gif" width="875" height="100">
		        		</td>
		        	</tr>
		        	<tr> 
		        		<td colspan="4">
							<table border="0" width="100%" cellpadding="2" cellspacing="0">
								<tr align="center" bgcolor="#D0D0D0" height="120%">
									<td align="left">번호</td>
									<td align="left">제목</td>
									<td align="left">이름</td>
									<td align="left">날짜</td>
									<td align="left">조회수</td>
								</tr>
							<%
								if (boardsList.isEmpty()) {
								%>
									<tr align="center">
										<td colspan="5">작성된 게시글이 없습니다.</td>
									</tr>
								<%
								}
								else {
									for(int i = 0; i < totalListCount; i++) {
										BoardVO board = boardsList.get(i);										
									%>
										<tr align="center" height="120%">
											<td align="left"><%=board.getIdx()%></td>
											<td align="left"><%=board.getTitle()%></td>
											<td align="left"><%=board.getName()%></td>
											<td align="left"><%=board.getDate()%></td>
											<td align="left"><%=board.getCnt()%></td>
										</tr>										
									<%
									}
								}
							%>
							</table>
		        		</td>
		        	</tr>
		        	<tr>
		        		<td colspan="4">&nbsp;</td>
		        	</tr>
		        	<tr>
		        		<td colspan="4">&nbsp;</td>
		        	</tr>
					<tr>
						<form action="<%=contextPath%>/Board/searchlist.bo" 
								method="post" 
								name="frmSearch" onsubmit="javascript:fnSearch();">
			            	<td colspan="2">
			            		<div align="right"> 
				            		<select name="key">
				              			<option value="titleContent">제목 + 내용</option>
				              			<option value="name">작성자</option>
				              		</select>
				              	</div>
			              	</td>
				            <td width="26%">
				            	<div align="center"> &nbsp;
				            		<input type="text" name="word" id="word"/>
				            		<input type="submit" value="검색"/>
				            	</div>
				            </td>
			            </form>
			            <td width="38%" style="text-align: left">			                      
			            <%
			            	if (id != null) {
		            		%>
		            			<input type="image" id="newContent" 
		            					src="<%=contextPath%>/borad/images/write.gif"
		            					onclick="location.href='<%=contextPath%>/Board/write.bo';">
		            		<%
			            	}
			            %>
			            </td>
		            </tr>
		       		<tr>
		       			<td colspan="4">&nbsp;</td>
		       		</tr>
				</table>
				</div>
		 	</td>
		</tr>
		<tr align="center"> 
			<td colspan="3" align="center">Go To Page</td> 
		</tr>
	</table>
</body>

</html>