<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="work.model.dto.EmployeeDto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR"); %>
<div style="text-align:right; width=300px; padding-right=10px"  >
   	<%= session.getAttribute("e_kname") +"님 환영합니다." %>
	<a href="Controller?action=myPage">마이페이지</a>
	<a href="Controller?action=logout">로그아웃</a>
</div> 
		
<table width="80%" align="center">
	<tr style="font-size:22px; font-family:verdana,Courier,Monospace; text-decoration: none;">
		<td width="20%">
		<a href="Menu1.jsp"><img src="images/LOGO.jpg" width="200px" height="80px"></a></td>
		<td bgcolor="#ffcc33" width="10%" height="80px" align="center"><a href="Menu1">항공권</a></td>
		<td width="40%"></td>
	</tr>
</table>
 <table>
  <tr>
   <td width="20%" height="70%">
   		<table width="250" height="200" border="1" cellpadding="10" align="center" >
   			<tr>
   				<td><h3>내 정보</h3><hr></td>
   			</tr>
   			<tr>
   				<td><a href="#">예매 내역</a></td>
   			</tr>
   			<tr>
   				<td><a href="ResetInfo.jsp">내정보 수정</a></td>
   			</tr>
   			<tr>
   				<td><a href="CheckPw.jsp">비빌번호 변경</a></td>
   			</tr>
   			<tr>
   				<td>><a href="Delete.jsp">탈퇴하기</a></td>
   			</tr>
   		</table>
   </td>
   <td width="60%" height="70%">
   	 <form method="post" action="Controller">
   		<table  align="center" >
   			<tr>
   				<td>정말 탈퇴 하시겠습니까?</td>
   			</tr>
   			<tr>
   				<td align="center"><input type="button" id="bt_yes" name="bt_yes" value="네" onclick="location='Delete2.jsp'">
   					<input type="button" id="bt_no" name="bt_no" value="아니요" onclick="location='Menu1.jsp'">
   				</td>
   			</tr>
   		</table>
   	</form>
   </td>
  </tr>
  <tr>
   <td colspan="4" width="100%" height="15%">
   </td>
  </tr>
 </table>
</body>
</html>