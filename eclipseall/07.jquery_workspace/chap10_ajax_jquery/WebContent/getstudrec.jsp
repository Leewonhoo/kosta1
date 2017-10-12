<%@page import="work.model.*" %>
<%@page import="java.util.*" %>

<table border="1">
<thead>
<tr><th>Roll</th><th>Name</th><th>Marks</th></tr>
</thead>

<tbody>
<%
	StudentDAO dao = new StudentDAO();
	ArrayList<Student> results = dao.search();
	Student s = null;
	for (int i=0; i < results.size(); i++) {
		s = (Student)results.get(i);
%>
	<tr>
	<td><%= s.getRoll() %></td>
	<td><%= s.getName() %></td>
	<td><%= s.getMarks() %></td>
	</tr>
<%
	}
%>
</tbody>
</table>