<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="msg" value="Why so serious^^"/>
	<c:out value="${msg}" />
	<c:remove var="msg"/>
	<br>

	<c:if test="${!empty param.name}">
		이름: ${param.name}
		<br>
	</c:if>

	<c:if test="${empty param.name}">
			이름: Guest(손님)
			<br>
	</c:if>
	
	<c:if test="${!empty requestScope.errorMessage}">
		Error : ${requestScope.errorMessage}
		<br>
	</c:if>

	<c:if test="${empty param.errorMessage}">
		Error : <img src="images/jung2.jpg"/>
		<br>
	</c:if>
	<c:set var="sum" value="0"/>
	<c:forEach var="no" begin="1" end="10" step="1">
		<c:out value="${no}" />
		<c:set var="sum" value="${sum+no}"/>
	</c:forEach>
	<c:out value="결과 : ${sum}"/>
	
	
	
</body>
</html>