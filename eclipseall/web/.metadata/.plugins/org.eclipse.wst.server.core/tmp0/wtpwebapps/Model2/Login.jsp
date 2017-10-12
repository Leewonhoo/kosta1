<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
	<h3>세션 로긴</h3>
	세션 ID : <%= session.getId() %>
	신규 ID : <%= session.isNew() %>
	세션 값  : <%= session.getValue(session.getId()) %>
	<hr>
	회원가입 : <%= request.getAttribute("Message") %>
	<a href="Register.jsp">회원가입</a>
	<form method="post" action="controller">
		<table width="200px">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberId"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="memberPw"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="action" value="login"></td>
			</tr>
			<tr>
				<td><input type="submit" value="로그인"></td>
				<td><input type="reset" value="초기화"></td>
			</tr>
		</table>
	</form>
</body>
</html>