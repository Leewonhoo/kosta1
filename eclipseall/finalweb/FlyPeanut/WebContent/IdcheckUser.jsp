<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ID 중복확인</title>
<script>
function useId(){
	window.opener.document.getElementById("m_id").value = document.getElementById("m_id").value;
	window.opener.document.getElementById("m_id").readOnly = true;
	self.close();
}
function reinput(){
	document.getElementById("spanner").innerText = "아이디 중복 확인해주세요.";
	document.getElementById("btn_use").disabled = true;
}
</script>
</head>
<body>
<h4>ID 중복 확인</h4>
<hr>
<p>아이디를 사용하시려면 중복확인을 해주세요.</p>
<form action="${PATH}/MemberController" method="post" name="idcheckForm">
<table>
	<tr>
		<td>아이디</td>
		<td>
			<%
				String id = "";
				if ((request.getAttribute("idcheck") != null) && ((boolean)request.getAttribute("idcheck"))){
					id = (String)request.getAttribute("input");
				} else {
					if (request.getAttribute("input") == null) {
						id = request.getParameter("id");
					} else{
						id = (String)request.getAttribute("input");
					}
				}
			%>
			<input type="text" id="m_id" name="m_id" value="<%= id %>" onfocus="reinput()">
			<input type="hidden" name="action" value="m_check">
			<input type="submit" value="중복 확인">
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<span id="spanner"></span>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" name="btn_use" id="btn_use" value="사용" onclick="useId()" disabled>
			<input type="button" value="취소">
		</td>
	</tr>
	<%
		if(request.getAttribute("idcheck") != null){
			if (!(boolean)request.getAttribute("idcheck")){
	%>
		<script>
			document.getElementById("spanner").innerText = "현재 아이디는 사용 가능 합니다.";
			document.idcheckForm.btn_use.disabled = false;
		</script>
			<% } else { %>
		<script>
			document.getElementById("spanner").innerText = "현재 아이디는 사용 불가능 합니다.";
			document.getElementById("btn_use").disabled = true;
		</script>
	<%
			}
		}
	%>
</table>
</form>
</body>
</html>