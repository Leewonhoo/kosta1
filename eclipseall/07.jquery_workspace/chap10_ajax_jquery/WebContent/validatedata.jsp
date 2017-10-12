<%
	String userid = request.getParameter("userid");
	if (userid == null || userid.length() == 0) {
%>
	<%= "user|Required User id\n" %>
<%
	} else {
%>
	<%= "user|\n" %>
<%
	}
%>

<%
	String emailadd = request.getParameter("emailadd");
	if (emailadd == null || emailadd.length() == 0) {
%>
	<%= "email|Required Email address\n" %>
<%
	} else {
%>
	<%= "email|\n" %>
<%
	}
%>
		