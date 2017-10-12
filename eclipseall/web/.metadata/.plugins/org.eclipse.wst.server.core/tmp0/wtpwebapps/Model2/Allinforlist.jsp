<%@page import="work.model.dto.Bmember"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<Bmember> list = (ArrayList)request.getAttribute("dto");
	%>
	<table border="1" width="30%">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>닉네임</th>
			<th>성별</th>
		</tr>
		<% Bmember dto1 = null; %>
		<c:forEach var="${pageScope.dto1}" items="${requestScope.list}">
			<tr>
				<td><a href="controller?action=memdetail">${dto1.mId}</a></td>
				<td>${dto1.mName}</td>
				<td>${dto1.mNick}</td>
				<td>${dto1.mGender}</td>
			</tr>
		</c:forEach>
		
	</table>
	<pre>아이디 클릭시 상세 정보 출력ㅎㅎ</pre>
</body>
</html>