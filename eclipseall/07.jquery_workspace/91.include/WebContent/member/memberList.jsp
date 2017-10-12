<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- css -->
<link type="text/css" rel="stylesheet" href="${applicationScope.CONTEXT_PATH}/css/common.css">
<!-- javascript -->
<script type="text/javascript" src="${applicationScope.CONTEXT_PATH}/js/common.js"></script>
<%
	String CONTEXT_PATH = request.getContextPath();
	application.setAttribute("CONTEXT_PATH", CONTEXT_PATH);
	System.out.println("\n### CONTEXT_PATH : " + application.getAttribute("CONTEXT_PATH"));
%>
</head>
<body>
<div class="top">
	<jsp:include page="/inc/inc_top.jsp" />
</div>

<div class="content">
	<h3>${requestScope.title}</h3>
	<img src="${applicationScope.CONTEXT_PATH}/images/list.png" width="30px" height="25px">
</div>

<div class="footer">
	<jsp:include page="/inc/inc_footer.jsp" />
</div>

</body>
</html>