$(document).ready(function() {   
  $('.error').hide();
  $('.submit').click(function(event){
    var data=$('.infobox').val();
    var len=data.length;
    var c;
    for(var i=0;i<len;i++) {
      c=data.charAt(i).charCodeAt(0);
      // ascii code로 숫자데이터 검증 : 0(48) ~ 9(57)
      if(c <48 || c >57) {
        $('.error').show();
        event.preventDefault();
        break;
      } else {
        $('.error').hide();
      }
    }
  });
});
