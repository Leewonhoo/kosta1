/* ȸ������ : join.js */

/* ȸ������ ������ ���� �� ��û 
	1. �ʼ��Է��׸� 

*/
function confirmData() {
	
}

/* �ƱԸ�Ʈ�� ���޹��� form�� reset */
function clearData() {

}

/* checkboxk ��ü���� �� ��ü���� */
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

/* �ƱԸ�Ʈ�� ���޹��� ���� ���� ��ü ���� �Ǵ� ��ü���� */
function interestChecked(takeFlag) {
	var takeElements = document.joinForm.interest;

	if (takeFlag) { // true : ��ü ����
		for(var index = 0; index < takeElements.length; index++) {
			if (takeElements[index].checked == false) {
				takeElements[index].click();
			}
		}
	} else { // false : ��ü ����
		for(index = 0; index < takeElements.length; index++) {
			if (takeElements[index].checked == true) {
				takeElements[index].click();
			}
		}
	}
}

/* checkbox ��ü ����  */
function allChecked() {
	//alert("allChecked");
	var takeElements = document.joinForm.interest;
	for(var index = 0; index < takeElements.length; index++) {
		if (takeElements[index].checked == false) {
			takeElements[index].click();
		}
	}
}

/* checkbox ��ü ���� */
function allUnChecked() {
	//alert("allUnChecked");
	var takeElements = document.joinForm.interest;
	for(index = 0; index < takeElements.length; index++) {
		if (takeElements[index].checked == true) {
			takeElements[index].click();
		}
	}
}

/* checkbox ���� ���� */
function reverseChecked() {
	//alert("reverseChecked");
	var takeElements = document.joinForm.interest;
	for(index = 0; index < takeElements.length; index++) {
		takeElements[index].click();
	}
}

/* �ڱ�Ұ� �ִ���� ���� : �ִ���� �ƱԸ�Ʈ�� ���޹��� */
function myIntroMaxLength(takeLength) {
	//alert("myIntroMaxLength : " + takeLength);
	var myIntro = document.joinForm.myIntro.value;
	var myIntroLength = myIntro.length;
	var takeElement = document.getElementById("myIntroLength");
	if (myIntroLength <= takeLength) {
		takeElement.innerHTML = "<b style='color:blue'>" + myIntroLength + "</b>";
	} else {
		alert("�ڱ�Ұ��� 10�ڸ� �̳��� �Է��Ͻñ� �ٶ��ϴ�.");
		document.joinForm.myIntro.value = myIntro.substring(0, myIntroLength-1);
	}
}

/* �̸��� ���ý� ������ �ڵ� ��� */
function displayEmail(takeEmailValue) {
	//alert("displayEmail");
	var email1 = document.joinForm.email1.value
	if (email1 != null && email1.length > 0) {
		document.joinForm.email2.value = takeEmailValue;
	} else {
		alert("�̸����� ���� �Է��Ͻñ� �ٶ��ϴ�.");
		document.joinForm.email1.focus();
		document.joinForm.emailSelect.selectedIndex = 0;
	}
}

/* ��ȣ�� ��ȭȮ�� ������ ��ġ ���� */
function mappingUserpw() {
	//alert("mappingUserpw");

	var userpw = document.joinForm.userpw.value;
	var userpw2 = document.joinForm.userpw2.value;
	var displayUserpwElement = document.getElementById("displayUserpw");
	
	// ��ȣ, ��ȣȮ�� �Է�
	if (userpw != null && userpw.length > 0 &&
		userpw2 != null && userpw2.length > 0) {
		// ��ȣ, ��ȣȮ�� ��ġ
		if (userpw == userpw2) {
			displayUserpwElement.innerHTML = "��ȣ ��ġ";
		} else { // ��ȣ, ��ȣȮ�� ����ġ
			displayUserpwElement.innerHTML = "��ȣ ����ġ";
		}

	} else {
		// ��ȣ ���Է�
		if (userpw == null || userpw.length == 0) {
			displayUserpwElement.innerHTML = "��ȣ ���Է�";
			document.joinForm.userpw.focus();
		} else if(userpw2 == null || userpw2.length == 0) {
			displayUserpwElement.innerHTML = "��ȣȮ�� ���Է�";
			document.joinForm.userpw2.focus();
		}
	}
}

/* ��ȣȮ�� ��Ŀ�� �̵��ÿ� ��ȣȮ�� �޼��� "��ȣ ��ġ" �� 
   ��ȣȮ�� üũ 
   
	1. ��ȣ�޼��� ������Ʈ ���� : <span>
	2. ��ȣ�޼��� Text ��� ���� : <span>��ȣ ��ġ</span>
	3. ��ȣ�޼��� �����Ͱ� ���� : ��ȣ ��ġ , ��ȣ ����ġ
	4. �޼��� ������ ���� ó��
	5. ��ȣ ����ġ�̸� ��ȣȮ�� ��Ŀ�� �̵�, ���鹮�ڿ�, ��ȣ ���� �޼��� �ʱ�ȭ
	6. ��ȣ ��ġ�̸� ��ȣ ���� �޼��� �ʱ�ȭ
   */
function mappingUserpwCheck() {
	var takeElementSpan = document.getElementById("displayUserpw");
	var takeTextNode = takeElementSpan.firstChild;
	var mappingMsg = takeTextNode.nodeValue;
	if (mappingMsg == "��ȣ ����ġ") {
		document.joinForm.userpw2.focus();
		document.joinForm.userpw2.value = "";
		takeElementSpan.innerHTML = "";
	} else {
		takeElementSpan.innerHTML = "";
	}
}