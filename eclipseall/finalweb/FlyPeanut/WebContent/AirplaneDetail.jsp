
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="work.model.dto.AirplaneDto"%>


<% 
	if (request.getAttribute("viewairplane") != null) {
		AirplaneDto ndto = (AirplaneDto)request.getAttribute("viewairplane"); 
	
%>
	<table width="600px" border="0" cellpadding="0" cellspacing="0" align="center">
		<h3 align="center">비행기 조회</h3>
		<tr style= "margin-bottom:50px;">
			<td width="300px" height="30px" align="center">고유 번호</td>
			<td width="600px" align="left"><%= ndto.getaNum() %></td>
		</tr>
		<tr>
			<td width="300px" height="30px" align="center">기종</td>
			<td width="600px" align = "left"><%= ndto.getaKind() %></td>
		</tr>
		<tr>
			<td width="300px" height="30px" align="center">종류</td>
			<td width="600px" align = "left"><%= ndto.getaType() %></td>
		</tr>
		<tr>
			<td width="300px" height="30px" align="center">승객</td>
			<td align = "left"><%= ndto.getaPax() %>명</td>
		</tr>
		<tr>
			<td width="300px" height="30px" align="center">제조일</td>
			
			<td align = "left"><%= ndto.getaMdate() %>
	</td>
		</tr>
		<tr>
			<td width="300px" height="30px" align="center">제조사</td>
			<td align = "left"><%= ndto.getaMake() %></td>
		</tr>
		<tr>
			<td width="300px" height="30px" align="center">제조국가</td>
			<td align = "left"><%= ndto.getaState() %></td>
		</tr>
		<tr>
			<td width="300px" height="30px" align="center">First Class</td>
			<td width="300px" align="left"><%=ndto.getaFirstRow() %><%=ndto.getaFirstCol() %></td>
		</tr>
		
		<tr>
			<td width="300px" height="30px" align="center">Business Class</td>
			<td width="300px" align="left"><%=ndto.getaBusinessRow() %><%=ndto.getaBusinessCol() %> </td>
		</tr>
		
		<tr>
			<td width="300px" height="30px" align="center">Economy Class</td>
			<td width="300px" align="left"><%=ndto.getaEconomyRow() %><%=ndto.getaEconomyCol() %></td>
		
	</table>
	<%} %>

