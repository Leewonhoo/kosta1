<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	
	/* ������ load �̺�Ʈ �ڵ鷯 �Լ� 
			���������� ���� �������� :
			window.opener : open() �޼ҵ�� �����츦 �� ������ �ִ� �θ������� ��ü
	*/
	window.onload = function() {
		// �θ�������(ȸ������������)�� ���� �Է��� ���̵� ������ ��������
		var takeUserId = window.opener.document.memberInputForm.userId.value;
		// ������ ���̵�� ���̵� �����ϱ����� 
		// �ڽ�������(���� ���̵��ߺ�Ȯ��������)�� ���̵� �ʱⰪ���� ����
		idCheckForm.checkUserId.value = takeUserId;
	}
	
	/* ���̵� ���� ���� �˻� �޼��� 
		 -- �ƱԸ�Ʈ�� ���޹��� ���̵� �����ϴ��� �˻��ؼ� �����ϸ� true ��ȯ
	*/
	function isExistUserId(takeUserId) {
		var userlist = new Array("user01", "user02", "user03");
		for (index = 0; index < userlist.length; index++) {
			if (userlist[index] == takeUserId) {
				return true;
			}				
		} 
		
		return false;	
	}
	
	/* ���̵� �ߺ� ���� �޼��� ��û */
	function idChcckSubmit() {
		var checkUserId = document.idCheckForm.checkUserId.value;
		var resultMsg = "";
		
		var isExist = isExistUserId(checkUserId);

		if (isExist) {
			// �ߺ� ���̵� ����
			resultMsg = checkUserId + "�� ������� ���̵��Դϴ�.<br>�ٽ� �Է��Ͻñ� �ٶ��ϴ�."; 
			alert(resultMsg);
			
			// �ߺ����̵� �Է� �ʱ�ȭ��Ű��, �ش� ���̵��Է�ĭ���� ��Ŀ�� �̵�
			document.idCheckForm.checkUserId.value = "";
			document.idCheckForm.checkUserId.focus();
			
			// id �Ӽ����� �ش� id�� ���� ������Ʈ �˻�
			document.getElementById("resultMessage").style.color = "#FF0000";
			document.getElementById("resultMessage").innerHTML = resultMsg;
	
		} else {
			resultMsg = checkUserId + "�� ��� ������ ���̵��Դϴ�."; 
			alert(resultMsg);
			document.getElementById("resultMessage").style.color = "#0078D8";
			document.getElementById("resultMessage").innerHTML = resultMsg;
		}
		
	}
	
	/* �������� ���̵� ����ϱ� : 
	   �������� ���̵�� �θ�������(ȸ������)�� ���̵� �������Ŀ�
	   ����������(���̵����) �ݰ� �θ�������(ȸ������������)���� �̵�*/
	function idCheckCommit() {
		window.opener.document.memberInputForm.userId.value = document.idCheckForm.checkUserId.value;
		window.close();
	}
</script>	
</head>

<body>
<div style="width:600;height:50;background:#D4D0C8;float:center">���̵� �ߺ� üũ</div>

<form name="idCheckForm" method="post">
	<table border="1" width="250" height="100">
		<tr>
			<td><input type="text" name="checkUserId" value="" style="width:150px;background:#D2FFD2"></td>
			<td><input type="button" value="�ߺ�Ȯ��" onClick="idChcckSubmit()"></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<span id="resultMessage" style="font-size:12px">���̵� ���� ��� �޼��� ��¿���</span>
			</td>
		</tr>
		
		<tr><td colspan="2">&nbsp;</td></tr>
		
		<tr>
			<td colspan="2"  align="center">
				<input type="button" value="���̵� ����ϱ�" onclick="idCheckCommit()">
			</td>
		</tr>
	</table>
</form>	
</body>
</html>