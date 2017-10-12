<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">

	function selectEmail(email) {
		if (findpw.e_email1.value.trim().length == 0) {
			alert("이메일을 입력해주세요");
			document.findpw.e_email1.focus();
			console.log(email);
			console.log(email.options[0].values);
			findpw.emailSelected.value = email.options[0].value;
			console.log(email.options[0].value);
			
		} else if (email.value == "직접 입력") {
			findpw.e_email2.value = "";
			document.findpw.e_email2.readOnly = false;
			findpw.e_email2.style.background = "#ffffff";
			
		} else {
			findpw.e_email2.value = email.value;
			document.findpw.e_email2.readOnly = true;
		}
	}
</script>
</head>
<body>
<table width="1340" height="650" border="1">
  <tr>
  <td rowspan="3" width="10%" ></td>
   <td colspan="4" width="80%" height="15%">
   		<a href="Index.jsp"><img src="images/logo.jpg" width="200" height="100"></a>
		피넛에어 통합관리자 페이지입니다.<hr>
	</td>
   <td rowspan="3" width="10%" ></td>
  </tr>
  <tr>
   <td width="80%" height="70%" align="center">
   	<form method="post" action="Controller" name="findpw">
	<table>
		<tr>
			<th>사번</th>
			<td><input type="text" name="e_id" id="e_id" size="20" maxlength="20"></td>
		</tr>
		<tr>
			<th>이름(한글)</th>
			<td><input type="text" name="e_kname" id="e_kname" size="20" maxlength="20"></td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><input type="text" name="e_birthyear" id="e_birthyear" size="10" maxlength="4">년 
				<select name="e_birthmonth" id="e_birthmonth"><option value="선택">선택</option>
					<option value="1">01</option>
					<option value="2">02</option>
					<option value="3">03</option>
					<option value="4">04</option>
					<option value="5">05</option>
					<option value="6">06</option>
					<option value="7">07</option>
					<option value="8">08</option>
					<option value="9">09</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
				</select>월 
				<select name="e_birthdate" id="e_birthdate"><option value="선택">선택</option>
					<option value="1">01</option><option value="2">02</option><option value="3">03</option><option value="4">04</option><option value="5">05</option>
					<option value="6">06</option><option value="7">07</option><option value="8">08</option><option value="9">09</option><option value="10">10</option>
					<option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option>
					<option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option>
					<option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option>
					<option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option>
					<option value="31">31</option>
				</select>일 
			</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="e_email1" id="e_email1" size=10 maxlength="20">@ 
					<input type="text" name="e_email2" id="e_email2" size=10 maxlength="20" > 
					<select name="emailSelected" id="emailSelected" onchange="selectEmail(this)">
						<option value="직접입력">직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="nate.com">nate.com</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="daum.com">daum.com</option>
						<option value="gmail.com">gmail.com</option>
					</select>
				</td>
			</tr>
	</table><br>
	<input type="hidden" name="action" value="findPw"> <input type="submit" name="submit" id="submit" value="임시 비밀번호 받기"> 
	<input type="button" name="cancel" id="cancel" value="취소" onclick="location='Index.jsp'">
	</form>
   </td>
  </tr>
  <tr>
   <td colspan="4" width="100%" height="15%">
   </td>
  </tr>
 </table>
</body>
</html>