var ajax = {};		// top package ����
ajax.xhr = {};		// top.sub package ����

/*  ajax.xhr ��Ű�� Request Ŭ���� ������ ����
	��ü������ send() �޼��� ȣ�� */
ajax.xhr.Request = function(url, params, callback, method) {
	this.url = url;
	this.params = params;
	this.callback = callback;
	this.method = method;
	this.send();
}
/*  ajax.xhr ��Ű�� Request Ŭ���� �޼��� ���� */
ajax.xhr.Request.prototype = {
	getXMLHttpRequest: function() {
		if (window.ActiveXObject) {
			try {
				return new ActiveXObject("Msxml2.XMLHTTP");
			} catch(e) {
				try {
					return new ActiveXObject("Microsoft.XMLHTTP");
				} catch(e1) { return null; }
			}
		} else if (window.XMLHttpRequest) {
			return new XMLHttpRequest();
		} else {
			return null;
		}		
	},
	send: function() {
		this.req = this.getXMLHttpRequest();
		
		var httpMethod = this.method ? this.method : 'GET';
		if (httpMethod != 'GET' && httpMethod != 'POST') {
			httpMethod = 'GET';
		}
		var httpParams = (this.params == null || this.params == '') ? null : this.params;
		var httpUrl = this.url;
		if (httpMethod == 'GET' && httpParams != null) {
			httpUrl = encodeURI(httpUrl + "?" + httpParams);
		}
		this.req.open(httpMethod, httpUrl, true);
		this.req.setRequestHeader(
			'Content-Type', 'application/x-www-form-urlencoded');
		
		// XMLHttpRequest ��ü�� readyState ���� ����ɶ� this request ��ü�� onStateChange() �Լ� ȣ��
		var request = this;
		this.req.onreadystatechange = function() {
			// �Լ���.call()  �ش��Լ��� ȣ������ �ǹ�
			// request ���ڴ� ȣ���ϴ� �Լ��� onStateChange() �Լ������� this�� �� ��ü�� �ǹ�
			request.onStateChange.call(request);		
		}
		this.req.send(httpMethod == 'POST' ? httpParams : null);
	},
	onStateChange: function() {
		this.callback(this.req);	// this.callback() => ajax.xhr.Request , this.req => XMLHttpRequest
	}
}
