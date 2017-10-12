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
	<% if (request.getAttribute("message") != null) { %>
		<script>alert("<%=request.getAttribute("message")%>");</script>
	<%	} %>
<table width="1400" height="650" align="center" border="1">
	<tr>
		<td rowspan="2" width="40%" height="15%">
			<a href="Login.jsp"><img src="images/logo.jpg" width="100" height="50"></a>
			피넛에어 통합관리자 페이지입니다.
		</td>
		<td rowspan="2">
			<a href="javascript:modiInfor()">개인 정보 조회</a>
			<a href="javascript:modiPass()">비밀번호 변경</a>
			<a href="${PATH}/BoardController?action=b_list">내가 쓴 게시판</a>
			<a href="Reservation.jsp">예매</a>
		</td>
		<td></td>
	</tr>
	<tr>
		<td>
			<% if (session.getAttribute("userId") != null){ %>
			<%= session.getAttribute("userId") %><span>님 환영합니다.</span><a href="${PATH}/MemberController?action=m_logout">로그아웃</a>
			<% } %>
		</td>
	</tr>
	<tr>
		<td></td>
		<td width="50%" height="70%">
			<form action="${PATH}/MemberController" method="post" name="mLoginForm">

				<table align="right">
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
						<td>
							ID<span style="margin: 5px"/><input type="text" size="10" maxlength="15" name="m_id" id="m_id">
						</td>
						<td rowspan="2" height="10px">
							<input type="hidden" name="action" value="m_login">
							<input type="submit" value="LOGIN" onclick="loginchk()">
						</td>
					</tr>
					<tr>
						<td>
							PW<span style="margin: 5px"/><input type="password" size="10" maxlength="15" name="m_pw" id="m_pw">
						</td>
					</tr>
					
					<tr>
						<td>&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;</td>
					</tr>
					<tr >
						<td colspan="2" >
							<input type="button" id="bt_join" name="bt_join" value="회원가입" onclick="location='JoinName.jsp'">
							<input type="button" id="bt_idpw" name="bt_idpw" value="아이디 비밀번호찾기" onclick="location='Search.jsp'">
						</td>
					</tr>
				</table>
			</form>
		</td>
		<td width="50%" height="70%">
			<form action="${PATH}/Controller" method="post" name="bLoginForm">
				<table align="left" border="1">
					<tr>
						<td>비회원 예약 로그인</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td>
							<span>
								<input type="text" size="10" maxlength="15"name="email1" id="email1">
								@
								<input type="text" size="10" maxlength="15" name="email2" id="email2">
							</span>&nbsp;
							<input type="submit" name="submit" id="submit" value="LOGIN">
							<input type="hidden" name="action" value="login">
						</td>
					</tr>
					<tr>
						<td>
							<textarea name="textarea" rows="3" cols="38">1. 수집하는 개인정보 항목 및 수집방법
									1) 수집항목 가. 부가 서비스 및 맞춤식 서비스 이용 과정에서 해당 서비스의 이용자에 한해서만 아래와 같은 정보들이 수집될 수 있습니다. <비회원 항공권 예약발권>- 필수항목 : 성명, 전화번호(휴대폰 번호, 자택 번호 중 택일), 이메일주소<홈페이지, SNS Q&A 이용 및 이벤트 참여>- 필수항목 : 성명, 전화번호(휴대폰 번호, 자택 번호 중 택일), 이메일주소<비회원으로 예약센터 등을 통한 질의 및 이벤트 참여>- 필수항목 : 성명, 전화번호(휴대폰 번호, 자택번호, 이메일주소 중 택일)
									나. 유료 서비스 이용 과정에서 아래와 같은 결제 정보들이 수집될 수 있습니다. <대금 결제>- 신용카드 결제시 : 카드번호 및 카드 인증정보 등- 실시간 계좌이체 결제시 : 계좌번호 및 결제은행 코드 등
									2) 수집 방법 및 동의 ο 개인정보 수집방법 : 홈페이지 및 SNS (회원가입, Q&A게시판), 이벤트 참여, 제휴사로부터의 제공
									ο 개인정보 수집 동의 방법 - 온라인 : 회사는 고객이 개인정보 처리방침 또는 이용약관의 내용에 대해 '동의함’ 버튼을 클릭할 수 있는 절차를 마련하고 있으며, '동의함' 버튼을 클릭하면 개인정보 수집에 대해 동의한 것으로 봅니다. 
							</textarea>
						</td>
					</tr>
					
					<tr>
						<td>
							<p style="font-size:small"><input type="checkbox" value="agree">상기 개인정보의 수집, 이용 사항에 동의합니다.</p>
							<p style="font-size:x-small">* 비회원 예매 시 포인트 적립, 요금 할인 및 이벤트 혜택의 기회가 상실됩니다.<br>
							* 항공권 예매 정보는 마이페이지>나의 예약 조회/변경/취소>온라인 예약내역><br>비회원 예매정보보기에서 보실 수 있습니다.</p>
						</td>
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