<%@page import="work.model.dto.Bmember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="modiForm" action="controller">
		<table>
			<jsp:useBean id="dto" class="work.model.dto.Bmember" scope="request"/>		
			<%
				//Bmember dto = (Bmember)request.getAttribute("dto");
				if (dto != null){
			%>
				<tr>
					<td><span>아이디</span></td>
					<td><%= dto.getmId() %></td>
				</tr>
				<tr>
					<td><span>비밀번호</span></td>
					<td>
						<input type="text" name="moPw" value="<%= dto.getmPw() %>">
					</td>
				</tr>
				<tr>
					<td><span>이름</span></td>
					<td><%= dto.getmName() %></td>
				</tr>
				<tr>
					<td><span>닉네임</span></td>
					<td>
						<input type="text" name="moPw" value="<%= dto.getmNick() %>">
					</td>
				</tr>
				<tr>
					<td><span>생일</span></td>
					<td><%= dto.getmBirth() %></td>
				</tr>
				<tr>
					<td><span>번호</span></td>
					<td><%= dto.getmPhone() %></td>
				</tr>
				<tr>
					<td><span>이메일</span></td>
					<td>
						<%
							String[] str = dto.getmMail().split("@");
						%>
						<input type="text" name="moEmail" value="<%= str[0].trim() %>">
						@  <input type="text" id="moEmail2" name="moEmail2" size="10" value="">
						<select name="moDomain">
								<option>::::::: 선택 :::::::</option>
								<option>chol.com</option>
								<option>daum.net</option>
								<option>dreamwiz.com</option>
								<option>empal.com</option>
								<option>gmail.com</option>
								<option>hanmail.net</option>
								<option>hanmir.com</option>
								<option>hanafos.com</option>
								<option>hotmail.com</option>
								<option>lycos.co.kr</option>
								<option>nate.com</option>
								<option>naver.com</option>
								<option>paran.com</option>
								<option>yahoo.co.kr</option>
								<option>직접입력</option>
						</select>
						<script>
							var takeDomain = document.modiForm.moDomain;
							var inputD = document.getElementById("moEmail2");
							var count=0;
							for (var i=0; i< takeDomain.length; i++){
								if (takeDomain[i].value == "<%= str[1].trim() %>") {
									alert("inin");
									takeDomain.seleted;
									console.log("default : "+takeDomain.defaultSelected);
									console.log("seleted : "+takeDomain.seleted);
									console.log("box : "+takeDomain.value);
									inputD.value = "<%= str[1].trim() %>";
									inputD.readOnly=true;
									break;
								} else {
									takeDomain.value = "직접입력";
									inputD.value = "<%= str[1].trim() %>";
									inputD.readOnly=false;
								}
							}
								
							document.modiForm.moDomain.value=<%= dto.getmQuest() %>
						</script>
						domain : <%= str[1].trim() %>
						all : <%= dto.getmMail() %>
					</td>
				</tr>
				<tr>
					<td><span>성별</span></td>
					<td>
						<input type="radio" name="moGender" value="M">남성
						<input type="radio" name="moGender" value="F">여성
						<script>
							var takeElement = document.modiForm.moGender;
							for (var i=0; i< takeElement.length; i++){
								if (takeElement[i].value == "<%= dto.getmGender() %>"){
									takeElement[i].click();
									break;
								}
							}
						</script>
					</td>
				</tr>
				<tr>
					<td><span>주소</span></td>
					<td><%= dto.getmAddress() %></td>
				</tr>
				<tr>
					<td><span>질문</span></td>
					<td>
						<select name="moQuestion">
						<option value="1">기억에 남는 추억의 장소는?</option>
						<option value="2">존경하는 인물은?</option>
						<option value="3">좋아하는 물건은?</option>
						<option value="4">좋아하는 글귀는?</option>
						<option value="5">하고싶지 않은일 할 때 하는 표정은?</option>
						<script>document.modiForm.rQuestion.value=<%= dto.getmQuest() %></script>
					</select>
					</td>
				</tr>
				<tr>
					<td><span>답변</span></td>
					<td>
						<input type="text" name="moAnswer" value=<%= dto.getmAnswer() %>>
					</td>
				</tr>
			<%
				}
			%>
			<tr>
				<td colspan="2">
					<input type="submit" value="변경">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>