<%@page import="work.model.dto.Bboard"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Board</title>

<script type="text/javascript">
function select(choice) {
	document.boardForm.listed.value = 1;
	document.boardForm.submit();
}
function listmove(choice){
	document.boardForm.listed.value = choice;
	document.boardForm.submit();
}
</script>

</head>
<body>
	<form name="boardForm" action="Bocontroller" method="post">
		<p align="right">
		<select onchange="select(this.value)" name="selected">
			<option value="3">3개씩 보기</option>
			<option value="5">5개씩 보기</option>
			<option value="10">10개씩 보기</option>
			<option value="15">15개씩 보기</option>
		</select>
		<input type="hidden" name="action" value="list">
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
				HashMap<String, Bboard> hash = (HashMap)request.getAttribute("result");
				System.out.println(hash);
				if((hash == null) || (hash.isEmpty())){
			%>
					<tr> <td colspan=6>등록된 게시글이 없습니다</td> </tr>
			<%	} else {
					Bboard select = hash.get(-1);
					int selList = select.getbSelect();
					int selPage = select.getbPage();
					int selTotal = select.getbTotal();
					double pagenum = (double)selTotal/selList;
					int a = (selList*(selPage-1))+1;
					hash.remove(-1);
					for(int i=0; i<hash.size(); i++){
						Bboard dto = hash.get(a+i);
			%>
						<script>document.boardForm.selected.value = <%= selList %></script>
						<tr>
							<td align="center"><%= i+1 %></td>
							<td align="center"><a href="#"><%= dto.getbNum() %></a></td>
							<td align="center"><%= dto.getbTitle() %></td>
							<td align="center"><%= dto.getbNick() %></td>
							<td align="center"><%= dto.getbTime() %></td>
							<td align="center"><%= dto.getbVisit() %></td>
						</tr>
			<%
					}
			%>
					</table>
					<p align="center">
					<span>|</span>
			<%
					for(int i=0; i<pagenum; i++){
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