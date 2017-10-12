<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>비밀번호 설정</title>
</head>
<body>
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