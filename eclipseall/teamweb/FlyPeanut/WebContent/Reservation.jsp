<%@page import="work.Dto.FlightDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
 pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�ð�ǥ ��ȸ</title>
<script type="text/javascript">
var nation1 = new Array("", "KOR", "JPN", "CHI", "USA", "ITA");
var nation2 = new Array("==����==", "���ѹα�", "�Ϻ�", "�߱�", "�̱�", "��Ż����");

var city1 = new Array("==����==");
var vcity1 = new Array("");
var city2 = new Array("����/����","��õ", "û��", "����");
var vcity2 = new Array("GMP", "ICN", "CNU","JJU");
var city3 = new Array("����","������", "������ī","��Ű����");
var vcity3 = new Array("TKO", "SPR", "HKO", "OKN");
var city4 = new Array("����¡","������", "������", "�踲");
var vcity4 = new Array("BEI", "SHA", "GUG","GER");
var city5 = new Array("����","LA", "�ػ罺", "�÷θ���");
var vcity5 = new Array("NYK", "LAG", "TEX","FRI");
var city6 = new Array("�θ�","�ж��", "�Ƿ�ü", "���Ͻ�");
var vcity6 = new Array("ROM", "MIL", "FIO", "VEN");

function selectList(name, convey, value) {
	for(i=document.getElementById(convey).length-1; i>=0; i--){
		document.getElementById(convey).options[i] = null;
	}
	switch(value){
	case "KOR":
		for (k=0; k<city2.length; k++) {
			document.getElementById(convey).options[k] = new Option(city2[k],vcity2[k]);
		}
		break;
	case "JPN":
		for (k=0; k<city3.length; k++) {
			document.getElementById(convey).options[k] = new Option(city3[k],vcity3[k]);
		}
		break;
	case "CHI":
		for (k=0; k<city4.length; k++) {
			document.getElementById(convey).options[k] = new Option(city4[k],vcity4[k]);
		}
		break;
	case "USA":
		for (k=0; k<city5.length; k++) {
			document.getElementById(convey).options[k] = new Option(city5[k],vcity5[k]);
		}
		break;
	case "ITA":
		for (k=0; k<city6.length; k++) {
			document.getElementById(convey).options[k] = new Option(city6[k],vcity6[k]);
		}
		break;
	default:
		for (k=0; k<city1.length; k++) {
			document.getElementById(convey).options[k] = new Option(city1[k],vcity1[k]);
		}
	}
}
function ticket(){
	var obj1 = document.getElementById("two");
	var choose = document.ReserForm.fly.value;
	if (choose == "1"){
		obj1.style.display = "none";
		document.ReserForm.btn_sub.style.width = "120px";
		document.ReserForm.btn_sub.style.height = "30px";
	} else {
		obj1.style.display = "";
		document.ReserForm.btn_sub.style.width = "120px";
		document.ReserForm.btn_sub.style.height = "70px";
	}
}
function selected(){
	alert("A");
	document.ReserForm.action.value = "a_flight";
	alert("B");
	
	alert("C");
	document.ReserForm.submit();
}
function buy(){
	var ticketNumber = document.ReserForm.fly.value;
	var one = document.ReserForm.oneWay;
	var two = document.ReserForm.round;
	document.ReserForm.action.value = "a_seat";
	document.ReserForm.submit();
}
</script>
</head>
<body>
<form name="ReserForm" method="post" action="${PATH}/AirController">
<h3>
	<% 
		String fly = "a";
		if (request.getAttribute("radioch") != null) {
			fly = (String)request.getAttribute("radioch");
		}
		if(fly.equals("2")) {
			out.println("<input type='radio' name='fly' value='1' onchange='ticket()'>����");
			out.println("<input type='radio' name='fly' value='2' checked onchange='ticket()'>�պ�");
		} else {
			out.println("<input type='radio' name='fly' value='1' checked onchange='ticket()'>����");
			out.println("<input type='radio' name='fly' value='2' onchange='ticket()'>�պ�");
		}
		 %>
