<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type = "text/css" rel = "stylesheet" href = "css/MainStyle.css">
<title>Insert title here</title>
</head>
<body>
	<table width="500" border="0" cellpadding="0" cellspacing="0"
		align="center">
		<h3 align="center">비행기 수정</h3>
		<tr>
			<td width="40%" align="left">고유 번호</td>
			<td colspan="2" width="60%" align = "left"><input type="text" ></td>
		</tr>
		<tr>
			<td width="40%" align="left">기종</td>
			<td colspan="2" width="60%" align = "left"><input type="text" ></td>
		</tr>
		<tr>
			<td width="40%" align="left">종류</td>
			<td colspan="2" width="60%" align = "left"><input type="text" ></td>
		</tr>
		<tr>
			<td width="40%" align="left">승객</td>
			<td colspan="2" width="60%" align = "left"><input type="text" ></td>
		</tr>
		<tr>
			<td width="40%" align="left">제조일</td>
			<td colspan="2" width="60%" align = "left"><input type="text" ></td>
		</tr>
		<tr>
			<td width="40%" align="left">제조사</td>
			<td colspan="2" width="60%" align = "left"><input type="text" ></td>
		</tr>
		<tr>
			<td width="40%" align="left">제조국가</td>
			<td colspan="2" width="60%" align = "left"><input type="text" ></td>
		</tr>
		<tr>
			<td width="40%" align="left">First Class</td>
			<td width="30%" align="left"></td>
			<td width="30%" align="left">열</td>
		</tr>
		
		<tr>
			<td width="40%" align="left">Business Class</td>
			<td width="30%" align="left">행</td>
			<td width="30%" align="left">열</td>
		</tr>
		
		<tr>
			<td width="40%" align="left">Economy Class</td>
			<td width="30%" align="left">행</td>
			<td width="30%" align="left">열</td>
		</tr>
		<tr>
			<td colspan = "3" width="100%" align="center" colspan="2">
				<table>
				<tr>
				<td width = "50%" align = "center">
					<input type = "reset" value = "초기화">
				</td>
				<td colspan = "2" width = "50%" align = "center">
					<input type = "hidden" name = "action" value="write">
					<input type = "button" value = "수정" onClick="add_check()">
				</td>
				
			</tr>
		</table>

			</td>
		</tr>
	</table>
</body>
</html>
</body>
</html>