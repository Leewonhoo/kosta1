<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script  type="text/javascript">
	/*중복확인 후 사용하기*/
	function useId2() {
		window.opener.document.getElementById('e_id').value=document.getElementById('e_id').value;
		window.opener.document.getElementById('e_id').readOnly=true;
		window.close();
	}
	/*중복확인*/
	function isid() {
		alert("<%=request.getAttribute("result")%>");
	
	document.checkid.submit();
	}	
	function checkkeyup() {
		document.getElementById('useId').disabled = true;

	}
</script>
</head>
<body>
<h3>사번 중복확인</h3><hr>
<form name="checkid" id="checkid" action="Controller" method="post">
<table align="center">
	<tr>
		<td>사번 <input type="text" id="e_id" name="e_id" onkeyup="checkkeyup()" ></td>
		<td><input type="button" value="중복확인" onclick="isid()" >
		</td>
		<td><input type="button" value="사용하기" id="useId" name="useId" onclick="useId2()" maxlength="20" disabled></td>
		<td><input type="button" value="창닫기" onclick="window.close()"></td>
	</tr>
	<tr><td align="center"><span id="text"></span></td></tr>
	
</table>
			<input type="hidden" name="action" value="idCheck">

<% 
	if(request.getAttribute("result") != null){
		if ((boolean)request.getAttribute("result")){
	%>
	<script>document.getElementById('useId').disabled = true;
	document.getElementById('text').innerHTML="중복된 아이디가 있음";
	</script>
	<% } else { %>
	<script>document.getElementById('useId').disabled = false;
	document.getElementById('text').innerHTML="중복된 아이디가 없음 사용가능";</script>
	<% } %>
	<% }%>
</form>

</body>
</html>