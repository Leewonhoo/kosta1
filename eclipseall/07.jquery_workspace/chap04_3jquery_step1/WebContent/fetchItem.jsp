<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" isELIgnored="false"%>
<%@ page import="model.Item" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>

<jsp:useBean id="eFridge" class="model.EFridge" />

<%-- EFidge 객체 생성 jsp tag
 model.EFridge" eFidge = new model.EFridge"();
 --%>
<%
	System.out.println(request.getParameter("id"));		//id=1..
	Item value = eFridge.getItem(request.getParameter("id"));
%>
<div><label>Item:</label><%= value.getName() %></div>
<div><label>Description:</label><%= value.getDescription() %></div>
<div><label>Category:</label><%= value.getCategory() %></div>
<div><label>Expires:</label><%= value.getExpires() %></div>
