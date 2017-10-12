/* 회원가입 : join.js */

/* 회원가입 데이터 검증 및 요청 
	1. 필수입력항목 

*/
function confirmData() {
	
}

/* 아규먼트로 전달받은 form을 reset */
function clearData() {

}

/* checkboxk 전체선택 및 전체해제 */
function interestAllChecked() {
	var takeElementIntrest = document.joinForm.interest;
	if (document.joinForm.interestAll.checked) {
		allChecked();
		/*
		for (index=0; takeElementIntrest.length ; index++ ) {
			if(takeElementIntrest[index].checked == false) {
				takeElementIntrest[index].click();
			}
		}*/
		
	} else {
		allUnChecked();
		/*
		for (index=0; takeElementIntrest.length ; index++ ) {
			if(takeElementIntrest[index].checked == true) {
				takeElementIntrest[index].click();
			}
		}*/		
	}
}

/* 아규먼트로 전달받은 값에 따라 전체 선택 또는 전체해제 */
function interestChecked(takeFlag) {
	var takeElements = document.joinForm.interest;

	if (takeFlag) { // true : 전체 선택
		for(var index = 0; index < takeElements.length; index++) {
			if (takeElements[index].checked == false) {
				takeElements[index].click();
			}
		}
	} else { // false : 전체 해제
		for(index = 0; index < takeElements.length; index++) {
			if (takeElements[index].checked == true) {
				takeElements[index].click();
			}
		}
	}
}

/* checkbox 전체 선택  */
function allChecked() {
	//alert("allChecked");
	var takeElements = document.joinForm.interest;
	for(var index = 0; index < takeElements.length; index++) {
		if (takeElements[index].checked == false) {
			takeElements[index].click();
		}
	}
}

/* checkbox 전체 해제 */
function allUnChecked() {
	//alert("allUnChecked");
	var takeElements = document.joinForm.interest;
	for(index = 0; index < takeElements.length; index++) {
		if (takeElements[index].checked == true) {
			takeElements[index].click();
		}
	}
}

/* checkbox 반전 선택 */
function reverseChecked() {
	//alert("reverseChecked");
	var takeElements = document.joinForm.interest;
	for(index = 0; index < takeElements.length; index++) {
		takeElements[index].click();
	}
}

/* 자기소개 최대길이 검증 : 최대길이 아규먼트로 전달받음 */
function myIntroMaxLength(takeLength) {
	//alert("myIntroMaxLength : " + takeLength);
	var myIntro = document.joinForm.myIntro.value;
	var myIntroLength = myIntro.length;
	var takeElement = document.getElementById("myIntroLength");
	if (myIntroLength <= takeLength) {
		takeElement.innerHTML = "<b style='color:blue'>" + myIntroLength + "</b>";
	} else {
		alert("자기소개는 10자리 이내로 입력하시기 바랍니다.");
		document.joinForm.myIntro.value = myIntro.substring(0, myIntroLength-1);
	}
}

/* 이메일 선택시 도메인 자동 출력 */
function displayEmail(takeEmailValue) {
	//alert("displayEmail");
	var email1 = document.joinForm.email1.value
	if (email1 != null && email1.length > 0) {
		document.joinForm.email2.value = takeEmailValue;
	} else {
		alert("이메일을 먼저 입력하시기 바랍니다.");
		document.joinForm.email1.focus();
		document.joinForm.emailSelect.selectedIndex = 0;
	}
}

/* 암호와 암화확인 데이터 일치 검증 */
function mappingUserpw() {
	//alert("mappingUserpw");

	var userpw = document.joinForm.userpw.value;
	var userpw2 = document.joinForm.userpw2.value;
	var displayUserpwElement = document.getElementById("displayUserpw");
	
	// 암호, 암호확인 입력
	if (userpw != null && userpw.length > 0 &&
		userpw2 != null && userpw2.length > 0) {
		// 암호, 암호확인 일치
		if (userpw == userpw2) {
			displayUserpwElement.innerHTML = "암호 일치";
		} else { // 암호, 암호확인 불일치
			displayUserpwElement.innerHTML = "암호 불일치";
		}

	} else {
		// 암호 미입력
		if (userpw == null || userpw.length == 0) {
			displayUserpwElement.innerHTML = "암호 미입력";
			document.joinForm.userpw.focus();
		} else if(userpw2 == null || userpw2.length == 0) {
			displayUserpwElement.innerHTML = "암호확인 미입력";
			document.joinForm.userpw2.focus();
		}
	}
}

/* 암호확인 포커스 이동시에 암호확인 메세지 "암호 일치" 로 
   암호확인 체크 
   
	1. 암호메세지 엘리먼트 추출 : <span>
	2. 암호메세지 Text 노드 추출 : <span>암호 일치</span>
	3. 암호메세지 데이터값 추출 : 암호 일치 , 암호 불일치
	4. 메세지 데이터 비교후 처리
	5. 암호 불일치이면 암호확인 포커스 이동, 공백문자열, 암호 매핑 메세지 초기화
	6. 암호 일치이면 암호 매핑 메세지 초기화
   */
function mappingUserpwCheck() {
	var takeElementSpan = document.getElementById("displayUserpw");
	var takeTextNode = takeElementSpan.firstChild;
	var mappingMsg = takeTextNode.nodeValue;
	if (mappingMsg == "암호 불일치") {
		document.joinForm.userpw2.focus();
		document.joinForm.userpw2.value = "";
		takeElementSpan.innerHTML = "";
	} else {
		takeElementSpan.innerHTML = "";
	}
}