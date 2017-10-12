<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<script type="text/javascript">
	function loginchk() {
		var regx = /^[a-zA-Z0-9]*$/;
		var memberid = document.form.memberid.value;
		var memberpw = document.form.memberpw.value;
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
		document.form.submit();
	}
</script>
<title>로그인</title>
</head>
<body>

	<table width="1400" height="650" align="center">
		<tr>
			<td colspan="2" width="100%" height="15%"><a href="#"><img
					src="images/LOGO.jpg" width="100" height="50"></a> 피넛에어 통합관리자 페이지입니다.
				<hr>
			</td>
		</tr>
		<tr>
			<td width="50%" height="70%">
				<form action="MainController" method="post" name="form1">

					<table align="center" >
						<tr>
							<td>직원로그인</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td>ID(사번) : <input type="text" size="10" maxlength="15"
								name="memberid" id="memberid">
							</td>
							<td rowspan="2" height="10px"><input type="submit"
								id="login" name="login" value="LOGIN" onclick="loginchk()"></td>
						</tr>
						<tr>
							<td>PW&nbsp;&nbsp; :&nbsp;&nbsp; <input type="password"
								size="10" maxlength="15" name="memberpw" id="memberpw">
							</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;</td>
						</tr>
						<tr >
							<td colspan="2" ><input type="button" id="bt_join" name="bt_join"
								value="회원가입" onclick="location='Join.jsp'"> <input type="button" id="bt_resetpw"
								name="bt_resetpw" value="비밀번호찾기" onclick="location='ResetPw.jsp'">
							</td>
						</tr>
					</table>
				</form>
			</td>
			<td width="50%" height="70%">
				<form action="MainController" method="post" name="form1">

					<table align="center" >
						<tr>
							<td>관리자로그인</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td>ID : <input type="text" size="10" maxlength="15"
								name="memberid" id="memberid">
							</td>
							<td rowspan="2" height="10px">
							<input type="submit" id="login" name="login" value="LOGIN" onclick="loginchk()"></td>
						</tr>
						<tr>
							<td>PW : <input type="password"
								size="10" maxlength="15" name="memberpw" id="memberpw">
							</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;</td>
						</tr>
						
					</table>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2" width="100%" height="15%"></td>
		</tr>
	</table>
</body>
</html>