<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@page import="java.util.HashMap"%> 
<%@page import="java.util.ArrayList"%>
    
<%@page import="work.model.dto.AddressDto"%>
<%@page import="work.model.dto.AddressDto"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>우편번호</title>
<script>
function useAdd(){
	var radio = document.postForm.posted.value;
	var select = document.getElementById("post"+radio).innerText;
	window.opener.document.getElementById("modi_Post").value = select;
	window.opener.document.getElementById("modi_Add1").value = document.getElementById(radio).innerText;
	self.close();
}
</script>
</head>
<body>
<form name="postForm" method="post" action="${PATH}/AddressController">
<table border="1" width="100%">
	<tr>
		<th colspan="6">찾는 주소 입력(지번/도로명 입력)</th>
	</tr>
	<tr>
		<td colspan="6" align="center">
			<input type="text" name="dong">
			<input type="submit" value="검색">
			<input type="hidden" name="action" value="searchPost">
		</td>
	</tr>
	<tr>
		<td width="5%"></td>
		<td width="30%">우편번호</td>
		<td width="70%">주소</td>
	</tr>
	
	<%
		//ArrayList<Member> list;
		//ArrayList<HashMap<Integer, AddressDto>> list = (ArrayList<HashMap<Integer, AddressDto>>)request.getAttribute("selectPostList");
		//for (int index=0; index < list.size(); index++) {
			HashMap<Integer, AddressDto> dto = (HashMap)request.getAttribute("selectpost");
			//HashMap<Integer, AddressDto> dto = list.get(index);
			if ((dto != null) && (!dto.isEmpty())) {
				for(int i=0; i<dto.size(); i++){
	%>
		<tr>
			<td align="center">
				<input type="radio" id="posted" name="posted" value="<%= i %>" onclick="useAdd()">
			</td>
			<td>
				<!-- 우편번호 불러오기 -->
				<span name="post<%= i %>" id="post<%= i %>"><%= dto.get(i).getPost() %></span>
			</td>
			<td><span id="<%= i %>">
				<%= dto.get(i).getSi()+" "+dto.get(i).getGu()+" "+dto.get(i).getRoad()+" "
			+dto.get(i).getRoadNum()+"("+dto.get(i).getDong()+", "+dto.get(i).getBuild()+")" %><br>
			<%= dto.get(i).getSubdong()+" "+dto.get(i).getDongNum() %></span>
			</td>
		</tr>
	<% 
			}
		} else {
	%>
		<tr>
			<td colspan="3">등록된 정보가 없습니다.</td>
		</tr>
	<% //}
			} %>
</table>
</form>
</body>
</html>