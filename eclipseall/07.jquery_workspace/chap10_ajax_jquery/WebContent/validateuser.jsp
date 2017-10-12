<%
	String uname = request.getParameter("uname");
	if (uname == null || uname.length() == 0) {
%>
	<%= "Required User name" %>
<%
	}
%>
	