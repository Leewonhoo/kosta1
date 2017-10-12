
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
</head>
<body>

<% 
	if (request.getAttribute("viewairplane") != null) {
		AirplaneDto ndto = (AirplaneDto)request.getAttribute("viewairplane"); 
	
%>
<%} %>
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
		<tr><td><h4><a href="MainController?action=airplanemain">항공기 조회</a></h4></td></tr>
		<tr><td><h4><a href="AirplaneAdd.jsp">항공기 추가</a></h4></td></tr>
		<tr><td><h4><a href="FlightUpdate.jsp">항공기 수정</a></h4></td></tr>
		<tr><td><h4><a href="FlightDelete.jsp">항공기 삭제</a></h4></td></tr>
</table>
	
	
<table style = "float:left; width:300px;">
		
		<tr> <td><h2> 항공기 안내</h2></td></tr>
		<% if (request.getAttribute("airplanemain") != null) {
		ArrayList<AirplaneDto> dto = (ArrayList<AirplaneDto>)request.getAttribute("airplanemain");  %>
     	<%for(int i=0; i<dto.size(); i++){ %>
		<tr><td><h4><a href="MainController?action=airplaneView&a_num=<%= dto.get(i).getaNum() %>"><%=dto.get(i).getaKind() %></a></h4></td></tr>

		<% }
		}     %>
</table>	

<table style ="width:600px">

<table>
<jsp:include page="AirplaneDetail.jsp"/>
</table>


</table>
</body>
</html>