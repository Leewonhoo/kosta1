$(document).ready(function() {   
  $('.result').hide();
  
  $('.submit').click(function(event){
    var data=$('.infobox').val();  // 입력받은 데이터를 추출

    if(validate_data(data)) {
//    if(isEmail(data)) {    
      $('.result').show().text(validate_data(data));
      event.preventDefault();
    } else {
      $('.result').hide();
    }
   });
});

/* 정규식 검증 함수
 * ## 정규식 표현방식
 * 1) var regExp1 = new RegExp(/정규표현식/);
 * 2) var regExp2 = /정규표현식/;
 * 
 * ## 정규표현식객체 제공메서드 
 *  - test() : 표현식 검증해서 올바르면 true 반환 / 위배되면 false
 */
// 정규식 검증 함수
function validate_data(take) {
	//var pattern = new RegExp(/[0-9]+/);
	//var pattern = /[a-zA-Z0-9_]/;  
	var pattern = /B\d{4}/;
	//var pattern = /(\d|.)+\@(\d|.)+\.[a-z]+/;
	//var pattern = /(\d|.)+\@(\d|.)+/;
	return pattern.test(take);
}

/* 이메일형식 검증 : 
 * - 문자열@문자열.문자열
 * - (\d|.)+\@(\d|.)+ 
 * - (\d|.)+\@(\d|.)+\.[a-z]+ 
 */
function isEmail(take) {
	var pattern = new RegExp(/(\d|.)+\@(\d|.)+/);
	return pattern.test(take);	
}

/* 숫자만 가능 검증 */
function isNumeric(take) {
	var pattern = new RegExp(/[0-9]+/);
	return pattern.test(take);	
};

/* +, -, 숫자 가능 검증 */
function isNumericSign(take) {
	
}