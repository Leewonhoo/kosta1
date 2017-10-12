<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 가입</title>
<script>
function btn_nMove(){
	location.href="JoinName.jsp";
}
function btn_forMove(){
	location.href="JoinName.jsp";
}
</script>
</head>
<body>
	<table border="1">
		<tr>
			<td>
				<img src="images/welcome.JPG">
			</td>
			<td>회원 유형</td>
		</tr>
		<tr>
			<td>
<pre>회원으로 가입하시면, 예약, 발권, 탑승, 마일리지 조회 등 다양한 서비스와
함께 정기 이벤트 뉴스와 할인항공권 소식을 이메일로 받아보실 수도 있습니다.</pre>
			</td>
			<td>
				<input type="button" value="내국인" style="width: 100px; height: 100px" onclick="btn_nMove()">
			<input type="button" value="외국인" style="width: 100px; height: 100px" onclick="btn_forMove()">
		</td>
	</tr>
</table>
</body>
</html>