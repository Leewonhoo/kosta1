//  Highlight Text
$(document).ready(function() {
  $('.button-1').mouseover(function(){
    $('p.highlight').css({
      'background-color':'cyan',
      'font-weight':'bold',
      'color':'blue'
    });
  });
  
  //TODO : mouseout eventhandling 
  // ������ : white, �ؽ�Ʈ����: gray ����
  $('.button-1').mouseout(function(){
    $('p.highlight').css({
      'background-color':'white',
      'font-weight':'bold',
      'color':'gray'
    });
  });  
});

// Bright Image
// opacity �Ӽ� : 0(����), 1(������), 0 ~ 100
$(document).ready(function() {
	  $('img').css('opacity',0.4);

	  $('.button-2').bind('mouseover', function(){
	    $('img').css('opacity',1.0);
	  });

	  $('.button-2').bind('mouseout', function(){
	    $('img').css('opacity',0.4);
	  });

	  // ��ư Ŭ���ø��� �̹��� ũ�� ������Ŵ
	  //  TODO : ����(width) + 50 ����, ����(height) 30 ����
	  $('.button-2').bind('mousedown', function(){
		  	// ���� �̹����� ���̰����ͼ� + 50�� ���Ѱ���� ���̼Ӽ��� ����
		    $('img').css('width', function(){ return $(this).width() + 50;});
		    $('img').css('height', function(){ return $(this).height() + 30;});
	  });	  
});








