<%@page import="work.model.dto.FlightDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
 pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type = "text/css" rel = "stylesheet" href = "css/MainStyle.css">
<title>시간표 조회</title>
<script type="text/javascript">
var nation1 = new Array("==선택==");
var vnation1 = new Array("");
var nation2 = new Array("서울/김포","인천", "청주", "제주");
var vnation2 = new Array("GMP", "ICN", "CNU","JJU");
var nation3 = new Array("도쿄","삿포로", "후쿠오카","오키나와");
var vnation3 = new Array("TKO", "SPR", "HKO", "OKN");
var nation4 = new Array("베이징","상하이", "광저우", "계림");
var vnation4 = new Array("BEI", "SHA", "GUG","GER");
var nation5 = new Array("뉴욕","LA", "텍사스", "플로리다");
var vnation5 = new Array("NYK", "LAG", "TEX","FRI");
var nation6 = new Array("로마","밀라노", "피렌체", "베니스");
var vnation6 = new Array("ROM", "MIL", "FIO", "VEN");

function selectList(name, convey, value) {
   for(i=document.getElementById(convey).length-1; i>=0; i--){
      document.getElementById(convey).options[i] = null;
   }
   switch(value){
   case "KOR":
      for (k=0; k<nation2.length; k++) {
         document.getElementById(convey).options[k] = new Option(nation2[k],vnation2[k]);
      }
      break;
   case "JPN":
      for (k=0; k<nation3.length; k++) {
         document.getElementById(convey).options[k] = new Option(nation3[k],vnation3[k]);
      }
      break;
   case "CHI":
      for (k=0; k<nation4.length; k++) {
         document.getElementById(convey).options[k] = new Option(nation4[k],vnation4[k]);
      }
      break;
   case "USA":
      for (k=0; k<nation5.length; k++) {
         document.getElementById(convey).options[k] = new Option(nation5[k],vnation5[k]);
      }
      break;
   case "ITA":
      for (k=0; k<nation6.length; k++) {
         document.getElementById(convey).options[k] = new Option(nation6[k],vnation6[k]);
      }
      break;
   default:
      for (k=0; k<nation1.length; k++) {
         document.getElementById(convey).options[k] = new Option(nation1[k],vnation1[k]);
      }
   }
}
function ticket(){
   var obj1 = document.getElementById("two");
   var choose = document.ReserForm.fly.value;
   if (choose == "1"){
      obj1.style.display = "none";
      document.ReserForm.btn_sub.style.width = "120px";
      document.ReserForm.btn_sub.style.height = "30px";
   } else {
      obj1.style.display = "";
      document.ReserForm.btn_sub.style.width = "120px";
      document.ReserForm.btn_sub.style.height = "70px";
   }
}
function selected(){
   document.ReserForm.action.value = "a_flight";
   document.ReserForm.radio.value = document.ReserForm.fly.value;
   document.ReserForm.submit();
}
function buy(){
   document.ReserForm.fly.value;
   document.ReserForm.
   document.ReserForm.action = 'Seatchoice.jsp';
}
</script>
</head>
<body>

<div align="right">
	<% if (session.getAttribute("userId") != null){ %>
	<%= session.getAttribute("userId") %><span>님 환영합니다.</span><a href="${PATH}/MemberController?action=m_logout">로그아웃</a>
	<% }else{%>
	<a href="Login.jsp">로그인</a>
	<% }%>
	</div>
	
	

	<table width="90%">
		<tr style="font-size:22px; font-family:verdana,Courier,Monospace; text-decoration: none; width:150px;">
			<td><a href="UserMain.jsp"><img src="images/LOGO.jpg"
					width="250px" height="80px"></a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "Reservation.jsp">예매</a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "${PATH}/BoardController?action=b_list">내가 쓴 게시판</a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "MainController?action=noticemain">공지사항</a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "javascript:modiInfor()">개인정보 조회</a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "javascript:modiPass()">PW 변경</a></td>
			<td bgcolor="#ffcc33" width="180px" height="80px" align="center"><a href = "Index.jsp">관계자 Page</a></td>

		</tr>
	</table>
	
<form name="ReserForm" method="post" action="${PATH}/AirController">
<h3>
   <% 
      String fly = "a";
      if (request.getAttribute("radioch") != null) {
         fly = (String)request.getAttribute("radioch");
      }
      if(fly.equals("2")) {
         out.println("<input type='radio' name='fly' value='1' onchange='ticket()'>편도");
         out.println("<input type='radio' name='fly' value='2' checked onchange='ticket()'>왕복");
      } else {
         out.println("<input type='radio' name='fly' value='1' checked onchange='ticket()'>편도");
         out.println("<input type='radio' name='fly' value='2' onchange='ticket()'>왕복");
      }
       %>
