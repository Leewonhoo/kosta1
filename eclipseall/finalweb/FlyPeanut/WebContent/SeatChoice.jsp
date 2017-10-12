<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", 
      "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", 
      "t", "u", "v", "w", "x", "y", "z"}; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type = "text/css" rel = "stylesheet" href = "css/MainStyle.css">
<title>좌석 배치도</title>
<script>
function sSeat(name, value){
   alert("좌석 "+value+" 을 선택하였습니다.");
   document.SeatForm.seat.value = value;
}
</script>
</head>
<body>
<form name="SeatForm" method="post" action="${PATH}/AirController">
<h3>비행기 좌석 배치도</h3>
<%
   //int row = (int)request.getAttribute("sRow");  //행
   //String guCol = (String)request.getAttribute("sCol");  //열
   int row = 6;
   String guCol = "d";
   int col = 0;
   for(int i=0; i<alphabet.length; i++){
      if (alphabet[i].equals(guCol)){
         col = i;
         break;
      }
   }
%>
<table border="1" width="40%">
   <tr>
      <td>
         <table border="1">
         <% for(int i=0; i<row; i++){ %>
         <tr>
            <% for(int j=0; j<col; j++){ %>
            <td align="center">
               <span style="margin: 5px"/>
               <input type="button" name="seat<%= i %><%= j %>" value="<%= i %><%= alphabet[j] %>" onclick="sSeat(this.name, this.value)">
               <span style="margin: 5px"/>
            </td>
            <% } %>
         </tr>
         <% } %>
         </table>
      </td>
   </tr>
   <%
   if(request.getAttribute("seatList") != null) {
   %>
   <tr>
      <td>
         <input type="checkbox" name="seatNum" onchange="seatNo()"><span></span>
      </td>
   </tr>
   <% } %>
</table>
<input type="hidden" name="seat">
<input type="hidden" name="action" value="choice">
</form>
</body>
</html>