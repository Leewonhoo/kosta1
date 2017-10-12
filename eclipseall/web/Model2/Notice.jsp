<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="List.jsp">
	<table border="1">
		<tr>
			<td width="30%">공지번호</td>
			<td width="30%">제목</td>
			<td width="30%">내용</td>
		</tr>
		<tr>
			<td><input type="text" name="number"></td>
			<td><input type="text" name="title"></td>
			<td><input type="text" name="memo"></td>
		</tr>
	</table>
	<input type="submit" value="input">
	</form>
</body>
</html>