</h3>
<table align="center" width="50%" border="1">
   <tr>
      <td colspan="2" align="center">출발지</td>
      <td colspan="2" align="center">도착지</td>
      <td></td>
   </tr>
   
   <tr>
      <td align="center">
         <select id="leave_nation1" name="leave_nation1" onchange="selectList(this.name, 'leave_city1', this.value)">
            <option value="">==선택==</option>
            <option value="KOR">대한민국</option>
            <option value="JPN">일본</option>
            <option value="CHI">중국</option>
            <option value="USA">미국</option>
            <option value="ITA">이탈리아</option>
         </select>
      </td>
      <td align="center">
         <select id="leave_city1" name="leave_city1">
            <option value="">==선택==</option>
         </select>
      </td>
      <td align="center">
         <select id="arrive_nation1" name="arrive_nation1" onchange="selectList(this.name, 'arrive_city1', this.value)">
            <option value="">==선택==</option>
            <option value="KOR">대한민국</option>
            <option value="JPN">일본</option>
            <option value="CHI">중국</option>
            <option value="USA">미국</option>
            <option value="ITA">이탈리아</option>
         </select>
      </td>
      <td align="center">
         <select id="arrive_city1" name="arrive_city1">
            <option value="">==선택==</option>
         </select>
      </td>
      <td rowspan="2" align="center">
         <input type="hidden" name="radio">
         <input type="hidden" name="action" value="a_flight">
         <input type="button" align="middle" name="btn_sub" value="선택" onclick="selected()" style="width: 120px; height: 30px">
      </td>
   </tr>
   <% if(fly.equals("2")) { %>
   <tr id="two">
   <% } else { %>
   <tr id="two" style="display: none;">
   <% } %>
      <td align="center">
         <select id="leave_nation2" name="leave_nation2" onchange="selectList(this.name, 'leave_city2', this.value)">
            <option value="">==선택==</option>
            <option value="KOR">대한민국</option>
            <option value="JPN">일본</option>
            <option value="CHI">중국</option>
            <option value="USA">미국</option>
            <option value="ITA">이탈리아</option>
         </select>
      </td>
      <td align="center">
         <select id="leave_city2" name="leave_city2">
            <option value="">==선택==</option>
         </select>
      </td>
      <td align="center">
         <select id="arrive_nation2" name="arrive_nation2" onchange="selectList(this.name, 'arrive_city2', this.value)">
            <option value="">==선택==</option>
            <option value="KOR">대한민국</option>
            <option value="JPN">일본</option>
            <option value="CHI">중국</option>
            <option value="USA">미국</option>
            <option value="ITA">이탈리아</option>
         </select>
      </td>
      <td align="center">
         <select id="arrive_city2" name="arrive_city2">
            <option value="">==선택==</option>
         </select>
      </td>
   </tr>
</table>
</form>
<br><br>
<%
if (request.getAttribute("list1") != null){
   ArrayList<FlightDto> list1 = (ArrayList<FlightDto>)request.getAttribute("list1");
%>
<p align="center">
   <input type="button" value="항공권 구매" style="width: 120px; height: 80px" onclick="buy()">
</p>
<br>
<table border="1" align="center" width="80%">
   <tr>
      <th></th>
      <th width="13%">날짜</th>
      <th width="10%">고유번호</th>
      <th width="10%">편명</th>
      <th width="13%">출발지</th>
      <th width="15%">출발시각</th>
      <th width="13%">도착지</th>
      <th width="15%">도착시각</th>
      <th width="*%">게이트</th>
   </tr>
   <% if(list1.isEmpty()){ %>
         <tr>
            <td colspan="9" align="center">등록된 일정이 없습니다.</td>
         </tr>
   <%   } else {
      for(int i=0; i<list1.size(); i++){
         FlightDto dto = list1.get(i);
   %>
   <tr>
      <td align="center"><input type="radio" name="start" value=""></td>
      <td align="center"><%= dto.getfDate() %></td>
      <td align="center"><%= dto.getfANum() %></td>
      <td align="center"><%= dto.getfFName() %></td>
      <td align="center"><%= dto.getfLeave() %></td>
      <td align="center"><%= dto.getfLeaveDate() %></td>
      <td align="center"><%= dto.getfArrive() %></td>
      <td align="center"><%= dto.getfArriveDate() %></td>
      <td align="center"><%= dto.getfGate() %></td>
   </tr>
   <% } } %>
</table>
<% } %>
<br><br><br>
<%
if (request.getAttribute("list2") != null){
   ArrayList<FlightDto> list2 = (ArrayList<FlightDto>)request.getAttribute("list2");
%>
<table border="1" align="center" width="80%">
   <tr>
      <th></th>
      <th width="13%">날짜</th>
      <th width="10%">고유번호</th>
      <th width="10%">편명</th>
      <th width="13%">출발지</th>
      <th width="15%">출발시각</th>
      <th width="13%">도착지</th>
      <th width="15%">도착시각</th>
      <th width="*%">게이트</th>
   </tr>
   <% if(list2.isEmpty()){ %>
         <tr>
            <td colspan="9" align="center">등록된 일정이 없습니다.</td>
         </tr>
   <%   } else {
      for(int i=0; i<list2.size(); i++){
         FlightDto dto = list2.get(i);
   %>
   <tr>
      <td align="center"><input type="radio" name="end" value=""></td>
      <td align="center"><%= dto.getfDate() %></td>
      <td align="center"><%= dto.getfANum() %></td>
      <td align="center"><%= dto.getfFName() %></td>
      <td align="center"><%= dto.getfLeave() %></td>
      <td align="center"><%= dto.getfLeaveDate() %></td>
      <td align="center"><%= dto.getfArrive() %></td>
      <td align="center"><%= dto.getfArriveDate() %></td>
      <td align="center"><%= dto.getfGate() %></td>
   </tr>
   <% } } %>
</table>
<% } %>
</body>
</html>