<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 합시다!</title>

<script type="text/javascript">

/*아이디 설정*/
function idonfocus(){
	var id = document.getElementById("id");
	id.value = "";
}
/*아이디 설정*/
function idonblur(){
	var id = document.getElementById("id");
	var status = document.getElementById("logstatus");
	var pw = document.getElementById("pass");
	if (id.value.trim().length < 1){
		id.value = "아이디 입력";
		status.innerText = "아이디를 입력해주세요.";
	} else if (id.value.trim().length < 4){
		status.innerText = "비밀번호는 4자 이상 입니다.";
	} else {
		if (pw.type == "text"){
			status.innerText = "비밀번호 입력";
			pw.focus();
		} else {
			status.innerText = "로그인해주세요~~";
		}
	}
}
/*비밀번호 설정*/
function pwonfocus(){
	var pw = document.getElementById("pass");
	pw.value = "";
	pw.type = "password";
}
/*비밀번호 설정*/
function pwonblur(){
	var id = document.getElementById("id");
	var status = document.getElementById("logstatus");
	var pw = document.getElementById("pass");
	if (pw.value.trim().length < 1){
		pw.value = "비밀번호 입력";
		pw.type = "text";
		status.innerText = "비밀번호를 입력해주세요.";
	} else if (pw.value.trim().length < 6){
		status.innerText = "비밀번호는 6자 이상 입니다.";
	} else {
		if (id.value.trim().length > 6) {
			status.innerText = "아이디 입력";
			id.focus();
		} else {
			status.innerText = "로그인해주세요~~";
		}
	}
}
</script>

</head>
<body>
	<form action="Service.jsp" name="loginForm">
		<table border="1" align="center">
			<tr>
				<!-- 로그인 전 -->
				<td align="center">
					<input id="id" name="id" type="text" value="아이디 입력 go!" maxlength="6" onfocus="idonfocus()" onblur="idonblur()">
				</td>
			</tr>
			<tr>
				<td align="center">
					<input id="pass" name="pass" type="text" value="비밀번호 입력 go!" maxlength="10" onfocus="pwonfocus()" onblur="pwonblur()">
				</td>
			<tr height="50px">
				<td width="200px" align="center">
					<span id="logstatus"></span>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="로그인" style="height: 50px;"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<a href="Search.jsp">ID/PW 찾기</a>
					<a href="Register.jsp">회원 가입</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>