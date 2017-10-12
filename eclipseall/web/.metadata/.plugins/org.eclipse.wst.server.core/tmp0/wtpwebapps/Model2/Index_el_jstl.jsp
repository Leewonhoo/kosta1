<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>el_jstl</h1>
	\${5*3} = ${5*3}<br>
	${pageContext.request.requestURI}<br>
	Msg: ${param.Msg}<br>
	Msg: ${empty param.Msg}<br>
	Msg: ${!empty param.Msg}<br>
	Cookie: ${cookie}<br>
</body>
</html>