<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.Calendar"%>
<%
	request.setCharacterEncoding("EUC-KR");
	
	Calendar cal = Calendar.getInstance();
   	int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH) + 1;
    int day = cal.get(Calendar.DATE);
    int endday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입 상세입력</title>
<script>
function btn_idcheck(){
	url = "Idcheck.jsp?id="+document.getElementById("m_id").value;
	window.open(url,'opner','width=400,height=300');
}
function sel_mobile(){
	var mobile1 = document.joinIdForm.m_mobile1;
	if (mobile1.value != 0){
		document.joinIdForm.m_mobile2.focus();
	}
}
function in_mobile(){
	var mobile2 = document.joinIdForm.m_mobile2;
	if (mobile2.value.length >= 4) {
		document.joinIdForm.m_mobile3.focus();
	}
}
function sel_domain(){
	var domain1 = document.joinIdForm.m_domain1;
	var domain2 = document.joinIdForm.m_domain2;
	if (domain2.value == 0){
		domain1.readOnly = true;
		domain1.value = "";
	} else if (domain2.value == 9) {
		domain1.readOnly = false;
		domain1.value = "";
	} else {
		domain1.readOnly = true;
		domain1.value = domain2.value;
	}
}
function checkpw(value){
	if (document.joinIdForm.m_pw.value != value){
		document.getElementById("pw_comment").innerText = "비밀번호가 일치하지 않습니다.";
		document.getElementById("pw_comment").style.color = "red";
	} else {
		document.getElementById("pw_comment").innerText = "비밀번호가 일치합니다.";
		document.getElementById("pw_comment").style.color = "blue";
	}
}
function popup1(value){
	if (value == "Y"){
		document.getElementById("s_pop").innerText = "";
	} else {
		document.getElementById("s_pop").innerText = "이벤트 등 행사에 관한 불이익을 받으실 수 있습니다.";
		document.getElementById("s_pop").style.color = "red";
	}
}
function popup2(value){
	if (value == "Y"){
		document.getElementById("e_pop").innerText = "";
	} else {
		document.getElementById("e_pop").innerText = "이벤트 등 행사에 관한 불이익을 받으실 수 있습니다.";
		document.getElementById("e_pop").style.color = "red";
	}
}
</script>
</head>
<body>
<h4>회원 가입</h4>
<form name="joinIdForm" action="${PATH}/MemberController" method="post">
<input type="hidden" name="m_kname" value="<%= request.getParameter("kFamily")+request.getParameter("kName") %>">
<input type="hidden" name="m_eFamily" value="<%= request.getParameter("eFamily") %>">
<input type="hidden" name="m_eName" value="<%= request.getParameter("eName") %>">
<input type="hidden" id="action" name="action" value="m_insert">
<table border="1" width="700px">
	<tr>
		<td width="30%">아이디</td>
		<td>
			<input type="text" id="m_id" name="m_id">
			<input type="button" value="중복 확인" onclick="btn_idcheck()">
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="m_pw"></td>
	</tr>
	<tr>
		<td>비밀번호 확인</td>
		<td>
			<input type="password" name="m_pwCheck" onkeyup="checkpw(this.value)">
			<span id="pw_comment"></span>
		</td>
	</tr>
	<tr>
		<td>성별</td>
		<td>
			<input type="radio" name="m_sex" value="M">남성
			<input type="radio" name="m_sex" value="F">여성
		</td>
	</tr>
	<tr>
		<td>국적</td>
		<td>
			<select name="m_nation" style="width: 120px">
				<option value="korea">대한민국</option>
				<option value="usa">미국</option>
				<option value="japen">일본</option>
				<option value="china">중국</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>생년 월일</td>
		<td>
			<select id="m_year" name="m_year" style="width: 80px">
				<%
					for(int i = year - 70 ; i < year + 1; i++) {
						if(i == year) {
						    out.println("<option value=\""+ i +"\" selected=\"selected\">" + i + "년</option>");
						} else {
						    out.println("<option value=\""+ i +"\">" + i + "년</option>");
						}
					}
			    %>
			</select>
			<select id="m_month" name="m_month" style="width: 80px">
				<% 
					for(int i = 1; i <= 12; i++) {
				        if(i == month) {
				            out.println("<option value=\""+ i +"\" selected=\"selected\">" + i + "월</option>");
				        } else {
				            out.println("<option value=\""+ i +"\">" + i + "월</option>");
				        }
				    }
			    %>
			</select>
			<select name="m_day" style="width: 80px">
				<% 
					for(int i = 1; i <= endday; i++) {
				        if(i == day) {
				            out.println("<option value=\""+ i +"\" selected=\"selected\">" + i + "일</option>");
				        } else {
				            out.println("<option value=\""+ i +"\">" + i + "일</option>");
				        }
				    }
			    %>
			</select>
		</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td>
			<select name="m_mobile1" style="width: 80px" onchange="sel_mobile()">
				<option value="0">선택</option><option value="010">010</option>
				<option value="011">011</option><option value="016">016</option>
				<option value="017">017</option><option value="018">018</option>
				<option value="019">019</option>
			</select>
			<span>-</span><input type="text" name="m_mobile2" style="width: 80px" onkeyup="in_mobile()" maxlength="4">
			<span>-</span><input type="text" name="m_mobile3" style="width: 80px" maxlength="4">
		</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>
			<input type="text" name="m_email" style="width: 120px"><span>@</span>
			<input type="text" name="m_domain1" style="width: 120px" readonly>
			<select name="m_domain2" style="width: 120px" onchange="sel_domain()">
				<option value="0">::: 선택 :::</option><option value="naver.com">naver.com</option>
				<option value="dreamwiz.com">dreamwiz.com</option><option value="hanmail.net">hanmail.net</option>
				<option value="empal.com">empal.com</option><option value="yahoo.co.kr">yahoo.co.kr</option>
				<option value="nate.com">nate.com</option><option value="gmail.com">gmail.com</option>
				<option value="hotmail.com">hotmail.com</option><option value="9">직접입력</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>SMS 수신</td>
		<td>
			<input type="radio" name="m_sms" value="Y" onclick="popup1(this.value)">동의
			<input type="radio" name="m_sms" value="N" onclick="popup1(this.value)">거절
			<span id="s_pop" style="margin-left: 10px;"/>
		</td>
	</tr>
	<tr>
		<td>E-Mail 수신</td>
		<td>
			<input type="radio" name="m_echeck" value="Y" onclick="popup2(this.value)">동의
			<input type="radio" name="m_echeck" value="N" onclick="popup2(this.value)">거절
			<span id="e_pop" style="margin-left: 10px;"/>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<pre>* 이메일 및 SMS 수신
 - 수신에 동의하시면 FlyPeanut항공의 뉴스레터 및 상품정보, 이벤트 등의 안내를 받아보실 수 있습니다.
 - 회원정보, 예약 및 항공기 운항정보, 서비스 주요정책 관련내용은 수신동의 여부와 관계 없이 발송됩니다
			</pre>
		</td>
	</tr>
	<tr>
		<td align="right" colspan="2">
			<input type="button" value="취소">
			<input type="submit" value="가입">
		</td>
	</tr>
</table>
</form>
</body>
</html>