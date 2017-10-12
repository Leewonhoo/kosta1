$(document).ready(function() {
  $('p#message1').css({'border': '2px solid', 'text-align': 'center','font-weight':'bold'}).hide();
  $('p#message2').css({'backgroundColor': '#f00','color':'#fff','text-align': 'center', 'font-weight':'bold'}).click(
    function(){
      $(this).slideUp('fast');
      $('p#message1').slideDown('slow');
    }
  );
  
  // TODO: p#message1 클릭하면 슬라이드업시키고, p#message2를 슬라이드다운되도록 처리
  $('p#message1').css({'backgroundColor': '#fff','color':'#000','text-align': 'center', 'font-weight':'bold'}).click(
    function(){
      $(this).slideUp('fast');
      $('p#message2').slideDown('slow');
    }
  );
  
});