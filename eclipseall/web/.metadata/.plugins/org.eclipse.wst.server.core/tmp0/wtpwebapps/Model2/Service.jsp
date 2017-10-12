<%@page import="work.model.dto.Bmember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>service</title>

<script type="text/javascript">
function allinfor(){
	document.servicepage.action.value="allList";
	document.servicepage.submit();
}
</script>

</head>
<body>
	<h3>service</h3>
	<h3>${initParam.webname}</h3>
	<h3>${initinforScope.getAttribute("webage")}</h3>
	<form name="servicepage" method="post" action="controller">
		<table border="1">
			<tr>
				<td>user</td>
				<td><%= session.getAttribute("userId") %></td>
			</tr>
			<tr>
				<td>
					<input type="button" onclick="btn_idSearch()">
				</td>
				<td>
					<input type="hidden" name="action" value="infor">
					<input type="submit"  value="회원 정보 호출">
					<input type="button"  value="모든 회원 정보 호출" onclick="allinfor()">
				</td>
			</tr>
			<tr>
				<td>
					<a href="controller?action=logout">로그아웃</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>