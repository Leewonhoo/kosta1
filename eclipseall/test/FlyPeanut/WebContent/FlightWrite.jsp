<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.ArrayList"%>
<%@page import="work.model.dto.AirplaneDto"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type = "text/css" rel = "stylesheet" href = "css/MainStyle.css">
<title>Insert title here</title>
<script type="text/javascript">
	function filght_check() {

		if (document.flightSelect.f_date.value == "") {
			alert("날짜를 입력바랍니다.");
			document.flightSelect.f_date.focus();
			return false;
		}

		if (document.flightSelect.f_anum.value == "") {
			alert("고유번호를 입력바랍니다.");
			document.flightSelect.f_anum.focus();
			return false;
		}

		if (document.flightSelect.f_fname.value == "") {
			alert("이름을 입력바랍니다");
			document.flightSelect.f_fname.focus();
			return false;
		}

		if (document.flightSelect.leave_nation.value == "") {
			alert("출발지를 입력바랍니다.");
			document.flightSelect.leave_nation.focus();
			return false;
		}

		if (document.flightSelect.f_levdate.value == "") {
			alert("출발시각을 입력바랍니다.");
			document.flightSelect.f_levdate.focus();
			return false;
		}

		if (document.flightSelect.arrive_nation.value == "") {
			alert("도착지를 입력바랍니다.");
			document.flightSelect.arrive_nation.focus();
			return false;
		}
		if (document.flightSelect.f_arridate.value == "") {
			alert("도착시각을 입력바랍니다.");
			document.flightSelect.f_arridate.focus();
			return false;
		}
		if (document.flightSelect.f_gate.value == "") {
			alert("게이트 번호를 입력바랍니다.");
			document.flightSelect.f_gate.focus();
			return false;
		}

		document.flightSelect.submit();
	}

	function fnStartList(value) {
		var f = document.flightSelect;
		var opt = document.flightSelect.leave_city.length;
		if(value == ""){
			nation = new Array("==선택==");
			vnation = new Array("");
		}else if(value == "KOR"){
			nation = new Array("서울/김포","인천", "청주", "제주");
			vnation = new Array("GMP", "ICN", "CNU","JJU");
		}else if(value == "JPN"){
			nation = new Array("도쿄","삿포로", "후쿠오카","오키나와");
			vnation = new Array("TKO", "SPR", "HKO", "OKN");
		}else if(value == "CHI"){
			nation = new Array("베이징","상하이", "광저우", "계림");
			vnation = new Array("BEI", "SHA", "GUG","GER");
		}
		else if(value == "USA"){
			nation = new Array("뉴욕","LA", "텍사스", "플로리다");
			vnation = new Array("NYK", "LAG", "TEX","FRI");
		}
		else if(value == "ITA"){
			nation = new Array("로마","밀라노", "피렌체", ":베니스");
			vnation = new Array("ROM", "MIL", "FIO", "VEN");
		}
		
		for(var i=0; i<opt; i++){
			f.leave_city.options[0] = null;
		}
		
		for(k=0; k<nation.length; k++){
			f.leave_city.options[k] = new Option(nation[k],vnation[k]);
		}
	}
	
	function fnArriveList(value2) {
		var f2 = document.flightSelect;
		var opt2 = document.flightSelect.arrive_city.length;
		if(value2 == ""){
			city = new Array("==선택==");
			vcity = new Array("");
		}else if(value2 == "KOR"){
			city = new Array("서울/김포","인천", "청주", "제주");
			vcity = new Array("GMP", "ICN", "CNU","JJU");
		}else if(value2 == "JPN"){
			city = new Array("도쿄","삿포로", "후쿠오카","오키나와");
			vcity = new Array("TKO", "SPR", "HKO", "OKN");
		}else if(value2 == "CHI"){
			city = new Array("베이징","상하이", "광저우", "계림");
			vcity = new Array("BEI", "SHA", "GUG","GER");
		}
		else if(value2 == "USA"){
			city = new Array("뉴욕","LA", "텍사스", "플로리다");
			vcity = new Array("NYK", "LAG", "TEX","FRI");
		}
		else if(value2 == "ITA"){
			city = new Array("로마","밀라노", "피렌체", ":베니스");
			vcity = new Array("ROM", "MIL", "FIO", "VEN");
		}
		
		for(var i=0; i<opt2; i++){
			f2.arrive_city.options[0] = null;
		}
		
		for(k=0; k<city.length; k++){
			f2.arrive_city.options[k] = new Option(city[k],vcity[k]);
		}
	}

