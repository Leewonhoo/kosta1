<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�α���</title>
<script type="text/javascript">
	function loginchk() {
		var regx = /^[a-zA-Z0-9]*$/;
		var memberid = document.form.m_id.value;
		var memberpw = document.form.m_pw.value;
		if (id.length == 0 || memberid == null) {
			alert("���̵� �Է��Ͻÿ�");
			document.form.memberid.focus();
			return;
		}
		if (!regx.test(memberid)) {
			alert("���̵�� ����, ���ڸ� �Է°����մϴ�.");
			document.form.memberid.focus();
			return false;
		}
		if (memberpw.length < 6 || memberpw == null) {
			alert("��й�ȣ�� 6�����̻��Դϴ�");
			document.form.memberpw.focus();
			return;
		}
		if (!regx.test(memberpw)) {
			alert("��й�ȣ�� ����, ���ڸ� �Է°����մϴ�.");
			document.form.memberpw.focus();
			return false;
		}
		document.mLoginForm.submit();
	}
	function modiInfor(){
		<% if (session.getAttribute("userId") != null){%>
			location.href="Passcheck.jsp";
		<%	} else { %>
				alert("�α������ּ���");
		<% } %>
	}
	function modiPass(){
		<% if (session.getAttribute("userId") != null){%>
			location.href="Repass.jsp";
		<%	} else { %>
				alert("�α������ּ���");
		<% } %>
	}
</script>
</head>
<body>
	<% if (request.getAttribute("message") != null) { %>
		<script>alert("<%=request.getAttribute("message")%>");</script>
	<%	} %>
<table width="1400" height="650" align="center" border="1">
	<tr>
		<td rowspan="2" width="40%" height="15%">
			<a href="Login.jsp"><img src="images/logo.jpg" width="100" height="50"></a>
			�ǳӿ��� ���հ����� �������Դϴ�.
		</td>
		<td rowspan="2">
			<a href="javascript:modiInfor()">���� ���� ��ȸ</a>
			<a href="javascript:modiPass()">��й�ȣ ����</a>
			<a href="${PATH}/BoardController?action=b_list">���� �� �Խ���</a>
			<a href="Reservation.jsp">����</a>
		</td>
		<td></td>
	</tr>
	<tr>
		<td>
			<% if (session.getAttribute("userId") != null){ %>
			<%= session.getAttribute("userId") %><span>�� ȯ���մϴ�.</span><a href="${PATH}/MemberController?action=m_logout">�α׾ƿ�</a>
			<% } %>
		</td>
	</tr>
	<tr>
		<td></td>
		<td width="50%" height="70%">
			<form action="${PATH}/MemberController" method="post" name="mLoginForm">

				<table align="right">
					<tr>
						<td>ȸ�� �α���</td>
					</tr>
					
					<tr>
						<td>&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td>
							ID<span style="margin: 5px"/><input type="text" size="10" maxlength="15" name="m_id" id="m_id">
						</td>
						<td rowspan="2" height="10px">
							<input type="hidden" name="action" value="m_login">
							<input type="submit" value="LOGIN" onclick="loginchk()">
						</td>
					</tr>
					<tr>
						<td>
							PW<span style="margin: 5px"/><input type="password" size="10" maxlength="15" name="m_pw" id="m_pw">
						</td>
					</tr>
					
					<tr>
						<td>&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;</td>
					</tr>
					<tr >
						<td colspan="2" >
							<input type="button" id="bt_join" name="bt_join" value="ȸ������" onclick="location='JoinName.jsp'">
							<input type="button" id="bt_idpw" name="bt_idpw" value="���̵� ��й�ȣã��" onclick="location='Search.jsp'">
						</td>
					</tr>
				</table>
			</form>
		</td>
		<td width="50%" height="70%">
			<form action="${PATH}/Controller" method="post" name="bLoginForm">
				<table align="left" border="1">
					<tr>
						<td>��ȸ�� ���� �α���</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td>
							<span>
								<input type="text" size="10" maxlength="15"name="email1" id="email1">
								@
								<input type="text" size="10" maxlength="15" name="email2" id="email2">
							</span>&nbsp;
							<input type="submit" name="submit" id="submit" value="LOGIN">
							<input type="hidden" name="action" value="login">
						</td>
					</tr>
					<tr>
						<td>
							<textarea name="textarea" rows="3" cols="38">1. �����ϴ� �������� �׸� �� �������
									1) �����׸� ��. �ΰ� ���� �� ����� ���� �̿� �������� �ش� ������ �̿��ڿ� ���ؼ��� �Ʒ��� ���� �������� ������ �� �ֽ��ϴ�. <��ȸ�� �װ��� ����߱�>- �ʼ��׸� : ����, ��ȭ��ȣ(�޴��� ��ȣ, ���� ��ȣ �� ����), �̸����ּ�<Ȩ������, SNS Q&A �̿� �� �̺�Ʈ ����>- �ʼ��׸� : ����, ��ȭ��ȣ(�޴��� ��ȣ, ���� ��ȣ �� ����), �̸����ּ�<��ȸ������ ���༾�� ���� ���� ���� �� �̺�Ʈ ����>- �ʼ��׸� : ����, ��ȭ��ȣ(�޴��� ��ȣ, ���ù�ȣ, �̸����ּ� �� ����)
									��. ���� ���� �̿� �������� �Ʒ��� ���� ���� �������� ������ �� �ֽ��ϴ�. <��� ����>- �ſ�ī�� ������ : ī���ȣ �� ī�� �������� ��- �ǽð� ������ü ������ : ���¹�ȣ �� �������� �ڵ� ��
									2) ���� ��� �� ���� �� �������� ������� : Ȩ������ �� SNS (ȸ������, Q&A�Խ���), �̺�Ʈ ����, ���޻�κ����� ����
									�� �������� ���� ���� ��� - �¶��� : ȸ��� ���� �������� ó����ħ �Ǵ� �̿����� ���뿡 ���� '�����ԡ� ��ư�� Ŭ���� �� �ִ� ������ �����ϰ� ������, '������' ��ư�� Ŭ���ϸ� �������� ������ ���� ������ ������ ���ϴ�. 
							</textarea>
						</td>
					</tr>
					
					<tr>
						<td>
							<p style="font-size:small"><input type="checkbox" value="agree">��� ���������� ����, �̿� ���׿� �����մϴ�.</p>
							<p style="font-size:x-small">* ��ȸ�� ���� �� ����Ʈ ����, ��� ���� �� �̺�Ʈ ������ ��ȸ�� ��ǵ˴ϴ�.<br>
							* �װ��� ���� ������ ����������>���� ���� ��ȸ/����/���>�¶��� ���೻��><br>��ȸ�� �����������⿡�� ���� �� �ֽ��ϴ�.</p>
						</td>
					</tr>
				</table>
			</form>
		</td>
	</tr>
	<tr>
		<td colspan="2" width="100%" height="15%"></td>
	</tr>
</table>
</body>
</html>