<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
</head>
<body>
<form action="JoinId.jsp" method="post" name="JoinName">
<table>
	<tr>
		<td><h4>한글 (성)</h4></td>
		<td><h4>한글 (이름)</h4한글></td>
	</tr>
	<tr>
		<td><input type="text" name="kFamily" onkeyup="kCheck(this.value)"></td>
		<td><input type="text" name="kName" onkeyup="kCheck(this.value)"></td>
	</tr>
	<tr>
		<td><h4>영문 (성)</h4></td>
		<td><h4>영문 (이름)</h4></td>
	</tr>
	<tr>
		<td><input type="text" name="eFamily"></td>
		<td><input type="text" name="eName"></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="계속">
		</td>
	</tr>
</table>
</form>
</body>
</html>