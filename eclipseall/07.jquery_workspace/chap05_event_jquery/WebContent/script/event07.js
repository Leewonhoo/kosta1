$(document).ready(function() {
  $('p#message1').css({'border': '2px solid', 'text-align': 'center','font-weight':'bold'}).hide();
  $('p#message2').css({'backgroundColor': '#f00','color':'#fff','text-align': 'center', 'font-weight':'bold'}).click(
    function(){
      $(this).slideUp('fast');
      $('p#message1').slideDown('slow');
    }
  );
  
  // TODO: p#message1 Ŭ���ϸ� �����̵����Ű��, p#message2�� �����̵�ٿ�ǵ��� ó��
  $('p#message1').css({'backgroundColor': '#fff','color':'#000','text-align': 'center', 'font-weight':'bold'}).click(
    function(){
      $(this).slideUp('fast');
      $('p#message2').slideDown('slow');
    }
  );
  
});