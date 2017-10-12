<%
	String emid = request.getParameter("emailadd");
	if (emid == null || emid.length() == 0) {
%>
	<%= "Required Email address" %>
<%
	}
%>
	