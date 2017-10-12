
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ID/PW search</title>

<script type="text/javascript">

</script>

</head>
<body>
	<p align="center"><a href="Index.jsp"><img title="W Cafe Logo" alt="로고" src="images/Logo.jpg" align="middle"></a></p>
	<br>
	
	<!-- 아이디 UI -->
	<h2 align="center">아이디 찾기</h2>
	<hr align="center" width="60%"><br>
	
	<form name="idsearch" action="Member">
		<table border="1" width="50%" align="center">
			<caption>★ 찾으시려는 아이디의 정보를 입력해주세요.</caption>
			<tr>
				<td><span>이름</span></td>
				<td><input type="text" size="40" name="idName">
				</td>
			</tr>
			<tr>
				<td><span>생년월일</span></td>
				<td>
					<select name="sel_year">
					<option>2001</option>
					<option>2000</option>
					<option>1999</option>
					<option>1998</option>
					<option>1997</option>
					<option>1996</option>
					<option>1995</option>
					<option>1994</option>
					<option>1993</option>
					<option>1992</option>
					<option>1991</option>
					<option>1990</option>
					<option>1989</option>
					<option>1988</option>
					<option>1987</option>
					<option>1986</option>
					<option>1985</option>
					<option>1984</option>
					<option>1983</option>
					<option>1982</option>
					<option>1981</option>
					<option>1980</option>
					<option>1979</option>
					<option>1978</option>
					<option>1977</option>
					<option>1976</option>
					<option>1975</option>
					<option>1974</option>
					<option>1973</option>
					<option>1972</option>
					<option>1971</option>
					<option>1970</option>
				</select>
			 / <select name="sel_month">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
					<option>7</option>
					<option>8</option>
					<option>9</option>
					<option>10</option>
					<option>11</option>
					<option>12</option>
				</select>
			 / <select name="sel_day">
					<option>01</option>
					<option>02</option>
					<option>03</option>
					<option>04</option>
					<option>05</option>
					<option>06</option>
					<option>07</option>
					<option>08</option>
					<option>09</option>
					<option>10</option>
					<option>11</option>
					<option>12</option>
					<option>13</option>
					<option>14</option>
					<option>15</option>
					<option>16</option>
					<option>17</option>
					<option>18</option>
					<option>19</option>
					<option>20</option>
					<option>21</option>
					<option>22</option>
					<option>23</option>
					<option>24</option>
					<option>25</option>
					<option>26</option>
					<option>27</option>
					<option>28</option>
					<option>29</option>
					<option>30</option>
					<option>31</option>
				</select>
				</td>
			</tr>
			<tr>
				<td><span>질문</span></td>
				<td>
					<select name="sel_question">
						<option value="1">기억에 남는 추억의 장소는?</option>
						<option value="2">존경하는 인물은?</option>
						<option value="3">좋아하는 물건은?</option>
						<option value="4">좋아하는 글귀는?</option>
						<option value="5">하고싶지 않은일 할 때 하는 표정은?</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><span>답변</span></td>
				<td><input type="text" size="40" name="idAnswer">
				</td>
			</tr>
		</table>
		<p align="center">
			<input type="submit" value="아이디 찾기">
			<span></span>
			<input type="button" value="취소">
		</p>
		<input type="hidden" name="action" value="idSearch">
	</form>
	
	<br><br>
	
	<!-- 비밀번호 UI -->
	<h2 align="center">비밀번호 찾기</h2>
	<hr align="center" width="60%"><br>
	
	<form name="pwsearch" action="MemberServlet">
		<table border="1" width="50%" align="center">
			<caption>★ 찾으시려는 비밀번호의 정보를 입력해주세요.</caption>
			<tr>
				<td><span>아이디</span></td>
				<td><input type="text" size="40" name="pwId">
				</td>
			</tr>
			<tr>
				<td><span>이름</span></td>
				<td><input type="text" size="40" name="pwName">
				</td>
			</tr>
			<tr>
				<td><span>생년월일</span></td>
				<td>
					<select name="sel_year">
					<option>2001</option>
					<option>2000</option>
					<option>1999</option>
					<option>1998</option>
					<option>1997</option>
					<option>1996</option>
					<option>1995</option>
					<option>1994</option>
					<option>1993</option>
					<option>1992</option>
					<option>1991</option>
					<option>1990</option>
					<option>1989</option>
					<option>1988</option>
					<option>1987</option>
					<option>1986</option>
					<option>1985</option>
					<option>1984</option>
					<option>1983</option>
					<option>1982</option>
					<option>1981</option>
					<option>1980</option>
					<option>1979</option>
					<option>1978</option>
					<option>1977</option>
					<option>1976</option>
					<option>1975</option>
					<option>1974</option>
					<option>1973</option>
					<option>1972</option>
					<option>1971</option>
					<option>1970</option>
				</select>
			 / <select name="sel_month">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
					<option>7</option>
					<option>8</option>
					<option>9</option>
					<option>10</option>
					<option>11</option>
					<option>12</option>
				</select>
			 / <select name="sel_day">
					<option>01</option>
					<option>02</option>
					<option>03</option>
					<option>04</option>
					<option>05</option>
					<option>06</option>
					<option>07</option>
					<option>08</option>
					<option>09</option>
					<option>10</option>
					<option>11</option>
					<option>12</option>
					<option>13</option>
					<option>14</option>
					<option>15</option>
					<option>16</option>
					<option>17</option>
					<option>18</option>
					<option>19</option>
					<option>20</option>
					<option>21</option>
					<option>22</option>
					<option>23</option>
					<option>24</option>
					<option>25</option>
					<option>26</option>
					<option>27</option>
					<option>28</option>
					<option>29</option>
					<option>30</option>
					<option>31</option>
				</select>
				</td>
			</tr>
			<tr>
				<td><span>질문</span></td>
				<td>
					<select name="sel_question">
						<option value="1">기억에 남는 추억의 장소는?</option>
						<option value="2">존경하는 인물은?</option>
						<option value="3">좋아하는 물건은?</option>
						<option value="4">좋아하는 글귀는?</option>
						<option value="5">하고싶지 않은일 할 때 하는 표정은?</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><span>답변</span></td>
				<td><input type="text" size="40" name="pwAnswer">
				</td>
			</tr>
		</table>
		<p align="center">
			<input type="submit" value="비밀번호 찾기">
			<span></span>
			<input type="button" value="취소">
		</p>
		<input type="hidden" name="action" value="pwSearch">
	</form>
</body>
</html>