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
  // 배경색상 : white, 텍스트색상: gray 변경
  $('.button-1').mouseout(function(){
    $('p.highlight').css({
      'background-color':'white',
      'font-weight':'bold',
      'color':'gray'
    });
  });  
});

// Bright Image
// opacity 속성 : 0(투명), 1(불투명), 0 ~ 100
$(document).ready(function() {
	  $('img').css('opacity',0.4);

	  $('.button-2').bind('mouseover', function(){
	    $('img').css('opacity',1.0);
	  });

	  $('.button-2').bind('mouseout', function(){
	    $('img').css('opacity',0.4);
	  });

	  // 버튼 클릭시마다 이미지 크기 증가시킴
	  //  TODO : 넓이(width) + 50 증가, 높이(height) 30 증가
	  $('.button-2').bind('mousedown', function(){
		  	// 기존 이미지의 넓이가져와서 + 50을 더한결과로 넓이속성값 설정
		    $('img').css('width', function(){ return $(this).width() + 50;});
		    $('img').css('height', function(){ return $(this).height() + 30;});
	  });	  
});








