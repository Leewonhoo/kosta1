<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table width="1340" height="650" border="1">
  <tr>
  <td rowspan="3" width="10%" ></td>
   <td colspan="4" width="80%" height="15%">
   		<div style="text-align:right; width=300px; padding-right=10px"  ><%= session.getAttribute("e_kname") +"님 환영합니다." %>
			<a href="Controller?action=myPage">마이페이지</a>
			<a href="Controller?action=logout">로그아웃</a>
		</div> 
   		<a href="Menu1.jsp"><img src="images/logo.jpg" width="200" height="100"></a>
		피넛에어 통합관리자 페이지입니다.<hr>
	</td>
   <td rowspan="3" width="10%" ></td>
  </tr>
  <tr>
   <td width="20%" height="70%">
   		<table width="250" height="200" border="1" cellpadding="10" align="center" >
   			<tr>
   				<td><h3>메인 메뉴</h3><hr></td>
   			</tr>
   			<tr>
   				<td>><a href="Issue.jsp">항공권 발급</a></td>
   			</tr>
   			<tr>
   				<td><a href="SearchTicket.jsp">항공권 조회</a></td>
   			</tr>
   			<tr>
   				<td><a href="CancelTicket.jsp">항공권 취소</a></td>
   			</tr>
   			<tr>
   				<td><a href="bookTicket.jsp">항공권 예매</a></td>
   			</tr>
   		</table>
   </td>
   <td width="60%" height="70%">
   <h3 align="center">항공권 발급확인서</h3>
   <form action="Controller" method="post">
   	<div><table align="center" width="600" >
   		<tr>
   			<td>승객명/ Passenger Name</td>
   			<td> 받아오기LEE/MINJEONG</td>
   		</tr>
   		<tr>
   			<td>예약번호/Booking Reference</td>
   			<td>받아오기PJCFW/G</td>
   		</tr>
   	</table></div>
   	<table border="1" align="center" width="600">
   		<tr>
   			<td colspan="3" background="black">편명(Flight) Operated by 피넛항공</td>
   		</tr>
   		<tr>
   			<td>출발(Departure)</td>
   			<td>ICN : 인천</td>
   			<td>출발시간 20170928 14:20</td>
   		</tr>
   		<tr>
   			<td>도착(Arrival)</td>
   			<td>SIN : 싱가포르</td>
   			<td>도착시간 20171010 22:35</td>
   		</tr>
   		<tr></tr>
   	</table>
   	<table border="1" width="600" align="center">
   		<tr>
   			<td>예상 비행시간(Flight Time)</td>
   			<td colspan="3"></td>
   		</tr>
   		<tr>
   			<td>예약등급(class)</td>
   			<td> F 퍼스트/C 비즈니스/Y 이코노미</td>
   			<td></td>
   			<td></td>
   		</tr>
   		<tr>
   			<td>예약상태(Status)</td>
   			<td>OK</td>
   			<td></td>
   			<td></td>
   		</tr>
   		<tr>
   			<td>운임(Fare Basis)</td>
   			<td>ELEKS(왕복 EX/편도 PX) </td>
   			<td>수화물(Baggage)</td>
   			<td>1Piece(s)</td>
   		</tr>
   	</table>
   	<table border="1" align="center" width="600">
   		<tr>
   			<td colspan="3" background="black">편명(Flight) Operated by 피넛항공</td>
   		</tr>
   		<tr>
   			<td>출발(Departure)</td>
   			<td>SIN : 싱가포르</td>
   			<td> 출발시간 20170928 14:20</td>
   		</tr>
   		<tr>
   			<td>도착(Arrival)</td>
   			<td>  ICN : 인천</td>
   			<td> 도착시간 20171010 22:35</td>
   		</tr>
   		<tr></tr>
   	</table>
	<table border="1" width="600" align="center">
   		<tr>
   			<td>예상 비행시간(Flight Time)</td>
   			<td colspan="3">000</td>
   		</tr>
   		<tr>
			<td>예약등급(class)</td>
			<td> F 퍼스트/C 비즈니스/Y 이코노미</td>
			<td>항공권 유효기간</td>
			<td>Not Valid Before</td>
   		</tr>
   		<tr>
			<td>예약상태(Status)</td>
			<td>OK</td>
			<td></td>
			<td>Not Valid After 받아오기20171228(출발 6개월후까지)</td>
   		</tr>
   		<tr>
   			<td>운임(Fare Basis)</td>
   			<td>ELEKS(왕복 EX/편도 PX) </td>
   			<td>수화물(Baggage)</td>
   			<td>1Piece(s)</td>
   		</tr>
   	</table>
   	<h3 align="center">항공권 정보(Ticket Information for Airline Staff)</h3>
   	<table align="center" border="1" width="600">
   		<tr>
   			<td>Issue Date</td>
   			<td>00</td>
   		</tr>
   		<tr>
   			<td>Fare</td>
   			<td>KRW 590000</td>
   		</tr>
   		<tr>
   			<td rowspan="2">Taxes</td>
   			<td>KRW 28000 BP(인천항공세)</td>
   		</tr>
   		<tr><td>KRW 32700 XT(기타 현지공항세)</td></tr>
   		<tr>
   			<td>Total</td>
   			<td>KRW 650700</td>
   		</tr>
   	</table>
   	<div align="center"><input type="submit" id="issue" name="issue" value="발급">
   		<input type="button" id="before" name="before" value="이전" onclick="location='Issue2.jsp'">
   	</div>
   		<input type="hidden" name="action" value="issue">
   	</form>
   </td>
</table>
</body>
</html>