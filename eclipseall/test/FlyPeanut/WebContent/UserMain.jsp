<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type = "text/css" rel = "stylesheet" href = "css/MainStyle.css">
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

	<div align="right">
	<% if (session.getAttribute("userId") != null){ %>
	<%= session.getAttribute("userId") %><span>님 환영합니다.</span><a href="${PATH}/MemberController?action=m_logout">로그아웃</a>
	<% }else{%>
	<a href="Login.jsp">로그인</a>
	<% }%>
	</div>
	
	

	<table width="90%">
		<tr style="font-size:22px; font-family:verdana,Courier,Monospace; text-decoration: none; width:150px;">
			<td><a href="UserMain.jsp"><img src="images/LOGO.jpg"
					width="250px" height="80px"></a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "Reservation.jsp">예매</a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "${PATH}/BoardController?action=b_list">내가 쓴 게시판</a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "MainController?action=noticemain">공지사항</a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "javascript:modiInfor()">개인정보 조회</a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "javascript:modiPass()">PW 변경</a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "Index.jsp">관계자 Page</a></td>

		</tr>
	</table>
	<table>
		<tr>
			<td><img src="images/Seoul.JPG" width="320px" height="546px">
			</td>
			<td><img src="images/Busan.JPG" width="320px" height="546px">
			</td>
			<td><img src="images/Japan.JPG" width="320px" height="546px"></td>
			<td><img src="images/Moldiv.JPG" width="320px" height="546px">
			</td>
		</tr>

	</table>
</body>
</html>