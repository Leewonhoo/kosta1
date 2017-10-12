<%
	String name = request.getParameter("uname");
	String pswd = request.getParameter("password");

	if (name.equals("scott") && pswd.equals("tiger")) {
%>
		<%= "Welcome " + name %>
<%
	} else {
%>
		<%= "Sorry you are not authorized" %>
<%
}
%>