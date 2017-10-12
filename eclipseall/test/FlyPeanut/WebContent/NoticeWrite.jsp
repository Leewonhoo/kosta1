<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCtype html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type = "text/css" rel = "stylesheet" href = "css/MainStyle.css">
<title>Insert title here</title>
<script type="text/javascript">
function write_check()
{

	if (document.frm1.title.value == "") 
	{
		alert("제목을 입력바랍니다.");
		document.frm1.title.focus(); 
		return false;
	}

	if (document.frm1.contents.value == "") 
	{
		alert("내용을 입력바랍니다.");
		document.frm1.contents.focus(); 
		return false;
	}

	document.frm1.submit();
	alert("공지 등록 완료!")
}
</script>
</head>
<body>
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
<form name = "frm1" action = "NoticeController" METHOD = "post">


<table width = "500" BORDER = "1" CellPadding = "0" CellSpacing = "0" align="center">
<h3 align="center">공지사항 등록</h3>	

	<tr>
		<td width = "40%" align = "left">제목</td>
		<td width = "60%" align = "left">
			<input type ="text" id="title" name="title" SIZE = "50" MAXLENGTH = "50">
		</td>
	</tr>
	
	<tr>
		<td width = "40%" align = "left">내용</td>
		<td width = "60%" align = "left">
			<textarea id="contents" name="contents" ROWS=5 COLS=50></textarea>
		</td>
	</tr>
	<tr>
		<td width = "100%" align = "center" COLSPAN = "2">
		<table>
			<tr>
				<td width = "33%" align = "center">
					<input type = "reset" value = "초기화">
				</td>
				<td width = "34%" align = "center">
					<input type = "hidden" name = "action" value="noticewrite">
					<input type = "button" value = "등록" onClick="write_check()">
				</td>
				
			</tr>
		</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>