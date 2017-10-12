// 전화번호 : 숫자, -, +
$(document).ready(function() {   
  $('.error').hide();
  $('.submit').click(function(event){
    var data=$('.infobox').val();
    if(validate_phoneno(data)) {
      $('.error').hide();
    } else {
      $('.error').show();
      event.preventDefault();
    }
   });
 });

function validate_phoneno(ph) {
  //var pattern=new RegExp(/^[0-9-+]+$/);
  var pattern=new RegExp(/\d{2,3}-\d{4}-\d{4}/);
  return pattern.test(ph);
}