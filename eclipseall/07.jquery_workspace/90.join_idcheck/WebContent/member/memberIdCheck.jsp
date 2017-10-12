<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	
	/* 페이지 load 이벤트 핸들러 함수 
			메인윈도우 정보 가져오기 :
			window.opener : open() 메소드로 윈도우를 연 문서가 있는 부모윈도우 객체
	*/
	window.onload = function() {
		// 부모윈도우(회원가입페이지)로 부터 입력한 아이디 데이터 가져오기
		var takeUserId = window.opener.document.memberInputForm.userId.value;
		// 가져온 아이디로 아이디 검증하기위한 
		// 자식윈도우(현재 아이디중복확인페이지)의 아이디 초기값으로 설정
		idCheckForm.checkUserId.value = takeUserId;
	}
	
	/* 아이디 존재 유무 검사 메서드 
		 -- 아규먼트로 전달받은 아이디가 존재하는지 검사해서 존재하면 true 반환
	*/
	function isExistUserId(takeUserId) {
		var userlist = new Array("user01", "user02", "user03");
		for (index = 0; index < userlist.length; index++) {
			if (userlist[index] == takeUserId) {
				return true;
			}				
		} 
		
		return false;	
	}
	
	/* 아이디 중복 검증 메서드 요청 */
	function idChcckSubmit() {
		var checkUserId = document.idCheckForm.checkUserId.value;
		var resultMsg = "";
		
		var isExist = isExistUserId(checkUserId);

		if (isExist) {
			// 중복 아이디 존재
			resultMsg = checkUserId + "는 사용중인 아이디입니다.<br>다시 입력하시기 바랍니다."; 
			alert(resultMsg);
			
			// 중복아이디 입력 초기화시키고, 해당 아이디입력칸으로 포커스 이동
			document.idCheckForm.checkUserId.value = "";
			document.idCheckForm.checkUserId.focus();
			
			// id 속성으로 해당 id를 갖는 엘리먼트 검색
			document.getElementById("resultMessage").style.color = "#FF0000";
			document.getElementById("resultMessage").innerHTML = resultMsg;
	
		} else {
			resultMsg = checkUserId + "는 사용 가능한 아이디입니다."; 
			alert(resultMsg);
			document.getElementById("resultMessage").style.color = "#0078D8";
			document.getElementById("resultMessage").innerHTML = resultMsg;
		}
		
	}
	
	/* 검증받은 아이디 사용하기 : 
	   검증받은 아이디로 부모윈도우(회원가입)의 아이디를 설정한후에
	   현재윈도우(아이디검증) 닫고 부모윈도우(회원가입페이지)으로 이동*/
	function idCheckCommit() {
		window.opener.document.memberInputForm.userId.value = document.idCheckForm.checkUserId.value;
		window.close();
	}
</script>	
</head>

<body>
<div style="width:600;height:50;background:#D4D0C8;float:center">아이디 중복 체크</div>

<form name="idCheckForm" method="post">
	<table border="1" width="250" height="100">
		<tr>
			<td><input type="text" name="checkUserId" value="" style="width:150px;background:#D2FFD2"></td>
			<td><input type="button" value="중복확인" onClick="idChcckSubmit()"></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<span id="resultMessage" style="font-size:12px">아이디 검증 결과 메세지 출력영역</span>
			</td>
		</tr>
		
		<tr><td colspan="2">&nbsp;</td></tr>
		
		<tr>
			<td colspan="2"  align="center">
				<input type="button" value="아이디 사용하기" onclick="idCheckCommit()">
			</td>
		</tr>
	</table>
</form>	
</body>
</html>