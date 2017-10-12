<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">

	function loginchk() {
		var regx = /^[a-zA-Z0-9]*$/;
		var e_id = document.form.e_id.value;
		var e_pw = document.form.e_pw.value;
		if (id.length == 0 || e_id == null) {
			alert("아이디를 입력하시오");
			document.form.e_id.focus();
			return false;
		}
		if (!regx.test(e_id)) {
			alert("아이디는 영어, 숫자만 입력가능합니다.");
			document.form.e_id.focus();
			return false;
		}
		if (e_pw.length < 6 || e_pw == null) {
			alert("비밀번호는 6글자이상입니다");
			document.form.e_pw.focus();
			return false;
		}
		if (!regx.test(e_pw)) {
			alert("비밀번호는 영어, 숫자만 입력가능합니다.");
			document.form.e_pw.focus();
			return false;
		}
		document.employLoginForm.submit();
	}
</script>
</head>
<body>
<table width="1340" height="650" border="0">
  <tr>
  <td rowspan="3" width="10%" ></td>
   <td colspan="4" width="80%" height="15%">
   		<a href="Index.jsp">
		<img src="images/LOGO.jpg" width="200" height="100"></a>
		피넛에어 통합관리자 페이지입니다.
		<hr>
	</td>
   <td rowspan="3" width="10%" ></td>
  </tr>
  <tr>
   <td width="80%" height="70%">
   	<table align="center">
   		<tr>
   		<td>
   		<form action="Controller" method="post" name="employLoginForm">
		<table align="right" style="padding-right:40px;" >
			<tr>
				<td>직원로그인</td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>ID(사번)
					<input type="text" size="10" maxlength="15" name="e_id" id="e_id">
				</td>
				<td rowspan="2" height="10px">
					<input type="hidden" name="action" value="e_login">
					<input type="submit" id="login" name="login" value="LOGIN" onclick="return loginchk()">
				</td>
			</tr>
			<tr>
				<td>PW&nbsp;&nbsp; &nbsp;&nbsp; 
					<input type="password" size="10" maxlength="15" name="e_pw" id="e_pw">
				</td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" >
					<input type="button" id="bt_join" name="bt_join" value="회원가입" onclick="location='Join.jsp'"> 
					<input type="button" id="bt_resetpw" name="bt_resetpw" value="비밀번호찾기" onclick="location='FindPw.jsp'">
				</td>
			</tr>
		</table>
		</form>
   		</td>
   		<td>
   		<form action="${PATH}/Controller" method="post" name="form1">
		<table align="left" style="padding-right:40px" >
			<tr>
				<td>관리자로그인</td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>ID &nbsp; <input type="text" size="10" maxlength="15" name="a_id" id="a_id">
				</td>
				<td rowspan="2" height="10px">
					<input type="hidden" name="action" value="a_login">
					<input type="submit" id="login" name="login" value="LOGIN" onclick="loginchk()">
				</td>
			</tr>
			<tr>
				<td>PW  <input type="password" size="10" maxlength="15" name="a_pw" id="a_pw">
				</td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;</td>
			</tr>
		</table>
		</form>
   		</td>
   		</tr>
   	</table>
   </td>
  </tr>
  <tr>
   <td colspan="4" width="100%" height="15%">
   </td>
  </tr>
 </table>
</body>
</html>