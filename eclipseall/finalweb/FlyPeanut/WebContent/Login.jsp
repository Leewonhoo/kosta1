<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인</title>
<script type="text/javascript">
function loginchk() {
	var regx = /^[a-zA-Z0-9]*$/;
	var memberid = document.form.m_id.value;
	var memberpw = document.form.m_pw.value;
	if (id.length == 0 || memberid == null) {
		alert("아이디를 입력하시오");
		document.form.memberid.focus();
		return;
	}
	if (!regx.test(memberid)) {
		alert("아이디는 영어, 숫자만 입력가능합니다.");
		document.form.memberid.focus();
		return false;
	}
	if (memberpw.length < 6 || memberpw == null) {
		alert("비밀번호는 6글자이상입니다");
		document.form.memberpw.focus();
		return;
	}
	if (!regx.test(memberpw)) {
		alert("비밀번호는 영어, 숫자만 입력가능합니다.");
		document.form.memberpw.focus();
		return false;
	}
	document.mLoginForm.submit();
}

function modiInfor(){
	<% if (session.getAttribute("userId") != null){%>
		location.href="Passcheck.jsp";
	<%	} else { %>
			alert("로그인해주세요");
	<% } %>
}

function modiPass(){
	<% if (session.getAttribute("userId") != null){%>
		location.href="Repass.jsp";
	<%	} else { %>
			alert("로그인해주세요");
	<% } %>
}
</script>
</head>
<body>
<table>
	<tr>
		<% if (session.getAttribute("userId") != null){ %>
		<%= session.getAttribute("userId") %><span>님 환영합니다.</span><a href="${PATH}/MemberController?action=m_logout">로그아웃</a>
		<% } %>
	</tr>
</table>
<table width="80%">
	<tr style="font-size:22px; font-family:verdana,Courier,Monospace; text-decoration: none; width:150px;">
		<td><a href="UserMain.jsp"><img src="images/LOGO.jpg" width="250px" height="80px"></a></td>
		<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "Reservation.jsp">예매</a></td>
		<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "${PATH}/BoardController?action=b_list">내가 쓴 게시판</a></td>
		<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "#">공지사항</a></td>
		<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "javascript:modiInfor()">개인정보 조회</a></td>
		<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "javascript:modiPass()">PW 변경</a></td>
	</tr>
</table>
<table width="1200" height="500" align="center" border="0">
	<tr>
		<td width="50%" height="70%">
		<form action="${PATH}/MemberController" method="post" name="mLoginForm">
		<table align="center">
			<tr>
				<td>회원 로그인</td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>ID<span style="margin: 5px"/><input type="text" size="10" maxlength="15" name="m_id" id="m_id"></span>
				</td>
				<td rowspan="2" height="10px">
					<input type="hidden" name="action" value="m_login">
					<input type="submit" value="LOGIN" onclick="loginchk()">
				</td>
			</tr>
			<tr>
				<td>
					PW<span style="margin: 5px"/><input type="password" size="10" maxlength="15" name="m_pw" id="m_pw"></span>
				</td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" >
					<input type="button" id="bt_join" name="bt_join" value="회원가입" onclick="location='JoinName.jsp'">
					<input type="button" id="bt_idpw" name="bt_idpw" value="아이디 비밀번호찾기" onclick="location='Search.jsp'">
				</td>
			</tr>
		</table>
		</form>
		</td>
	</tr>
</table>
</body>
</html>