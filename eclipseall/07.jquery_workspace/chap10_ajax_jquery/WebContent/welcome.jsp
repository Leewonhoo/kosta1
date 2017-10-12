<%
	String name = request.getParameter("uname");
%>
<%= "[" + request.getMethod() +"] " %>
<%= "Welcome " + name %>
