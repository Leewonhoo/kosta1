<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>detail</title>
</head>
<body>
	<form name="modiForm" action="controller">
		<table border="1">
			<!-- jsp action tag -->
			<jsp:useBean id="dto" class="work.model.dto.Bmember" scope="request"/>
			<tr>
				<th>아이디</th>
				<td>${requestScope.dto.mId}</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>${requestScope.dto.mPw}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${requestScope.dto.mName}</td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>${requestScope.dto.mNick}</td>
			</tr>
			<tr>
				<th>생일</th>
				<td>${requestScope.dto.mBirth}</td>
			</tr>
		</table>
	</form>
</body>
</html>