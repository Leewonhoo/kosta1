<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

 <%
 	request.setCharacterEncoding("utf-8");	// post 요청 파라메타데이터 디코딩
 	String name = request.getParameter("name");
 	
 	if (request.getMethod().equals("GET")) {
 		name = new String(name.getBytes("8859_1"), "utf-8"); // get 요청 파라메타데이터 디코딩
 	}
 %>
 
 안녕하세요. <%= name%>님 환영합니다.[Http Method: <%= request.getMethod() %>]