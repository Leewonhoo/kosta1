<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="work.model.dto.FlightDto"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type = "text/css" rel = "stylesheet" href = "css/MainStyle.css">
<title>Insert title here</title>
<script type="text/javascript">
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

<table style = "height:100px;">

	<tr>
		<td colspan ="2">출발지</td>
		<td colspan = "2">도착지</td>
	</tr>
	<tr>
		<td><select id="leave_nation" name="leave_nation" size="1" onchange="fnStartList(this.value)">
				<option value="">==선택==</option>
				<option value="KOR">대한민국</option>
				<option value="JPN">일본</option>
				<option value="CHI">중국</option>
				<option value="USA">미국</option>
				<option value="ITA">이탈리아</option>
				</select></td>
		<td><select id="leave_city" name="leave_city" size="1" >
				<option value="">==선택==</option>
				
				</select></td>
		<td><select id="arrive_nation" name="arrive_nation" size="1" onchange="fnArriveList(this.value)">
				<option value="">==선택==</option>
				<option value="KOR">대한민국</option>
				<option value="JPN">일본</option>
				<option value="CHI">중국</option>
				<option value="USA">미국</option>
				<option value="ITA">이탈리아</option>
				</select></td>
		<td><select id="arrive_city" name="arrive_city" size="1" >
				<option value="">==선택==</option>
				
				</select></td>
				
		
	
	<input type = "hidden" name = "action" value="flightSelect">
	<td><input type="submit" value="선택"></td>
	</tr>
</form>
</table>
<table style="width:800px;" border="1">

<tr>
	<th>날짜</th>
	<th>고유번호</th>
	<th>편명</th>
	<th>출발지</th>
	<th>출발시각</th>
	<th>도착지</th>
	<th>도착시각</th>
	<th>게이트</th>
</tr>

<% if (request.getAttribute("flightview") != null) {
		ArrayList<FlightDto> dto = (ArrayList<FlightDto>)request.getAttribute("flightview");%> 
     	
     	<%for(int i=0; i<dto.size(); i++){ %>
		<tr>
			<td align="center"><%= dto.get(i).getfDate() %></td>
			<td align="center"><%= dto.get(i).getfANum() %></td>
			<td align="center"><%= dto.get(i).getfFName() %></td>
			<td align="center"><%= dto.get(i).getfLeave() %></td>
			<td align="center"><%= dto.get(i).getfLeaveDate() %></td>
			<td align="center"><%= dto.get(i).getfArrive() %></td>
			<td align="center"><%= dto.get(i).getfArriveDate() %></td>
			<td align="center"><%= dto.get(i).getfGate()%></td>
		</tr>
<%}
}
 %>

	
</table>
</body>
</html>