</script>
</head>
<body>

	<table>
		<tr>
			<td colspan="7" width="1536px" height="20px" align="right"><a href="Login.jsp">세션부분</a> </a></td>
		</tr>
	</table>
	<table width="100%">
		<tr style="font-size:22px; font-family:verdana,Courier,Monospace; text-decoration: none;">
			<td><a href="MainPage.jsp"><img src="images/LOGO.jpg"
					width="250px" height="80px"></a></td>
			<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "#">티켓</a></td>
			<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "MainController?action=airplanemain">비행기</a></td>
			<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "FilghtMain.jsp">운항일지</a></td>
			<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "MainController?action=noticemain">공지사항</a></td>
			<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "#">Peanut Talk</a></td>
			<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "#">MyPage</a></td>
			<td bgcolor="#ffcc33" width="150px" height="80px" align="center"><a href = "AdminPage.jsp">FlyPeanut</a></td>
		</tr>
	</table>
	
<table style = "float:left; width:300px;">
		
		<tr><td><h2> 항공기 안내</h2></td></tr>
		<tr><td><h4><a href="FlightView.jsp">운항정보 조회</a></h4></td></tr>
		<tr><td><h4><a href="FlightController?action=airplaneCall">운항정보 등록</a></h4></td></tr>
		<tr><td><h4><a href="FlightController?action=airplaneAll">운항정보 수정</a></h4></td></tr>
		<tr><td><h4><a href="FlightController?action=airplaneAll2">운항정보 삭제</a></h4></td></tr>
</table>

	<form name ="flightSelect" action="FlightController" method="post">
		<table width="600px" border="1" cellpadding="0" cellspacing="0"
			align="center">
			<% if (request.getAttribute("flightCall") != null) {
				ArrayList<AirplaneDto> dto = (ArrayList<AirplaneDto>)request.getAttribute("flightCall");  %>
			<h3 align="center">운항일지 등록</h3>
			<tr>
				<td width="20%" align="left">날짜</td>
				<td colspan="2" width="60%" align="left"><input type="text" name="f_date"></td>
			</tr>
			<tr>
				<td width="20%" align="left">고유 번호</td>
				<td colspan="2" width="60%" align="left">
				<select class="number" name="f_anum" size="1" onchange="make_month1()">
				
			
				<%for(int index=0; index<dto.size(); index++){ %>
					<option value="<%=dto.get(index).getaNum() %>"><%=dto.get(index).getaNum() %></option>
				<%}
				}%>
				</select>
				</td>
			</tr>
			<tr>
				<td width="20%" align="left">이름</td>
				<td colspan="2" width="60%" align="left"><input type="text" name="f_fname"></td>
			</tr>
			<tr>
				<td width="20%" align="left">출발지</td>
				<td colspan="2" width="60%" align="left">
				
				<select id="leave_nation" name="leave_nation" size="1" onchange="fnStartList(this.value)">
				<option value="">==선택==</option>
				<option value="KOR">대한민국</option>
				<option value="JPN">일본</option>
				<option value="CHI">중국</option>
				<option value="USA">미국</option>
				<option value="ITA">이탈리아</option>
				</select>
				<select id="leave_city" name="leave_city" size="1" >
				<option value="">==선택==</option>
				
				</select></td>
				
			</tr>
			<tr>
				<td width="20%" align="left">출발시각</td>
				<td colspan="2" width="60%" align="left"><input type="text"
					name="f_levdate">(ex. yyyy.mm.dd hh:mi)</td>
			</tr>
			<tr>
				<td width="20%" align="left">도착지</td>
				<td colspan="2" width="60%" align="left">
				<select id="arrive_nation" name="arrive_nation" size="1" onchange="fnArriveList(this.value)">
				<option value="">==선택==</option>
				<option value="KOR">대한민국</option>
				<option value="JPN">일본</option>
				<option value="CHI">중국</option>
				<option value="USA">미국</option>
				<option value="ITA">이탈리아</option>
				</select>
				<select id="arrive_city" name="arrive_city" size="1" >
				<option value="">==선택==</option>
				
				</select></td></td>
			</tr>
			<tr>
				<td width="20%" align="left">도착시각</td>
				<td colspan="2" width="60%" align="left"><input type="text"
					name="f_arridate">(ex. yyyy.mm.dd hh:mi)</td>
			</tr>
			<tr>
				<td width="20%" align="left">게이트</td>
				<td colspan="2" width="60%" align="left"><input type="text"
					name="f_gate">(1~30)</td>
			</tr>

			<tr>
				<td colspan="3" width="100%" align="center" colspan="2">
					<table>
						<tr>
							<td width="50%" align="center">
							<input type="reset" value="초기화"></td>
							<td colspan="2" width="50%" align="center"><input
								type="hidden" name="action" value="flightWrite"> <input
								type="button" value="등록" onClick="filght_check()"></td>

						</tr>
					</table>

				</td>
			</tr>
		</table>
		
	</form>
</body>
</html>