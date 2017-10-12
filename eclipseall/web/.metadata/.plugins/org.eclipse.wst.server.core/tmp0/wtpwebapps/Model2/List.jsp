<%@page import="Noti.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 초기화 재정의 멤버변수는 ! -->
	<%!
		public ArrayList<Notice> array = new ArrayList<Notice>();
	
		public void jspInit(){
			System.out.println("1. init/ 초기화");
			array.add(new Notice(1, "ti1", "mo1"));
			array.add(new Notice(2, "ti2", "mo2"));
			array.add(new Notice(3, "ti3", "mo3"));
		}
		
		public void jspDestroy(){
			System.out.println("3. destroy/ 해제");
		}
	%>
	
	<jsp:useBean id="dto" class="Noti.Notice" scope="request" />
	<jsp:setProperty property="*" name="dto"/>
	<%
		array.add(dto);
		
		for(int i=0; i<array.size(); i++){
			System.out.println(array.get(i).getNumber()+", "+array.get(i).getTitle()+", "+array.get(i).getMemo());
		}
	%>
	
	<table border="1">
		<tr>
			<td><%@ include file="Notice.jsp" %></td>
		</tr>
		<tr height="30px">
			<td></td>
		</tr>
		<tr height="30px">
			<td>
				<table border="1" width="100%">
					<tr>
						<th width="30%">번호</th>
						<th width="30%">제목</th>
						<th width="30%">내용</th>
					</tr>
				<% 
					Notice dto1 = null;
					for(int i=0; i<array.size(); i++){
						dto1 = array.get(i);
				%>
					<tr>
						<td><%= dto1.getNumber() %></td>
						<td><%= dto1.getTitle() %></td>
						<td><%= dto1.getMemo() %></td>
					</tr>
				<% } %>
				</table>
			</td>
		</tr>
		<tr height="30px">
			<td><jsp:include page="Inheader.jsp" /></td>
		</tr>
		<tr height="30px">
			<td></td>
		</tr>
		<tr height="30px">
			<td></td>
		</tr>
		<tr height="30px">
			<td></td>
		</tr>
		<tr>
			<td><jsp:include page="Infooter.jsp" /></td>
		</tr>
	</table>

</body>
</html>