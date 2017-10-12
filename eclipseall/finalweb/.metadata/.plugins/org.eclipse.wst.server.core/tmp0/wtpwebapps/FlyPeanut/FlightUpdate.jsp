
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="work.model.dto.FlightDto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type = "text/css" rel = "stylesheet" href = "css/MainStyle.css">
<title>Insert title here</title>
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
<% 
	if (request.getAttribute("flightUpView") != null) {
		FlightDto fdto = (FlightDto)request.getAttribute("flightUpView"); 
	
%>

<table align="center">
<form name ="flightUpdate" action="FlightController" method="post">
<h3 align="center">운항일지 수정</h3>
			<tr>
				<td width="20%" align="left">날짜</td>
				<td colspan="2" width="60%" align="left"><input type="text" name="f_date" value="<%=fdto.getfDate() %>" readonly></td>
			</tr>
			<tr>
				<td width="20%" align="left">고유 번호</td>
				<td colspan="2" width="60%" align="left">
				<input type="text" name="f_anum" value="<%=fdto.getfANum() %>" readonly>
				</td>
			</tr>
			<tr>
				<td width="20%" align="left">이름</td>
				<td colspan="2" width="60%" align="left"><input type="text" name="f_fname" value="<%= fdto.getfFName() %>" readonly></td>
			</tr>
			<tr>
				<td width="20%" align="left">출발지</td>
				<td colspan="2" width="60%" align="left">
				<input type="text" name="f_leave" value="<%= fdto.getfLeave() %>" readonly>
				</td>
				
			</tr>
			<tr>
				<td width="20%" align="left">출발시각</td>
				<td colspan="2" width="60%" align="left"><input type="text"
					name="f_levdate" value="<%=fdto.getfLeaveDate()%>">(ex. yyyy.mm.dd hh:mi)</td>
			</tr>
			<tr>
				<td width="20%" align="left">도착지</td>
				<td colspan="2" width="60%" align="left">
				<input type="text" name = "f_arrive" value="<%= fdto.getfArrive() %>" readonly>
			</tr>
			<tr>
				<td width="20%" align="left">도착시각</td>
				<td colspan="2" width="60%" align="left"><input type="text"
					name="f_arridate" value="<%= fdto.getfArriveDate()%>">(ex. yyyy.mm.dd hh:mi)</td>
			</tr>
			<tr>
				<td width="20%" align="left">게이트</td>
				<td colspan="2" width="60%" align="left"><input type="text" name="f_gate" value=<%=fdto.getfGate() %>>(1~30)</td>
			</tr>
			
			
			<%} %>

</table>
<table align="center">
	<tr>
		<td><input type="hidden" name="action" value="flightUpdate"><input type="submit" value="변경"></td>
	</tr>
</table>
</form>
</body>
</html>