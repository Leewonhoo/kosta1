<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>정보확인</title>
</head>
<body>
<form name="pwcheckForm" action="${PATH}/MemberController?action=pw_infor" method="post">
<table>
	<% if (request.getAttribute("message") != null){ %>
		<script>alert("<%=request.getAttribute("message")%>")</script>
	<% } %>
	<tr>
		<td>
			<span>개인정보 확인을 위한 비밀번호를 입력해주세요.</span>
		</td>
	</tr>
	<tr>
		<td>
			<input type="password" name="check_pw">
			<input type="submit" value="확인">
		</td>
	</tr>
</table>
</form>
</body>
</html>