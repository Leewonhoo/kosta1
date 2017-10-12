<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@page import="work.model.dto.NoticeDto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type = "text/css" rel = "stylesheet" href = "css/MainStyle.css">
<title>Insert title here</title>
</head>
<body>

<table>
		<tr>
			<td colspan="7" width="1536px" height="20px" align="right"><a href="Login.jsp">세션부분</a> </a></td>
		</tr>
	</table>
	<table width="100%">
		<tr style="font-size:22px; font-family:verdana,Courier,Monospace; text-decoration: none;">
			<td><a href="MainPage.jsp"><img src="images/LOGO.jpg"
					width="250px" height="80px"></a></td>
			<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "#">티켓</a></td>
			<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "MainController?action=airplanemain">비행기</a></td>
			<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "FilghtMain.jsp">운항일지</a></td>
			<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "MainController?action=noticemain">공지사항</a></td>
			<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "#">Peanut Talk</a></td>
			<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "#">MyPage</a></td>
			<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "AdminPage.jsp">FlyPeanut</a></td>
		</tr>
	</table>

<% 
	if (request.getAttribute("noticeview") != null) {
		NoticeDto ndto = (NoticeDto)request.getAttribute("noticeview"); 
	
%>
			<table width = "500" border = "1" cellpadding = "0" cellspacing = "0" align = "center">
			<h3 align="center">공지사항 상세보기</h3>	
			<tr>
				<td width = "40%" align = "left">제목</td>
				<td width = "60%" align = "left"><%= ndto.getnTitle() %></td>
			</tr>
			<tr>
				<td width = "40%" align = "left">내용</td>
				<td width = "60%" align = "left">
					<textarea name="contents" rows=5 cols=50 readonly><%= ndto.getnContents() %></textarea>
				</td>
			</tr>
			<tr>
				<td width = "40%" align = "left">작성일</td>
				<td width = "60%" align = "left"><%= ndto.getnDate() %></td>
			</tr>
			<tr>
				<td width = "100%" align = "center" colspan = "2">
				<table>
					<tr>
						<td   align = "center">
							<a href = "#">목록으로</a>
						</td>
					</tr>
				</table>
				<%
				} 
				%>
				
				</td>
			</tr>
		</table>
		
</body>
</html>