<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

 <%
 	request.setCharacterEncoding("utf-8");	// post ��û �Ķ��Ÿ������ ���ڵ�
 	String name = request.getParameter("name");
 	
 	if (request.getMethod().equals("GET")) {
 		name = new String(name.getBytes("8859_1"), "utf-8"); // get ��û �Ķ��Ÿ������ ���ڵ�
 	}
 %>
 
 �ȳ��ϼ���. <%= name%>�� ȯ���մϴ�.[Http Method: <%= request.getMethod() %>]