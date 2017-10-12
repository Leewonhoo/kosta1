<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div style="text-align:right; width=300px; padding-right=10px"  >
   	<%= session.getAttribute("e_kname") +"님 환영합니다." %>
	<a href="Controller?action=myPage">마이페이지</a>
	<a href="Controller?action=logout">로그아웃</a>
</div> 
<table width="80%" align="center">
	<tr style="font-size:22px; font-family:verdana,Courier,Monospace; text-decoration: none;">
		<td width="20%"><a href="Menu1.jsp"><img src="images/LOGO.jpg" width="200px" height="80px"></a></td>
		<td bgcolor="#ffcc33" width="10%" height="80px" align="center"><a href="Menu1">항공권</a></td>
		<td width="40%"></td>
	</tr>
</table>
<table style = "float:left; width:300px; margin:30px 100px;">
	<tr><td><h2> 항공권</h2></td></tr>
	<tr><td><h4><a href="#">항공권 발급</a></h4></td></tr>
	<tr><td><h4><a href="#">항공권 조회</a></h4></td></tr>
	<tr><td><h4><a href="#">항공권 취소</a></h4></td></tr>
	<tr><td><h4><a href="#">항공권 예매</a></h4></td></tr>
</table>
</body>
</html>