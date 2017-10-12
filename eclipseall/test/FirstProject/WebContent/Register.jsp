<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<p><b>기본정보</b></p>
	<p>회원가입을 위한 필수입력 항목을 입력해 주십시오.</p>
	<form name="registerForm">
		<table border="1" width="90%">
			<tr height="40px">
				<td width="23%">아이디(*)</td>
				<td width="800px"><input type="text" size="20" maxlength="10">
					<input type="button" value="아이디중복확인"> (영문소문자/숫자, 4~10자)</td>
			</tr>
			<tr height="40px">
				<td>비밀번호(*)</td>
				<td width="800px">
					<input type="password" size="20" maxlength="10"> (영문 대소문자/숫자, 6~10자)</td>
			</tr>
			<tr height="40px">
				<td>비밀번호 확인(*)</td>
				<td width="800px">
					<input type="password" size="20" maxlength="10"> (영문 대소문자/숫자, 6~10자)</td>
			</tr>
			<tr height="40px">
				<td>이름(*)</td>
				<td width="800px"><input type="text" size="20"></td>
			</tr>
			<tr height="40px">
				<td>닉네임(*)</td>
				<td width="800px"><input type="text" size="20" maxlength="10"></td>
			</tr>
			<tr height="40px">
				<td>성별(*)</td>
				<td width="800px">
					<input type="radio" name="gender" value="남성">남성
					<input type="radio" name="gender" value="여성">여성</td>
			</tr>
			<tr height="40px">
				<td>생년월일(*)</td>
				<td width="800px">
					<select name="year">
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
				 / <select name="month">
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
				 / <select name="day">
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
			<tr height="40px">
				<td>비밀번호 확인 질문(*)</td>
				<td width="800px">
					<select name="confirmQuestion">
						<option value="1">기억에 남는 추억의 장소는?</option>
						<option value="2">존경하는 인물은?</option>
						<option value="3">좋아하는 물건은?</option>
						<option value="4">좋아하는 글귀는?</option>
						<option value="5">하고싶지 않은일 할 때 하는 표정은?</option>
					</select>
				</td>
			</tr>
			<tr height="40px">
				<td>비밀번호 확인 답변(*)</td>
				<td width="800px"><input type="text" size="40"></td>
			</tr>
		</table>
		
		<br><br>
		<p><b>추가 정보</b></p>
		<p>회원의 추가 정보를 입력해 주십시오.</p>
		<table border="1" width="80%">  <!-- left margin 추가 -->
			<tr height="40px">
				<td align="right">휴대전화</td>
				<td>
					<select name="number">
						<option>010</option>
						<option>011</option>
						<option>070</option>
				</select>
				 - <input type="text" size="8">
				 - <input type="text" size="8">
				</td>
			</tr>
			<tr height="40px">
				<td align="right">이메일</td>
				<td><input type="text" size="10">
				 @ <select name="domain">
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
				</td>
			</tr>
			<tr height="95px">
				<td align="right">주소</td>
				<td><input type="text" size="10">
				 - <input type="button" value="우편번호"><br>
				 <input type="text"	size="70"> 기본주소<br>
				 <input type="text" size="70"> 나머지주소</td>
			</tr>
		</table>
		<p>
				<input type="submit" value="회원 가입">
				<span>&nbsp;</span>
				<input type="reset" value="초기화">
				<span>&nbsp;</span>
				<input type="button" value="취소">
		</p>
	</form>
</body>
</html>