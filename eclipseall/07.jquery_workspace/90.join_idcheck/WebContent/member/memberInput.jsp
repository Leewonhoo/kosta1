<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������</title>
<!-- css common -->
<link type="text/css" rel="stylesheet" href="${applicationScope.CONTEXT_PATH}/css/common.css">

<!-- js -->
<script type="text/javascript">
	/* idcheck javascript ��� �Լ� */
	function execIdCheck() {
		var takeElementUserId = document.getElementById("userId");
		takeElementUserId.vaule = '';
		var url = "${applicationScope.CONTEXT_PATH}/member/memberIdCheck.jsp";
		var conf = "width:200px;height:100px;";
		window.open(url, conf);
	}
</script>
</head>
<body>
<h3>ID Check : Java Script</h3>
<form name="memberInputForm" action="controller?action=memberInputSave" method="post">
	<input type="text" name="userId" id="userId" value="���̵��ߺ�Ȯ��" class="input-readonly" onkeydown="execIdCheck()">
	<input type="button" value="�ߺ�Ȯ��" onclick="execIdCheck()"><br>
	<input type="password" id="userPw" name=""userPw"" value="��й�ȣ" onfocus="this.value=''"><br>
	<input type="text" id="username" name="username" value="�̸�" onfocus="this.value=''"><br>
	<input type="submit" value="ȸ������">
</form>

<hr>

</body>
</html>