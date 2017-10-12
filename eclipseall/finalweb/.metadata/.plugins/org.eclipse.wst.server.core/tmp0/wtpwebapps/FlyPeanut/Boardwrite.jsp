<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시판 작성</title>
<script type="text/javascript" src="docs/nse_files/js/HuskyEZCreator.js" charset="EUC-KR"></script>
<script type="text/javascript">
function submitt(){
	oEditors.getById["b_content"].exec("UPDATE_CONTENTS_FIELD", []);
	document.BwriteForm.submit();
}
</script>
</head>
<script text/javascript>
<%
	request.setCharacterEncoding("EUC-KR");
	int num = 0;
	String title = "";
	String context = "";
	if (request.getParameter("mo_title") != null){
		num = Integer.parseInt(request.getParameter("mo_num"));
 		title = request.getParameter("mo_title");
 		context = request.getParameter("mo_context");
 		System.out.println("호출 : "+title+" "+context);
	}
%>
</script>
<body>
<form name="BwriteForm" action="${PATH}/BoardController" method="post">
<table width="100%">
	<tr>
		<td align="center">제목</td>
		<td><input type="text" name="b_title" maxlength="20" size="80px" value="<%= title %>"></td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea id="b_content" name="b_content" style="width: 700px; height: 500px"><%= context %></textarea>
			<script type="text/javascript">
				var oEditors = [];
				nhn.husky.EZCreator.createInIFrame({
				oAppRef : oEditors,
				elPlaceHolder : "b_content", // textarea 의 id 값 참조
				sSkinURI : "docs/nse_files/SmartEditor2Skin.html",
				fCreator : "createSEditor2"
				});
			</script>
		</td>
	</tr>
</table>
<input type="hidden" name="b_num" value="<%= num %>">
<input type="hidden" name="action" value="b_write">
<input type="button" value="등록" onclick="submitt()">
</form>
</body>
</html>