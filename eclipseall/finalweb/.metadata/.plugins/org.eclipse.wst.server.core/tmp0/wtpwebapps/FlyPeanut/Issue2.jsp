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
   		<div style="text-align:right; width=300px; padding-right=10px"><%= session.getAttribute("e_kname") +"님 환영합니다." %>
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
   				<td>><a href="CancelTicket.jsp">항공권 취소</a></td>
   			</tr>
   			<tr>
   				<td><a href="bookTicket.jsp">항공권 예매</a></td>
   			</tr>
   		</table>
   </td>
   <td width="60%" height="70%">
	<form action="Controller" method="post">
   	<table align="center" >
   		<tr>
   			<td><%= request.getAttribute("rname") %>님 수하물 추가</td>
   		</tr>
   		<tr>
   			<td><input type="radio" value="1" id="t_bagnum" name="t_bagnum" checked> 1Piece (기본) </td>
   		</tr>
   		<tr>
   			<td><input type="radio" value="2" id="t_bagnum" name="t_bagnum"  > 2Pieces </td>
   		</tr>
   		<tr>
   			<td><input type="radio" value="3" id="t_bagnum" name="t_bagnum" > 3Pieces </td>
   		</tr>
   	</table>
   		<div align="center"><input type="submit" id="nextIssue" name="nextIssue" value="다음">
   			<input type="button" id="cancel" name="cancel" value="취소" onclick="location='Menu1.jsp'">
   		</div>
   		<input type="hidden" name="action" value="nextIssue">
   	</form>
   </td>
</table>
</body>
</html>