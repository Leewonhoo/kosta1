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
   			<td><a href="Issue.jsp">항공권 발급</a></td>
   		</tr>
   		<tr>
   			<td>><a href="SearchTicket.jsp">항공권 조회</a></td>
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
   <jsp:useBean id="dto" class="work.model.dto.ReservationDto" scope="request" />
   	<table border="1" align="center" width="500px" height="400px">
		<tr>
			<th>예약번호</th>
			<td>
				${requestScope.dto.rNum}
			</td>
		</tr>
		<tr>
			<th >예약자</th>
			<td>
				${requestScope.dto.rName}
			</td>
		</tr>
		<tr>
			<th>출발지</th>
			<td>
				${requestScope.dto.rDeparture}
			</td>
		</tr>
		<tr>
			<th>출발시간</th>
			<td>
				${requestScope.dto.rDepartureTime}
			</td>
		</tr>
		<tr>
			<th>도착지</th>
			<td>
				${requestScope.dto.rArrival}
			</td>
		</tr>
		<tr>
			<th>도착시간</th>
			<td>
				${requestScope.dto.rArrivalTime}
			</td>
		</tr>
		<tr>
			<th>좌석</th>
			<td>
				${requestScope.dto.rSeat}
			</td>
		</tr>
		<tr>
			<th>예약날짜</th>
			<td>
				${requestScope.dto.rDate}
			</td>
		</tr>
		<tr>
			<th>편명</th>
			<td>
				${requestScope.dto.rFname}
			</td>
		</tr>
		<tr>
			<th>클래스</th>
			<td>
				${requestScope.dto.rClass}
			</td>
		</tr>
	</table>
	<input type="button" onclick="location='Menu1.jsp'">
   </td>
  </tr>
  <tr>
   <td colspan="4" width="100%" height="15%">
   </td>
  </tr>
 </table>
</body>
</html>