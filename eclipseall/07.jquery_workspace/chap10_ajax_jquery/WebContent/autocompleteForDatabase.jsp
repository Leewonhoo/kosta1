<%@page import="work.model.StudentDAO" %>
<%
	String name = request.getParameter("userid");
	StudentDAO dao = new StudentDAO();
	String[] results = dao.search(name);
	for (int i=0; i < results.length; i++) {
%>
	<li><%= results[i] %></li>
<%
	}
%>