</h3>
<table align="center" width="50%" border="1">
	<tr>
		<td colspan="2" align="center">�����</td>
		<td colspan="2" align="center">������</td>
		<td></td>
	</tr>
	<tr>
		<td align="center">
			<select id="leave_nation1" name="leave_nation1" onchange="selectList(this.name, 'leave_city1', this.value)">
				<option value="">==����==</option>
				<option value="KOR">���ѹα�</option>
				<option value="JPN">�Ϻ�</option>
				<option value="CHI">�߱�</option>
				<option value="USA">�̱�</option>
				<option value="ITA">��Ż����</option>
			</select>
		</td>
		<td align="center">
			<select id="leave_city1" name="leave_city1">
				<option value="">==����==</option>
			</select>
		</td>
		<td align="center">
			<select id="arrive_nation1" name="arrive_nation1" onchange="selectList(this.name, 'arrive_city1', this.value)">
				<option value="">==����==</option>
				<option value="KOR">���ѹα�</option>
				<option value="JPN">�Ϻ�</option>
				<option value="CHI">�߱�</option>
				<option value="USA">�̱�</option>
				<option value="ITA">��Ż����</option>
			</select>
		</td>
		<td align="center">
			<select id="arrive_city1" name="arrive_city1">
				<option value="">==����==</option>
			</select>
		</td>
		<td rowspan="2" align="center">
			<input type="hidden" name="action" value="a_flight">
			<input type="button" align="middle" name="btn_sub" value="����" onclick="selected()" style="width: 120px; height: 30px">
		</td>
	</tr>
	<% if(fly.equals("2")) { %>
	<tr id="two">
	<% } else { %>
	<tr id="two" style="display: none;">
	<% } %>
		<td align="center">
			<select id="leave_nation2" name="leave_nation2" onchange="selectList(this.name, 'leave_city2', this.value)">
				<option value="">==����==</option>
				<option value="KOR">���ѹα�</option>
				<option value="JPN">�Ϻ�</option>
				<option value="CHI">�߱�</option>
				<option value="USA">�̱�</option>
				<option value="ITA">��Ż����</option>
			</select>
		</td>
		<td align="center">
			<select id="leave_city2" name="leave_city2">
				<option value="">==����==</option>
			</select>
		</td>
		<td align="center">
			<select id="arrive_nation2" name="arrive_nation2" onchange="selectList(this.name, 'arrive_city2', this.value)">
				<option value="">==����==</option>
				<option value="KOR">���ѹα�</option>
				<option value="JPN">�Ϻ�</option>
				<option value="CHI">�߱�</option>
				<option value="USA">�̱�</option>
				<option value="ITA">��Ż����</option>
			</select>
		</td>
		<td align="center">
			<select id="arrive_city2" name="arrive_city2">
				<option value="">==����==</option>
			</select>
		</td>
	</tr>
</table>
</form>
<br><br>
<%
if (request.getAttribute("list1") != null){
	ArrayList<FlightDto> list1 = (ArrayList<FlightDto>)request.getAttribute("list1");
%>
<p align="center">
	<input type="button" value="�װ��� ����" style="width: 120px; height: 80px" onclick="buy()">
</p>
<br>
<table border="1" align="center" width="80%">
	<tr>
		<th></th>
		<th width="13%">��¥</th>
		<th width="10%">������ȣ</th>
		<th width="10%">����</th>
		<th width="13%">�����</th>
		<th width="15%">��߽ð�</th>
		<th width="13%">������</th>
		<th width="15%">�����ð�</th>
		<th width="*%">����Ʈ</th>
	</tr>
	<% if(list1.isEmpty()){ %>
			<tr>
				<td colspan="9" align="center">��ϵ� ������ �����ϴ�.</td>
			</tr>
	<%	} else {
		for(int i=0; i<list1.size(); i++){
			FlightDto dto = list1.get(i);
	%>
	<tr>
		<td align="center">
			<input type="radio" name="oneWay" value="<%= i %>">
			<input type="hidden" name="r_go">
		</td>
		<td align="center"><%= dto.getfDate() %></td>
		<td align="center"><input type="hidden" name="" value="<%= dto.getfAnum() %>"><%= dto.getfAnum() %></td>
		<td align="center"><%= dto.getfFname() %></td>
		<td align="center"><%= dto.getfLeave() %></td>
		<td align="center"><%= dto.getfLevdate() %></td>
		<td align="center"><%= dto.getfArrive() %></td>
		<td align="center"><%= dto.getfArridate() %></td>
		<td align="center"><%= dto.getfGate() %></td>
	</tr>
	<% } } %>
</table>
<% } %>
<br><br><br>
<%
if (request.getAttribute("list2") != null){
	ArrayList<FlightDto> list2 = (ArrayList<FlightDto>)request.getAttribute("list2");
%>
<table border="1" align="center" width="80%">
	<tr>
		<th></th>
		<th width="13%">��¥</th>
		<th width="10%">������ȣ</th>
		<th width="10%">����</th>
		<th width="13%">�����</th>
		<th width="15%">��߽ð�</th>
		<th width="13%">������</th>
		<th width="15%">�����ð�</th>
		<th width="*%">����Ʈ</th>
	</tr>
	<% if(list2.isEmpty()){ %>
			<tr>
				<td colspan="9" align="center">��ϵ� ������ �����ϴ�.</td>
			</tr>
	<%	} else {
		for(int i=0; i<list2.size(); i++){
			FlightDto dto = list2.get(i);
	%>
	<tr>
		<td align="center"><input type="radio" name="round" value="<%= i %>"></td>
		<td align="center"><%= dto.getfDate() %></td>
		<td align="center"><%= dto.getfAnum() %></td>
		<td align="center"><%= dto.getfFname() %></td>
		<td align="center"><%= dto.getfLeave() %></td>
		<td align="center"><%= dto.getfLevdate() %></td>
		<td align="center"><%= dto.getfArrive() %></td>
		<td align="center"><%= dto.getfArridate() %></td>
		<td align="center"><%= dto.getfGate() %></td>
	</tr>
	<% } } %>
</table>
<% } %>
</body>
</html>