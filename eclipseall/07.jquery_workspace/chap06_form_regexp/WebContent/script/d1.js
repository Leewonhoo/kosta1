$(document).ready(function() {   
  $('.result').hide();
  
  $('.submit').click(function(event){
    var data=$('.infobox').val();  // �Է¹��� �����͸� ����

    if(validate_data(data)) {
//    if(isEmail(data)) {    
      $('.result').show().text(validate_data(data));
      event.preventDefault();
    } else {
      $('.result').hide();
    }
   });
});

/* ���Խ� ���� �Լ�
 * ## ���Խ� ǥ�����
 * 1) var regExp1 = new RegExp(/����ǥ����/);
 * 2) var regExp2 = /����ǥ����/;
 * 
 * ## ����ǥ���İ�ü �����޼��� 
 *  - test() : ǥ���� �����ؼ� �ùٸ��� true ��ȯ / ����Ǹ� false
 */
// ���Խ� ���� �Լ�
function validate_data(take) {
	//var pattern = new RegExp(/[0-9]+/);
	//var pattern = /[a-zA-Z0-9_]/;  
	var pattern = /B\d{4}/;
	//var pattern = /(\d|.)+\@(\d|.)+\.[a-z]+/;
	//var pattern = /(\d|.)+\@(\d|.)+/;
	return pattern.test(take);
}

/* �̸������� ���� : 
 * - ���ڿ�@���ڿ�.���ڿ�
 * - (\d|.)+\@(\d|.)+ 
 * - (\d|.)+\@(\d|.)+\.[a-z]+ 
 */
function isEmail(take) {
	var pattern = new RegExp(/(\d|.)+\@(\d|.)+/);
	return pattern.test(take);	
}

/* ���ڸ� ���� ���� */
function isNumeric(take) {
	var pattern = new RegExp(/[0-9]+/);
	return pattern.test(take);	
};

/* +, -, ���� ���� ���� */
function isNumericSign(take) {
	
}