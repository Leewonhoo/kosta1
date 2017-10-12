/*
	XMLHttpRequest ��ü�� ���� ���� ���� ���� :
	getXMLHttpRequest() �Լ��� ������ ��ü�� ����
*/ 
var xhr = null;	


/* ****************************************************************
 1. XMLHttpRequest ��ü ����                                           
******************************************************************/
function getXMLHttpRequest() {
	if (window.ActiveXObject) {	// IE ������ : ActiveX ��ü�� ����
		try {
			return new ActiveXObject("Msxml2.XMLHTTP");  // IE 6.0 ActiveXObject new version
		} catch(e) {
			try {
				return new ActiveXObject("Microsoft.XMLHTTP");
			} catch(e1) { return null; }
		}
	} else if (window.XMLHttpRequest) {	 // IE 7.0 ����, ��Ÿ ������(���̾�����, ������) : XMLHttpRequest Ŭ��������
		return new XMLHttpRequest();
	} else {
		return null;
	}
}



/* ****************************************************************
 2. �������� ��û �����ϱ�                                           
*******************************************************************
 2-1) open(��û���, url, asynchronous_mode) : ��û�ʱ�ȭ, get/post ����, ���� url �Է� 
 2-2) send(null | parameter-data) : �������� ��û ����                                  
		��) GET ��� :
			1) xhr = getXMLHttpRequest();
			2) xhr.open("GET", encodeURI("/test.jsp?id=admin&pw=1111"), true); 
				xhr.open("GET", "/test.jsp", true); 
			3) xhr.send(null);		
		
		��) POST ���:
			1) xhr = getXMLHttpRequest();
			2) xhr.open("POST", "/test.jsp, true); 
			3) xhr.send("id=admin&pw=1111");
 ********************************************************************/
function sendRequest(url, params, callback, method) {
	xhr = getXMLHttpRequest();   // 1.XMLHttpRequest ��ü ����
	var httpMethod = method ? method : 'GET';
	if (httpMethod != 'GET' && httpMethod != 'POST') {
		httpMethod = 'GET';
	}
	var httpParams = (params == null || params == '') ? null : params;
	var httpUrl = url;
	if (httpMethod == 'GET' && httpParams != null) {
		httpUrl = encodeURI(httpUrl + "?" + httpParams);  // get ��û�� : "/test.jsp?id=admin&pw=1111"
	}
	
	// 2-1: http�޼�������, ����url(���Ȼ� ���� ������ ��ġ��Ŵ), �񵿱�(true ũ�ν������� ����)/����(false) �������
	xhr.open(httpMethod, httpUrl, true);  
	xhr.setRequestHeader(
		'Content-Type', 'application/x-www-form-urlencoded');
	xhr.onreadystatechange = callback;		// readyState ����� �ݹ��Լ�ȣ��
	xhr.send(httpMethod == 'POST' ? httpParams : null);  // 2-2
}


/* ****************************************************************
 3. ���� �Ľ� ó���ϱ�                                           
*******************************************************************
���䵥���� �����Ϸ� �� ��û ������ ���� ó���ϱ�
���� ���䵵���ϸ� status ������Ƽ ����ؼ� ��û ���� ���࿩�� Ȯ�� 
readyState == 4 && status == 200
********************************************************************/
function callbackFunction() {
	if (xhr.readyState == 4 && xhr.status == 200) {
		// ���䵥���͵��� �� ��û �������
		// 1. ���� : Text ������
		var result = xhr.responseText;

		// 2. ���� : XML ������
	} else {
		alert("�����߻� : " + xhr.status);
	}
}

