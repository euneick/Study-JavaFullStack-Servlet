<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	request.setCharacterEncoding("UTF-8");
	String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
	<form action="#">
		<table width="90%" border="0" cellspacing="0" cellpadding="0">
			<tr height="40">
				<td width="41%" style="text-align: left">&nbsp;&nbsp;&nbsp; <img
					src="<%=contextPath%>/Board/images/board02.gif" width="150"
					height="30">
				</td>
				<td width="57%">&nbsp;</td>
				<td width="2%">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3"><div align="center">
						<img src="<%=contextPath%>/Board/images/line_870.gif" width="870" height="4">
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
								<td colspan="3" valign="top">
									<div align="center">
										<table width="100%" height="373" border="0" cellpadding="0"
											cellspacing="1" class="border1">
											<tr>
												<td width="13%" height="29" bgcolor="#e4e4e4" class="text2">
													<div align="center">작 성 자</div>
												</td>
												<td width="34%" bgcolor="#f5f5f5" style="text-align: left">
													<input type="text" name="writer" size="20" class="text2"
														value="<%=name%>" readonly />
												</td>
												<td width="13%" height="29" bgcolor="#e4e4e4" class="text2">
													<div align="center">아 이 디</div>
												</td>

												<td width="34%" bgcolor="#f5f5f5" style="text-align: left">
													<input type="text" name="writer_id" size="20" class="text2"
														value="" readonly />
												</td>
											</tr>
											<tr>
												<td width="13%" bgcolor="#e4e4e4">
													<div align="center">
														<p class="text2">메일주소</p>
													</div>
												</td>
												<td colspan="3" bgcolor="#f5f5f5" style="text-align: left">
													<input type="text" name="email" size="40" class="text2"
														value="" readonly />
												</td>
											</tr>
											<tr>
												<td height="31" bgcolor="#e4e4e4" class="text2">
													<div align="center">제&nbsp;&nbsp;&nbsp;목</div>
												</td>
												<td colspan="3" bgcolor="#f5f5f5" style="text-align: left">
													<input type="text" name="title" size="70" />
												</td>
											</tr>
											<tr>
												<td bgcolor="#e4e4e4" class="text2">
													<div align="center">내 &nbsp;&nbsp; 용</div>
												</td>
												<td colspan="3" bgcolor="#f5f5f5" style="text-align: left">
													<textarea name="content" rows="15" cols="100"></textarea>
												</td>
											</tr>
											<tr>
												<td bgcolor="#e4e4e4" class="text2">
													<div align="center">패스워드</div>
												</td>
												<td colspan="3" bgcolor="#f5f5f5" style="text-align: left">
													<input type="password" name="pass" />
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
								<td width="48%">
									<!-- 등록 버튼 -->
									<div align="right">
										<a href="" id="registration1"> <img
											src="<%=contextPath%>/Board/images/confirm.gif" border="0" />
										</a>
									</div>
								</td>
								<td width="10%">
									<!-- 목록보기 -->
									<div align="center">
										<a href="" id="list"> <img
											src="<%=contextPath%>/Board/images/list.gif" border="0" />
										</a>
									</div>
								</td>
								<td width="42%" id="resultInsert"></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
	</form>


	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>	
	<script type="text/javascript">
	</script>
</body>

</html>