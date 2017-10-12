/*
	XMLHttpRequest 객체에 대한 전역 변수 선언 :
	getXMLHttpRequest() 함수로 생성한 객체를 저장
*/ 
var xhr = null;	


/* ****************************************************************
 1. XMLHttpRequest 객체 생성                                           
******************************************************************/
function getXMLHttpRequest() {
	if (window.ActiveXObject) {	// IE 브라우저 : ActiveX 객체로 제공
		try {
			return new ActiveXObject("Msxml2.XMLHTTP");  // IE 6.0 ActiveXObject new version
		} catch(e) {
			try {
				return new ActiveXObject("Microsoft.XMLHTTP");
			} catch(e1) { return null; }
		}
	} else if (window.XMLHttpRequest) {	 // IE 7.0 이후, 기타 브라우저(파이어폭스, 오페라등) : XMLHttpRequest 클래스제공
		return new XMLHttpRequest();
	} else {
		return null;
	}
}



/* ****************************************************************
 2. 웹서버에 요청 전송하기                                           
*******************************************************************
 2-1) open(요청방식, url, asynchronous_mode) : 요청초기화, get/post 선택, 접속 url 입력 
 2-2) send(null | parameter-data) : 웹서버에 요청 전송                                  
		가) GET 방식 :
			1) xhr = getXMLHttpRequest();
			2) xhr.open("GET", encodeURI("/test.jsp?id=admin&pw=1111"), true); 
				xhr.open("GET", "/test.jsp", true); 
			3) xhr.send(null);		
		
		나) POST 방식:
			1) xhr = getXMLHttpRequest();
			2) xhr.open("POST", "/test.jsp, true); 
			3) xhr.send("id=admin&pw=1111");
 ********************************************************************/
function sendRequest(url, params, callback, method) {
	xhr = getXMLHttpRequest();   // 1.XMLHttpRequest 객체 생성
	var httpMethod = method ? method : 'GET';
	if (httpMethod != 'GET' && httpMethod != 'POST') {
		httpMethod = 'GET';
	}
	var httpParams = (params == null || params == '') ? null : params;
	var httpUrl = url;
	if (httpMethod == 'GET' && httpParams != null) {
		httpUrl = encodeURI(httpUrl + "?" + httpParams);  // get 요청시 : "/test.jsp?id=admin&pw=1111"
	}
	
	// 2-1: http메서드지정, 접속url(보안상 같은 도메인 위치시킴), 비동기(true 크로스브라우저 권장)/동기(false) 방식지정
	xhr.open(httpMethod, httpUrl, true);  
	xhr.setRequestHeader(
		'Content-Type', 'application/x-www-form-urlencoded');
	xhr.onreadystatechange = callback;		// readyState 변경시 콜백함수호출
	xhr.send(httpMethod == 'POST' ? httpParams : null);  // 2-2
}


/* ****************************************************************
 3. 응답 파싱 처리하기                                           
*******************************************************************
응답데이터 도착완료 및 요청 성공에 따른 처리하기
서버 응답도착하면 status 프로퍼티 사용해서 요청 성공 수행여부 확인 
readyState == 4 && status == 200
********************************************************************/
function callbackFunction() {
	if (xhr.readyState == 4 && xhr.status == 200) {
		// 응답데이터도착 및 요청 정상수행
		// 1. 응답 : Text 데이터
		var result = xhr.responseText;

		// 2. 응답 : XML 데이터
	} else {
		alert("에러발생 : " + xhr.status);
	}
}

