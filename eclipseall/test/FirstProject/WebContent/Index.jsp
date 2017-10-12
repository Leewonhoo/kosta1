<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 전체 레이아웃 -->
	<table border="1" height="620px" width="1340px">
		<!-- header -->
		<tr>
			<td colspan="3" width="1330px" align="center">
				<a href="Index.jsp"><img title="W Cafe Logo" alt="로고" src="images/Logo.jpg" align="middle"></a>
			</td>
		</tr>
		<tr height="20px"></tr>
		<!-- 메뉴바 -->
		<tr>
			<td width="30%" align="center"><a href="#">Home</a></td>
			<td width="30%" align="center"><a href="#">MyBoard</a></td>
			<td width="30%" align="center"><a href="#">QnA</a></td>
		</tr>
		<tr height="20px"></tr>
		<!-- body -->
		<tr height="380px">
		<td colspan="3">
			<table border="1" width="1300px" height="400px" align="center">
				<tr height="50px">
					<td colspan="2">공지사항</td>
				</tr>
				<tr>
					<td colspan="2">
						<table border="1" height="100%" width="97%" align="center">
							<tr height="10%">
								<th width="70%">제목</th>
								<th width="10%">닉네임</th>
								<th width="10%">작성일</th>
								<th width="10%">조회수</th>
							</tr>
							<tr>
								<td>이번 주 공지는?</td>
								<td align="center">나임</td>
								<td align="center">52</td>
								<td align="center">2017/09/14</td>
							</tr>
							<tr>
								<td>이번 주 공지는?</td>
								<td align="center">나임</td>
								<td align="center">52</td>
								<td align="center">2017/09/14</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr height="50px">
		<form>
					<!-- 카테고리 -->
					<td width="900px">
						<a href="">전체</a>
						<span>|</span>
						<a href="">유머</a>
						<span>|</span>
						<a href="">연예</a>
						<span>|</span>
						<a href="">스포츠</a>
						<span>|</span>
						<a href="">자동차</a>
					</td>
					<!-- 검색 -->
					<td width="200px" align="center">
						<input type="text" size="20">
						<input type="image" src="images/search.jpg" title="search" width="30px" height="30px" align="middle">
					</td>
				</tr>
				<tr>
					<!-- 게시판 -->
					<td rowspan="2" width="1000px">
						<p align="right">
							<select>
								<option value="5">5개씩 보기</option>
								<option value="10">10개씩 보기</option>
								<option value="15">15개씩 보기</option>
								<option value="30">30개씩 보기</option>
							</select>
						</p>
						<table border = "1" width="90%" align="center">      
							<tr height="30px">
								<th width = "10%"><font size=2><b>번호</b></font></th>      
								<th width = "*%"><font size=2><b>제목</b></font></th>      
								<th width = "15%"><font size=2><b>닉네임</b></font></th>      
								<th width = "17%"><font size=2><b>작성일</b></font></th>      
								<th width = "10%"><font size=2><b>조회수</b></font></th>      
							</tr>
							  
							<!--  <tr> <td colspan=5>등록된 게시글이 없습니다</td> </tr>  -->
							
							<tr>     
								<td align = "center">1</td>      
								<td><a href="#">제목1</a></td>      
								<td align = "center">hello</td>      
								<td align = "center">2017/09/14</td>      
								<td align = "center">12</td>      
							</tr>
						</table>
						<p align="center">
							<span>[</span>
							<a href="#">1</a>
							<span>|</span>
							<a href="#">2</a>
							<span>|</span>
							<a href="#">3</a>
							<span>|</span>
							<a href="#">4</a>
							<span>]</span>
						</p>
					
					</td>
		</form>
					<td height="100px">
						<form action="login.html">
						<table border="1" align="center">
							<tr>
								<!-- 로그인 전 -->
								<td align="center">
									<input type="text" value="ID"/><br>
									<input type="password" value="PW">
								</td>
								<td><input type="submit" value="로그인" style="height: 50px;"></td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<a href="Search.jsp">ID/PW 찾기</a>
									<span>|</span>
									<a href="Register.jsp">회원 가입</a>
								</td>
							</tr>
						</table>
						</form>
					</td>
				</tr>
				<tr>
					<!-- 로그인 밑 빈공간 -->
					<td></td>
				</tr>
			</table>
			</td>
		</tr>
		<tr height="20px"></tr>
		<!-- foot -->
		<tr height="50px">
			<td colspan="4" width="1366px"></td>
		</tr>
	</table>
</body>
</html>