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
</head>

<body>
<%
	String CONTEXT_PATH = request.getContextPath();
	application.setAttribute("CONTEXT_PATH", request.getContextPath());
	System.out.println("\n### CONTEXT_PATH : " + application.getAttribute("CONTEXT_PATH"));
%>

<div class="top">
	<!-- 조각페이지 경로설정 : 해당컨텍스트 root를 시작으로 절대경로 -->
	<jsp:include page="/inc/inc_top.jsp" />
</div>

<div class="content">
	<h3>Welcome Content</h3>
	<a href="${applicationScope.CONTEXT_PATH}/member/login.jsp">
	<img src="<%= CONTEXT_PATH %>/images/login.jpg" width="30px" height="25px" alt="Member Login">
	</a>
	
	<a href="${applicationScope.CONTEXT_PATH}/member/memberInput.jsp">
	<img src="${applicationScope.CONTEXT_PATH}/images/join.png" width="30px" height="25px" alt="Member Join">
	</a>
	
	<a href="controller?action=memberList">
	<img src="${applicationScope.CONTEXT_PATH}/images/list.png" width="30px" height="25px" alt="Member List">
	</a>

	<a href="${applicationScope.CONTEXT_PATH}/controller?action=memberFind">
	<img src="${applicationScope.CONTEXT_PATH}/images/memberFind.jpg" width="30px" height="25px" alt="Member Find">
	</a>
	
</div>

<div class="footer">
	<jsp:include page="/inc/inc_footer.jsp" />
</div>

</body>
</html>