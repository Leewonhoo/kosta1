<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>아이디 찾기</title>
</head>
<body>
<form action="${PATH}/MemberController" name="idsearchForm" method="post">
<table>
	<tr>
		<td>이름</td>
		<td>
			<input type="text" name="name_search">
		</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td>
			<select name="mobile_search1" style="width: 80px" onchange="sel_mobile()">
				<option value="0">선택</option><option value="010">010</option>
				<option value="011">011</option><option value="016">016</option>
				<option value="017">017</option><option value="018">018</option>
				<option value="019">019</option>
			</select>
			<span>-</span><input type="text" name="mobile_search2" style="width: 80px" onkeyup="in_mobile()" maxlength="4">
			<span>-</span><input type="text" name="mobile_search3" style="width: 80px" maxlength="4">
		</td>
	</tr>
	<% if (request.getAttribute("selectId") != null){ %>
		<tr>
			<td colspan="2" align="center">
				<%= request.getAttribute("selectId") %>
			</td>
		</tr>
	<% } %>
	<tr>
		<td colspan="2" align="center">
			<input type="hidden" name="action" value="m_id">
			<input type="submit" value="아이디 찾기">
			<input type="button" value="로그인" onclick="location.href='Login.jsp'">
			<input type="button" value="메인" onclick="location.href='Login.jsp'">
		</td>
	</tr>
</table>
</form>
</body>
</html>