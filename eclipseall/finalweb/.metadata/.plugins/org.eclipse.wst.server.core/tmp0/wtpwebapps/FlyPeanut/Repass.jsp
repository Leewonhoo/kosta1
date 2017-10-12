<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>비밀번호 설정</title>
</head>
<body>
<div align="right">
	<% if (session.getAttribute("userId") != null){ %>
	<%= session.getAttribute("userId") %><span>님 환영합니다.</span><a href="${PATH}/MemberController?action=m_logout">로그아웃</a>
	<% }else{%>
	<a href="Login.jsp">로그인</a>
	<% }%>
	</div>
	
	

	<table width="90%">
		<tr style="font-size:22px; font-family:verdana,Courier,Monospace; text-decoration: none; width:150px;">
			<td><a href="UserMain.jsp"><img src="images/LOGO.jpg"
					width="250px" height="80px"></a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "Reservation.jsp">예매</a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "${PATH}/BoardController?action=b_list">내가 쓴 게시판</a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "#">공지사항</a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "javascript:modiInfor()">개인정보 조회</a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "javascript:modiPass()">PW 변경</a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "Index.jsp">관계자 Page</a></td>

		</tr>
	</table>
<form name="rePass" action="${PATH}/MemberController" method="post">
<table>
	<tr>
		<td>현재 비밀번호</td>
		<td width="220px" align="right">
			<input type="password" name="gu_pw">
		</td>
	</tr>
	<tr>
		<td>새 비밀번호</td>
		<td width="220px" align="right">
			<input type="password" name="new_pw">
		</td>
	</tr>
	<tr>
		<td>비밀번호 확인</td>
		<td width="220px" align="right">
			<input type="password" name="new_confirm">
		</td>
	</tr>
	<tr><td><br></td></tr>
	<tr>
		<td colspan="2" align="right">
			<input type="hidden" name="action" value="re_pass">
			<input type="submit" value="비밀번호 변경">
		</td>
	</tr>
</table>
</form>
</body>
</html>