<%@page import="java.util.ArrayList"%>
<%@page import="work.controller.BorderServlet"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Board</title>

<script type="text/javascript">

function init(){
	
}

window.onload = function(){
	init();
}

function select(choice) {
	document.boardForm.chu.value = "list";
	document.boardForm.listed.value = 1;
	document.boardForm.submit();
}
function listmove(choice){
	document.boardForm.chu.value = "move";
	document.boardForm.listed.value = choice;
	document.boardForm.submit();
}

</script>

</head>
<body>
<form name="boardForm" action="http://localhost:8090/FirstProject/Bocontroller" method="post">

	<p align="right">
	<select onchange="select(this.value)" name="selected">
		<option value="3">3개씩 보기</option>
		<option value="5">5개씩 보기</option>
		<option value="10">10개씩 보기</option>
		<option value="15">15개씩 보기</option>
	</select>
	<input type="hidden" name="chu" value="list">
	</p>
	<table border = "1" width="80%" align="center">      
		<tr height="30px">
			<th width = "7%"><font size=2><b>번호</b></font></th>
			<th width = "15%"><font size=2><b>게시글번호</b></font></th>     
			<th width = "*%"><font size=2><b>제목</b></font></th>      
			<th width = "15%"><font size=2><b>닉네임</b></font></th>      
			<th width = "17%"><font size=2><b>등록일</b></font></th>      
			<th width = "10%"><font size=2><b>조회수</b></font></th>      
		</tr>
		
			<%
				Object obj = request.getAttribute("result");
				if(obj==null){%>
					<tr> <td colspan=6>등록된 게시글이 없습니다</td> </tr>
			<%	} else {
					Object str1 = obj.toString().replace("[", "");
					str1 = str1.toString().replace("]", "");
					String[] str = str1.toString().split(",");
					String num = str[str.length-2].trim();
					String last = str[str.length-1].trim();
					double lastnum = Integer.parseInt(last);
					double number = Integer.parseInt(num);
					double listnum2 = lastnum/number;
					for(int i=0; i<str.length-2; i++){
					String[] list = str[i].trim().split(":");
			%>
					<script>document.boardForm.selected.value = <%=num%></script>
					<tr>
						<td align="center"><%= list[0].trim() %></td>
						<td align="center"><a href="#"><%= list[1].trim() %></a></td>
						<td align="center"><%= list[2].trim() %></td>
						<td align="center"><%= list[3].trim() %></td>
						<td align="center"><%= list[4].trim() %></td>
						<td align="center"><%= list[5].trim() %></td>
				</tr>
			<%
				}
			%>
		</table>
		<p align="center">
			<span>|</span>
			<%
				for(int i=0; i<listnum2; i++){
			%>
					<a href="javascript:listmove(<%= i+1 %>)" name=<%= i+1 %>><%= i+1 %></a>
					<span>|</span>
			<%
				}
			}
			%>
			<input type="hidden" name="listed" value="1">
			</p>
	</form>
</body>
</html>