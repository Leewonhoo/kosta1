<jsp:directive.page contentType="text/html;charset=utf-8"/>
<%
/* jsp 장점
1. 서버는 필수, 실행시에 이 서버가 자체적으로 jsp가 서비스시에 필요한 객체(내장객체)들을 자동 생성
2. 개발자는 활용만 하시면 됨
3. HttpServletRequest 객체(request) - client요청 정보를 보유한 객체
    PrintWriter객체(out) - client에게 2byte(text기반) 출력객체 
*/

request.setCharacterEncoding("utf-8");		// utf-8
String name=request.getParameter("name");
%>
Hello, <%=name%><br></br>
<%
  	out.println("Hello, " + name);
%>
