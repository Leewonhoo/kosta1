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
   		<table align="center">
   			<tr>
   				<td>승객명</td>
   				<td><input type="text" id="c_name" name="c_name" size="20" maxlength="20"></td>
   			</tr>
   			<tr>
   				<td>예약번호</td>
   				<td><input type="text" id="r_num" name="r_num" size="20" maxlength="20"></td>
   			</tr>
   			<tr></tr>
   		</table>
   		<input type="hidden" value="searchcancel" name="action">
   		<div align="center"><input type="submit" value="검색" name="searchcancel" id="searchcancel"> 
   		</div>
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